package com.sqli.customerservice.services;

import com.sqli.customerservice.dto.CustomerRequestDto;
import com.sqli.customerservice.exception.ServiceException;
import com.sqli.customerservice.services.Impl.CustomerServiceImpl;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log
public class KafKaTopicListeners {

    private final Logger logger = LoggerFactory.getLogger(KafKaTopicListeners.class);
@Autowired
CustomerServiceImpl customerService;
    @KafkaListener(topics = {"general-task-topic"}, groupId = "task-group")
    public void consume(CustomerRequestDto customerRequestDto) throws ServiceException {

        logger.info(String.format("Task status is updated : " + customerRequestDto));

        customerService.create(customerRequestDto);
    }
}
