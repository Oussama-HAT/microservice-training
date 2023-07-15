package com.sqli.transactionservice.dto;

import java.math.BigDecimal;

public record BalanceRequestDto(Long accountFrom, Long accountTo, BigDecimal amount) {
}
