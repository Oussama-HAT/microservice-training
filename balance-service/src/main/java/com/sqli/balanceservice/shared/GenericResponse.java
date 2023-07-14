package com.sqli.balanceservice.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse {
    private String message;
    private List<String> details;

    public GenericResponse(String message) {
        super();
        this.message = message;
    }
}
