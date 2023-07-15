package com.sqli.transactionservice.services.impl;

import com.sqli.transactionservice.dto.BalanceRequestDto;
import com.sqli.transactionservice.dto.TransactionRequestDto;
import com.sqli.transactionservice.entities.Transaction;
import com.sqli.transactionservice.mapper.TransactionMapper;
import com.sqli.transactionservice.repository.TransactionRepository;
import com.sqli.transactionservice.services.KafkaProducerService;
import com.sqli.transactionservice.services.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final WebClient webClient;
    private final KafkaProducerService kafkaProducerService;
    @Override
    @Transactional
    public void createTransaction(TransactionRequestDto transactionRequestDto) {
        if(this.isBalanceAvailable(transactionRequestDto.accountFrom(), transactionRequestDto.amount())){
           throw new RuntimeException("Balance not available");
        }
        Transaction transaction = transactionMapper.dtoToEntity(transactionRequestDto);
        transactionRepository.save(transaction);
        BalanceRequestDto balanceRequestDto = new BalanceRequestDto(transactionRequestDto.accountFrom(), transactionRequestDto.accountTo(), transactionRequestDto.amount());
        kafkaProducerService.send("transaction-topic", balanceRequestDto);
    }

    @Override
    public boolean isBalanceAvailable(Long accountFrom , BigDecimal amount) {
        return Boolean.TRUE.equals(webClient.get()
                .uri("http://balance-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("accountId", accountFrom).queryParam("amount", amount).build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block());
    }
}
