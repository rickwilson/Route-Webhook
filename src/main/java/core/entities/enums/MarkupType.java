package core.entities.enums;

public enum MarkupType {
    ADD_PERCENT("Customer price is a set percent over cost. Merchant keeps the difference."),
    ADD_FIXED("Customer price is a fixed amount over cost. Merchant keeps the difference."),
    MACHINE_LEARNING("Customer price is machine calculated for optimal uptake. Never less than cost. Merchant keeps the difference."),
    COST("Customer pays the actual price of insurance. Merchant has no loss or profit on insurance."),
    FREE("Customer pays nothing for insurance. Merchant pays the total cost of insurance."),
    SUBTRACT_PERCENT("Customer price is a set percent under cost. Merchant pays the difference."),
    SUBTRACT_FIXED("Customer price is a fixed amount under cost. Merchant pays the difference.");

    private final String name;

    MarkupType(String name){
        this.name = name;
    }

    public String getName(){

        return this.name;
    }
}
