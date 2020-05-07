package com.bzmxl.kafka.consumer.listener;

import com.bzmxl.kafka.consumer.domain.KafkaMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafKaListener {
    @KafkaListener(topics = "bzmxl", groupId = "kafka-group")
    public void listen(KafkaMsg message) {
        log.info("Received Message : " + message.toString());
    }
}