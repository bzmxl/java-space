package com.bzmxl.kafka.provider.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class KafKaConfiguration {
    @Value("${kafka.bootstrap.servers}")
    private String bootstrapServers;
    @Value("${kafka.topic.name}")
    private String topicName;
    @Value("${kafka.topic.partitions}")
    private int topicPartitions;
    @Value("${kafka.topic.replicas}")
    private short topicReplicas;
}