package com.kafka.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @KafkaListener(topics = "sample_topic", groupId = "sample_group_id")
    public void consume(String message) {
        log.info("### consumer message --> " + message);
    }
}
