package com.sqli.customerservice.dto;

public record AdminRequestDto(Long adminId, String fullName, String mobile, String email,String password) {
}
