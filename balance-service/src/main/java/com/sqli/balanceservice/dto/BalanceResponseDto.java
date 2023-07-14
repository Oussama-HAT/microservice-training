package com.sqli.balanceservice.dto;

import java.math.BigDecimal;

public record BalanceResponseDto(Long accountId, String accountType, BigDecimal balance) {
}
