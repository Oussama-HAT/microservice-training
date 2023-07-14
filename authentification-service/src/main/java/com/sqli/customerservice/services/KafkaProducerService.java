package com.sqli.customerservice.services;

import com.sqli.customerservice.dto.CustomerRequestDto;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log
public class KafkaProducerService {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    KafkaTemplate<String, CustomerRequestDto> kafkaTemplate;

    public void send(String topicName, CustomerRequestDto customerDto) {

      //  var future =
                kafkaTemplate.send(topicName, customerDto);

//        future.whenComplete((sendResult, exception) -> {
//            if (exception != null) {
//                future.completeExceptionally(exception);
//            } else {
//                future.complete(sendResult);
//            }
//            LOGGER.info("Task status send to Kafka topic : "+ customerDto.getAccountNo());
//        });
    }
}
