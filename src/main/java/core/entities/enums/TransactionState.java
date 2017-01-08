package core.entities.enums;

public enum TransactionState {
    NEW("Order Info Received"),
    WAITING_FOR_SHIPPED("Waiting For Order Shipped"),
    SHIPPED_WAITING_FOR_ROUTE_ORDER("Route Order Scheduled"),
    COMPLETE_UNBILLED("Route Order Complete - Not Billed"),
    COMPLETE_BILLED("Route Order Complete - Billed"),
    PAID("Route Order Complete"),
    VOIDED("Order Voided"),
    ERROR("Error"),
    FAILED("Failed"),
    INSURANCE_NOT_SELECTED("Insurance Not Selected"),
    TEST("TEST"),
    QUOTE_REQUESTED("Route Quote Requested"),
    SHIPPED_WAITING_FOR_DELIVERED("Route order is shipped and waiting for delivery confirmation"),
    COMPLETE("Route Transaction Complete");

    private final String name;

    TransactionState(String name){
        this.name = name;
    }

    public String getName(){

        return this.name;
    }
}
