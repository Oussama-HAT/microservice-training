package com.sqli.customerservice.enums;

public enum Gender {

    MEN(" MEN"),
    WOMEN("WOMEN");

    private final String code;

    Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
