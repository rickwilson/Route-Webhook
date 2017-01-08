package core.entities.enums;

public enum OmniTrackingState {
    ACTIVE("Shipping in process. Waiting for Delivered."),
    COMPLETE("Shipment delivered."),
    FAILED("Tracking failed or order was not delivered.");

    private final String name;

    OmniTrackingState(String name){
        this.name = name;
    }

    public String getName(){

        return this.name;
    }
}
