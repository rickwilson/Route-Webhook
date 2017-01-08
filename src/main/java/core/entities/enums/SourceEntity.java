package core.entities.enums;

public enum SourceEntity {
    UNKNOWN("Unknown data source."),
    ORDER_API("Order API."),
    KONNECTIVE_INTEGRATED("Konnektive integration."),
    LIME_LIGHT_INTEGRATED("LimeLight integration.");

    private final String name;

    SourceEntity(String name){
        this.name = name;
    }

    public String getName(){

        return this.name;
    }
}
