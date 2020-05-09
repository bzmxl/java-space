package com.bzmxl.kafka.consumer.tasks;

import com.bzmxl.kafka.consumer.domain.KafkaMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class KafkaAsyncTask {
    @Async("CallerRunsPolicy")
    public void deal(List<KafkaMsg> kafkaMsgList) {
        log.info("======KafkaAsyncTask====" + Thread.currentThread().getId());
        for (KafkaMsg kafkaMsg : kafkaMsgList) {
            log.info("===consumer==KafkaAsyncTask======" + System.currentTimeMillis() + "=====" + kafkaMsg);
        }
    }
}