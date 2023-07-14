package com.sqli.customerservice.dto;

public record AccountRequestDto(Long accountNo, String username, String password,String token) {
}
