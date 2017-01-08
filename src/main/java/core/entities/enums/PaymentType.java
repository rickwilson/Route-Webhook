package core.entities.enums;

public enum PaymentType {
    CREDIT_CARD("Credit Card"),
    CASH("Cash"),
    CHECK("Check"),
    OTHER("Not check, cash, or credit card");

    private final String name;

    PaymentType(String name){this.name = name;}

    public String getName(){return this.name;}
}
