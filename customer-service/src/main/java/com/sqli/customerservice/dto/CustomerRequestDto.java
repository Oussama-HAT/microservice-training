package com.sqli.customerservice.dto;

import com.sqli.customerservice.enums.Gender;

import java.util.Date;

public record CustomerRequestDto(Long accountNo, String fullName, Gender gender, Date birthDate,String mobile,String email) {
}
