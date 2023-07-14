package com.sqli.balanceservice.services;

import com.sqli.balanceservice.dto.BalanceRequestDto;
import com.sqli.balanceservice.dto.BalanceResponseDto;

import java.math.BigDecimal;

public interface BalanceService {

    BalanceResponseDto getBalance(Long accountId);

    void createBalance(BalanceRequestDto balanceRequestDto);

    boolean isBalanceAvailable(Long accountId);

    void updateBalance(Long accountFrom , Long accountTo, BigDecimal amount);

}
