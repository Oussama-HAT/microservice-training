package com.sqli.customerservice.dto;

import com.sqli.customerservice.enums.Gender;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class CustomerRequestDto {
    Long accountNo; String fullName; Gender gender; Date birthDate; String mobile; String email;
}
