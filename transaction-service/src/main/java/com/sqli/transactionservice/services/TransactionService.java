package com.sqli.transactionservice.services;

import com.sqli.transactionservice.dto.TransactionRequestDto;

import java.math.BigDecimal;

public interface TransactionService {

    void createTransaction(TransactionRequestDto transactionRequestDto);

    boolean isBalanceAvailable(Long accountFrom , BigDecimal amount);
}
