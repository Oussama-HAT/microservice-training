package com.sqli.administrationservice.dto;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public record AdminRequestDto(Long adminId, String fullName, String mobile, String email,String password) {
}
