package com.sqli.customerservice.enums;

public enum Gender {

    MAN(" MAN"),
    WOMEN("WOMEN");

    private final String code;

    Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
