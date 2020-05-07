package com.bzmxl.kafka.provider.service;

import com.bzmxl.kafka.provider.domain.KafkaMsg;

public interface KafkaService {
    void sendAsync(KafkaMsg kafkaMsg);
}