package com.sqli.customerservice.dto;

public class LoginRequest {
    private String username;
    private String password;

    // Constructors, getters, and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
