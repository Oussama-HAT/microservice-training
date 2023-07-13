package com.sqli.administrationservice.exception;

import lombok.Getter;

@Getter
public class ServiceException extends Exception {

    private static final long serialVersionUID = 1L;

    private final String code;
    private String codes[];
    private String messages[];

    public ServiceException(String code, String errorMessage) {
        super(errorMessage);
        this.code = code;
    }

    public ServiceException(String code, String errorMessage, String messages[], String codes[]) {
        super(errorMessage);
        this.codes = codes;
        this.messages = messages;
        this.code = code;
    }
}
