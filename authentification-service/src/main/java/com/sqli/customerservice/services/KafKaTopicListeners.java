package com.sqli.customerservice.services;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log
public class KafKaTopicListeners {

    private final Logger logger = LoggerFactory.getLogger(KafKaTopicListeners.class);

//    @KafkaListener(topics = {"general-task-topic"}, groupId = "task-group")
//    public void consume(String taskStatus) {
//
//        logger.info(String.format("Task status is updated : " + taskStatus));
//    }
}
