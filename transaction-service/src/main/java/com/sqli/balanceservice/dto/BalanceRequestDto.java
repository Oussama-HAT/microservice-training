package com.sqli.balanceservice.dto;

import java.math.BigDecimal;

public record BalanceRequestDto(Long accountId, String accountType, BigDecimal balance) {
}
