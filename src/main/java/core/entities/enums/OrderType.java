package core.entities.enums;

public enum OrderType {
    PRODUCT("Physical Items"),
    DIGITAL("Software, images, data..."),
    SERVICE("Work performed"),
    OTHER("Not product, digital, or service"),
    UNKNOWN("No Order Type Provided");

    private final String name;

    OrderType(String name){this.name = name;}

    public String getName(){return this.name;}
}
