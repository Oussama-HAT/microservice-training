package com.sqli.balanceservice.dto;

import java.math.BigDecimal;

public record BalanceDto(Long accountFrom, Long accountTo, BigDecimal amount) {
}
