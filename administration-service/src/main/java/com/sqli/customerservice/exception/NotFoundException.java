package com.sqli.customerservice.exception;

public class NotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    private final String code;

    public NotFoundException(String code, String errorMessage) {
        super(errorMessage);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
