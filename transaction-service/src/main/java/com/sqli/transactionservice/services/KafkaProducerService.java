package com.sqli.transactionservice.services;

import com.sqli.transactionservice.dto.BalanceRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log
public class KafkaProducerService {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);
    private final KafkaTemplate<String, BalanceRequestDto> kafkaTemplate;

    public void send(String topicName, BalanceRequestDto balanceRequestDto) {
        kafkaTemplate.send(topicName, balanceRequestDto);
    }
}
