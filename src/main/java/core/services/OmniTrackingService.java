package core.services;

import core.entities.*;
import core.entities.enums.OmniTrackingState;
import core.entities.enums.TransactionState;
import core.outbound.MailedIt;
import core.thirdParty.aftership.classes.Checkpoint;
import core.thirdParty.aftership.classes.ShippingTrackingWebHook;
import core.thirdParty.aftership.classes.Tracking;
import core.thirdParty.aftership.enums.ISO3Country;
import core.thirdParty.aftership.enums.StatusTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Service
public class OmniTrackingService {
    private final OmniTrackingDAO omniTrackingDAO;
    private final OmniTrackingDetailDAO omniTrackingDetailDAO;
    private final OmniTransactionDAO omniTransactionDAO;
    private final OmniTransactionDetailDAO omniTransactionDetailDAO;
    private final CourierNameService courierNameService;
    private final MailedIt mailedIt;

    @Autowired
    public OmniTrackingService(OmniTrackingDAO omniTrackingDAO,
                               OmniTrackingDetailDAO omniTrackingDetailDAO,
                               OmniTransactionDAO omniTransactionDAO,
                               OmniTransactionDetailDAO omniTransactionDetailDAO,
                               CourierNameService courierNameService,
                               MailedIt mailedIt) {
        Assert.notNull(omniTrackingDAO, "OmniTrackingDAO must not be null!");
        Assert.notNull(omniTrackingDetailDAO, "OmniTrackingDetailDAO must not be null!");
        Assert.notNull(omniTransactionDAO, "OmniTransactionDAO must not be null!");
        Assert.notNull(omniTransactionDetailDAO, "OmniTransactionDetailDAO must not be null!");
        Assert.notNull(courierNameService, "CourierNameService must not be null!");
        Assert.notNull(mailedIt, "MailedIt must not be null!");
        this.omniTrackingDAO = omniTrackingDAO;
        this.omniTrackingDetailDAO = omniTrackingDetailDAO;
        this.omniTransactionDAO = omniTransactionDAO;
        this.omniTransactionDetailDAO = omniTransactionDetailDAO;
        this.courierNameService = courierNameService;
        this.mailedIt = mailedIt;
    }

    public void updateOmniTracking(ShippingTrackingWebHook shippingTrackingWebHook) {
        Tracking tracking = shippingTrackingWebHook.getMsg();
        OmniTracking omniTracking = omniTrackingDAO.findByAftershipTrackingId(tracking.getId());
        if(omniTracking == null || omniTracking.getId() < 1) {
            mailedIt.generateAndSendEmail(envVariableService.getAdminEmailAddress(),"FAILED trackingUpdate","FAILED trackingUpdate - no matching omniTracking object for Aftership ID: "+tracking.getId()+"<br>OmniTrackingService.updateOmniTracking<br>"+tracking.toString(),false,"OmniTrackingService.updateOmniTracking");
        } else {
            omniTracking.setDeliveryTime(tracking.getDeliveryTime());
            omniTracking.setActive(tracking.isActive());
            if(!omniTracking.isActive()) {
                if(tracking.getTag().equals(StatusTag.Exception) || tracking.getTag().equals(StatusTag.Expired)) {
                    omniTracking.setOmniTrackingState(OmniTrackingState.FAILED);
                } else {
                    omniTracking.setOmniTrackingState(OmniTrackingState.COMPLETE);
                }
            } else {
                if(tracking.getTag().equals(StatusTag.Delivered)) {
                    omniTracking.setOmniTrackingState(OmniTrackingState.COMPLETE);
                    omniTracking.setActive(false);
                } else {
                    omniTracking.setOmniTrackingState(OmniTrackingState.ACTIVE);
                }
            }
            omniTracking.setExpectedDelivery(tracking.getExpectedDelivery());
            omniTracking.setSignedBy(tracking.getSignedBy());
            omniTracking.setTag(tracking.getTag());
            omniTracking.setSlug(tracking.getSlug());
            if(tracking.getDestinationCountryISO3() != null) {
                omniTracking.setDestinationCountryISO3(tracking.getDestinationCountryISO3());
            }
            omniTracking.setCustomerName(tracking.getCustomerName());
            omniTracking.setOriginCountryISO3(tracking.getOriginCountryISO3());
            omniTracking.setOrderIDPath(tracking.getOrderIDPath());
            omniTracking.setShipmentPackageCount(tracking.getShipmentPackageCount());
            omniTracking.setShipmentType(tracking.getShipmentType());
            omniTracking.setSource(tracking.getSource());
            omniTracking.setTitle(tracking.getTitle());
            omniTracking.setTrackingAccountNumber(tracking.getTrackingAccountNumber());
            omniTracking.setTrackingPostalCode(tracking.getTrackingPostalCode());
            omniTracking.setTrackingShipDate(tracking.getTrackingShipDate());
            omniTracking.setLastUpdatedDateTime(LocalDateTime.now());
            omniTracking.setReceivedPush(true);
            omniTrackingDAO.save(omniTracking);
            String lastCheckpointTag = "";
            List<OmniTrackingDetail> omniTrackingDetails = omniTrackingDetailDAO.findByOmniTrackingId(omniTracking.getId());
            if(tracking.getCheckpoints().size() > omniTrackingDetails.size()) {
                omniTrackingDetailDAO.delete(omniTrackingDetails);
                lastCheckpointTag = updateCheckpoints(tracking, omniTracking.getId(), omniTracking.getAccountId());
            }

            for(OmniTransaction omniTransaction : omniTransactionDAO.findByOmniTrackingId(omniTracking.getId())) {
                omniTransaction.setShippingStatusTag(tracking.getTag());
                if(tracking.getSlug() == null || tracking.getSlug().trim().length() < 1) {
                    omniTransaction.setShippingCarrierCode("UNKNOWN (OTS-UOT)");
                    omniTransaction.setShippingCarrierName("Unknown");
                } else {
                    omniTransaction.setShippingCarrierCode(tracking.getSlug());
                    omniTransaction.setShippingCarrierName(courierNameService.getCourierName(tracking.getSlug()));
                }
                if(tracking.getTag().equals(StatusTag.Exception) || tracking.getTag().equals(StatusTag.Expired) || tracking.getTag().equals(StatusTag.Delivered)) {
                    omniTransaction.setTransactionState(TransactionState.COMPLETE);
                }
                omniTransactionDAO.save(omniTransaction);
                omniTransactionDetailDAO.save(new OmniTransactionDetail(omniTransaction.getAccountId(),omniTransaction.getId(),"Shipping Update: Tracking Tag - "+omniTracking.getTag()+" Checkpoint Tag - "+lastCheckpointTag,omniTransaction.getTransactionState()));
            }
        }
    }

    private String updateCheckpoints(Tracking tracking, long omniTrackingId, long accountId) {
        String lastCheckpointTag = "";
        for (Checkpoint checkpoint : tracking.getCheckpoints()) {
            OmniTrackingDetail omniTrackingDetail =
                    new OmniTrackingDetail(
                            omniTrackingId,
                            accountId,
                            checkpoint.getCreatedAt(),
                            checkpoint.getCheckpointTime(),
                            checkpoint.getCity(),
                            checkpoint.getCountryISO3(),
                            checkpoint.getCountryName(),
                            checkpoint.getMessage(),
                            checkpoint.getState(),
                            checkpoint.getTag(),
                            checkpoint.getZip(),
                            checkpoint.getLocation());
            omniTrackingDetailDAO.save(omniTrackingDetail);
            lastCheckpointTag = omniTrackingDetail.getTag();
        }
        return lastCheckpointTag;
    }
}
