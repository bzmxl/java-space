package com.bzmxl.kafka.consumer.config;

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
    @Value("${kafka.group.id}")
    private String groupId;
    @Value("${kafka.auto.offset.reset}")
    private String offsetReset;
    @Value("${kafka.enable.auto.commit}")
    private String autoCommit;
    @Value("${kafka.client.id}")
    private String clientId;
}