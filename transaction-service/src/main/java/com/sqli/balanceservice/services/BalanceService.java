package com.sqli.balanceservice.services;

import com.sqli.balanceservice.dto.BalanceRequestDto;

public interface BalanceService {

    BalanceRequestDto getBalance(Long accountId);
    void updateBalance(BalanceRequestDto balanceRequestDto);
}
