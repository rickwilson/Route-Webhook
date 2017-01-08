package core.entities.enums;

public enum ShippingNotificationType {
    NONE("Shipping notifactions not selected."),
    EMAIL("Email shipping notifications selected."),
    SMS("SMS shipping notifications selected."),
    EMAIL_AND_SMS("Email and SMS shipping notifications selected.");

    private final String name;

    ShippingNotificationType(String name){
        this.name = name;
    }

    public String getName(){

        return this.name;
    }
}
