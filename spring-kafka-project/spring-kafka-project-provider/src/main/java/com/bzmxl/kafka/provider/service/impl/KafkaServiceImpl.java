package com.bzmxl.kafka.provider.service.impl;

import com.bzmxl.kafka.provider.config.KafKaConfiguration;
import com.bzmxl.kafka.provider.domain.KafkaMsg;
import com.bzmxl.kafka.provider.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
public class KafkaServiceImpl implements KafkaService {
    @Autowired
    private KafkaTemplate<String, KafkaMsg> kafkaTemplate;

    @Autowired
    private KafKaConfiguration kafKaConfiguration;

    @Override
    public void sendAsync(KafkaMsg kafkaMsg) {
        final ProducerRecord<String, KafkaMsg> record = new ProducerRecord<>(kafKaConfiguration.getTopicName(), kafkaMsg);
        ListenableFuture<SendResult<String, KafkaMsg>> future = kafkaTemplate.send(record);
        future.addCallback(new ListenableFutureCallback<SendResult<String, KafkaMsg>>() {
            @Override
            public void onSuccess(SendResult<String, KafkaMsg> stringKafkaMsgSendResult) {
                handleSuccess(stringKafkaMsgSendResult.getProducerRecord().value());
            }

            @Override
            public void onFailure(Throwable throwable) {
                handleFailure(throwable);
            }
        });
    }

    private void handleSuccess(KafkaMsg kafkaMsg) {
        log.info("======handleSuccess=======" + kafkaMsg);
    }

    private void handleFailure(Throwable throwable) {
        log.info("======handleFailure======={}" + throwable.getMessage());
    }
}