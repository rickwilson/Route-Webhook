package core.entities;

import core.entities.enums.OmniTrackingState;
import core.thirdParty.aftership.enums.ISO3Country;
import core.thirdParty.aftership.enums.StatusTag;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class OmniTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(nullable = false)
    private long accountId;

    @NotNull
    @Column(nullable = false)
    private OmniTrackingState omniTrackingState;

    /**Identifier of the tracking in the Aftership system*/
    private String aftershipTrackingId;

    /**Tracking number of a shipment. Duplicate tracking numbers, or tracking number with invalid tracking
     * number format will not be accepted. */
    private String trackingNumber;

    /**Unique code of each courier. If you do not specify a slug, Aftership will automatically detect
     * the courier based on the tracking number format and your selected couriers*/
    private String slug;

    private String courierName;

    /** Title of the tracking. Default value as trackingNumber */
    private String title;

    /** Customer name of the tracking. */
    private String customerName;

    /**Total delivery time in days, calculated by the time difference of first checkpoint time and delivered
     * time for delivered shipments, and that and current time for non-delivered shipments. Value as '0' for
     * pending shipments or delivered shipment with only one checkpoint.*/
    private int deliveryTime;

    /** ISO Alpha-3(three letters)to specify the destination of the shipment.
     * If you use postal service to send international shipments, AfterShip will automatically
     * get tracking results at destination courier as well (e.g. USPS for USA). */
    private ISO3Country destinationCountryISO3;

    /**  Origin country of the tracking. ISO Alpha-3 */
    private ISO3Country originCountryISO3;

    /** Text field for Order ID */
    private String orderID;

    /** Text field for Order path */
    private String orderIDPath;

    /** Whether or not AfterShip will continue tracking the shipments.
     * Value is `false` when status is `Delivered` or `Expired`. */
    private boolean active;

    /** Expected delivery date (if any). */
    private String expectedDelivery;

    /**  Number	Number of packages under the tracking. */
    private int shipmentPackageCount;

    /** Shipment type provided by carrier (if any). */
    private String shipmentType;

    /** Signed by information for delivered shipment (if any). */
    private String signedBy;

    /**  Source of how this tracking is added.  */
    private String source;

    /** Current status of tracking. */
    private StatusTag tag;

    /**Tracking Account number tracking_account_number*/
    private String trackingAccountNumber;

    /**Tracking postal code tracking_postal_code*/
    private String trackingPostalCode;

    /**Tracking ship date tracking_ship_date*/
    private String trackingShipDate;

    private LocalDateTime createdByDateTime;

    private LocalDateTime lastUpdatedDateTime;

    private boolean receivedPush;

    private boolean shippingNotifications = false;
    private String notificationEmail;
    private String notificationSms;

    public OmniTracking() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public OmniTrackingState getOmniTrackingState() {
        return omniTrackingState;
    }

    public void setOmniTrackingState(OmniTrackingState omniTrackingState) {
        this.omniTrackingState = omniTrackingState;
    }

    public String getAftershipTrackingId() {
        return aftershipTrackingId;
    }

    public void setAftershipTrackingId(String aftershipTrackingId) {
        this.aftershipTrackingId = aftershipTrackingId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public ISO3Country getDestinationCountryISO3() {
        return destinationCountryISO3;
    }

    public void setDestinationCountryISO3(ISO3Country destinationCountryISO3) {
        this.destinationCountryISO3 = destinationCountryISO3;
    }

    public ISO3Country getOriginCountryISO3() {
        return originCountryISO3;
    }

    public void setOriginCountryISO3(ISO3Country originCountryISO3) {
        this.originCountryISO3 = originCountryISO3;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderIDPath() {
        return orderIDPath;
    }

    public void setOrderIDPath(String orderIDPath) {
        this.orderIDPath = orderIDPath;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(String expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public int getShipmentPackageCount() {
        return shipmentPackageCount;
    }

    public void setShipmentPackageCount(int shipmentPackageCount) {
        this.shipmentPackageCount = shipmentPackageCount;
    }

    public String getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(String shipmentType) {
        this.shipmentType = shipmentType;
    }

    public String getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(String signedBy) {
        this.signedBy = signedBy;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public StatusTag getTag() {
        return tag;
    }

    public void setTag(StatusTag tag) {
        this.tag = tag;
    }

    public String getTrackingAccountNumber() {
        return trackingAccountNumber;
    }

    public void setTrackingAccountNumber(String trackingAccountNumber) {
        this.trackingAccountNumber = trackingAccountNumber;
    }

    public String getTrackingPostalCode() {
        return trackingPostalCode;
    }

    public void setTrackingPostalCode(String trackingPostalCode) {
        this.trackingPostalCode = trackingPostalCode;
    }

    public String getTrackingShipDate() {
        return trackingShipDate;
    }

    public void setTrackingShipDate(String trackingShipDate) {
        this.trackingShipDate = trackingShipDate;
    }

    public LocalDateTime getCreatedByDateTime() {
        return createdByDateTime;
    }

    public void setCreatedByDateTime(LocalDateTime createdByDateTime) {
        this.createdByDateTime = createdByDateTime;
    }

    public LocalDateTime getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

    public void setLastUpdatedDateTime(LocalDateTime lastUpdatedDateTime) {
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    public boolean isReceivedPush() {
        return receivedPush;
    }

    public void setReceivedPush(boolean receivedPush) {
        this.receivedPush = receivedPush;
    }

    public boolean isShippingNotifications() {
        return shippingNotifications;
    }

    public void setShippingNotifications(boolean shippingNotifications) {
        this.shippingNotifications = shippingNotifications;
    }

    public String getNotificationEmail() {
        return notificationEmail;
    }

    public void setNotificationEmail(String notificationEmail) {
        this.notificationEmail = notificationEmail;
    }

    public String getNotificationSms() {
        return notificationSms;
    }

    public void setNotificationSms(String notificationSms) {
        this.notificationSms = notificationSms;
    }
}
