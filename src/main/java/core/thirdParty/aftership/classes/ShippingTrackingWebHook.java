package core.thirdParty.aftership.classes;

public class ShippingTrackingWebHook {

    private String event;
    private Tracking msg;
    private String ts;

    public ShippingTrackingWebHook() {
    }

    public ShippingTrackingWebHook(String event, Tracking msg, String ts) {
        this.event = event;
        this.msg = msg;
        this.ts = ts;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Tracking getMsg() {
        return msg;
    }

    public void setMsg(Tracking msg) {
        this.msg = msg;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}
