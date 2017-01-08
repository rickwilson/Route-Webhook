package core.controllers;

import core.outbound.MailedIt;
import core.services.OmniTrackingService;
import core.thirdParty.aftership.classes.ShippingTrackingWebHook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/shipping/tracking/v1/aa45!db33d3095c4$194b76x84af8*5d5c6488f/")
public class ShippingTrackingController {

    private final OmniTrackingService omniTrackingService;
    private final MailedIt mailedIt;

    @Autowired
    public ShippingTrackingController(OmniTrackingService omniTrackingService, MailedIt mailedIt) {
        Assert.notNull(omniTrackingService, "OmniTrackingService must not be null!");
        Assert.notNull(mailedIt, "MailedIt must not be null!");
        this.omniTrackingService = omniTrackingService;
        this.mailedIt = mailedIt;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void trackingUpdate(@RequestBody ShippingTrackingWebHook shippingTrackingWebHook) {
        if(shippingTrackingWebHook == null || shippingTrackingWebHook.getMsg() == null) {
            mailedIt.generateAndSendEmail(envVariableService.getAdminEmailAddress(),"FAILED trackingUpdate","FAILED trackingUpdate<br>ShippingTrackingController.trackingUpdate", false, "ShippingTrackingController.trackingUpdate");
            throw new IllegalArgumentException("parameter must not be null");
        } else {
            omniTrackingService.updateOmniTracking(shippingTrackingWebHook);
        }
    }
}
