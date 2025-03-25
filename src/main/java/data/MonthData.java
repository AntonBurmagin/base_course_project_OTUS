package data;

import exceptions.MonthNotFoundException;

public enum MonthData {
    MARCH("марта"),
    APRIL("апреля");


    private String name;

    MonthData(String name) {
        this.name = name;
    }

    public Integer getValue(){
        return switch (name){
            case("марта") -> 3;
            case("апреля") -> 4;
            default -> throw new MonthNotFoundException(name);
        };
    }

    static public MonthData customValueOf(String name){
        return switch (name){
            case("марта") -> MonthData.MARCH;
            case("апреля") -> MonthData.APRIL;
            default -> throw new MonthNotFoundException(name);
        };
    }

}
