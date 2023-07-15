package com.sqli.balanceservice.services;

import com.sqli.balanceservice.dto.BalanceDto;
import com.sqli.balanceservice.dto.BalanceRequestDto;
import com.sqli.balanceservice.exceptions.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log
public class KafkaTopicListeners {

    private final BalanceService balanceService;
    private final Logger logger = LoggerFactory.getLogger(KafkaTopicListeners.class);

    @KafkaListener(topics = {"transaction-topic"}, groupId = "task-group")
    public void consumeAcc(BalanceRequestDto balanceRequestDto) throws ServiceException {
        logger.info(String.format("Task status is updated : " + balanceRequestDto));
        balanceService.createBalance(balanceRequestDto);
    }

    @KafkaListener(topics = {"transaction-topic"}, groupId = "task-group")
    public void consume(BalanceDto balanceDto) throws ServiceException {
        logger.info(String.format("Task status is updated : " + balanceDto));
        balanceService.updateBalance(balanceDto);
    }
}
