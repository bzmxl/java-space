package com.bzmxl.kafka.consumer.listener;

import com.alibaba.fastjson.JSON;
import com.bzmxl.kafka.consumer.config.KafKaConfiguration;
import com.bzmxl.kafka.consumer.domain.KafkaMsg;
import com.bzmxl.kafka.consumer.tasks.KafkaAsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Component
public class KafKaListener implements CommandLineRunner {
    @Autowired
    private ConsumerFactory<String, String> consumerFactory;
    @Autowired
    private KafKaConfiguration kafKaConfiguration;
    @Autowired
    private KafkaAsyncTask kafkaAsyncTask;

    public static final AtomicBoolean isRunning = new AtomicBoolean(true);

    @Override
    public void run(String... args) throws Exception {
        Consumer<String, String> consumer = consumerFactory.createConsumer();
        consumer.subscribe(Arrays.asList(kafKaConfiguration.getTopicName()));
        long lastConsumedOffset = -1;
        try {
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                if (records.isEmpty()) {
                    continue;
                }
                for (TopicPartition tp : records.partitions()) {
                    List<ConsumerRecord<String, String>> partitionRecords = records.records(tp);
                    if (partitionRecords.isEmpty()) {
                        continue;
                    }
                    log.info("===============TopicPartition==================" + tp.partition());
                    List<KafkaMsg> buffer = new ArrayList<>();
                    for (ConsumerRecord<String, String> record : partitionRecords) {
                        log.info("==========KafkaMsg==offset====" + record.offset());
                        buffer.add(JSON.parseObject(record.value(), KafkaMsg.class));
                    }
                    if (buffer.size() >= partitionRecords.size()) {
                        kafkaAsyncTask.deal(buffer);
                        lastConsumedOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
                        consumer.commitAsync(Collections.singletonMap(tp, new OffsetAndMetadata(lastConsumedOffset + 1)), (map, e) -> {
                            if (null == e) {
                                log.info("===commitAsync===OK==");
                            } else {
                                log.error("======commitAsync Error======={}", e.getMessage());
                                consumer.committed(tp);
                                log.info("===committed===OK==");
                            }
                        });
                    }
                }
            }
        } catch (Exception e) {
            log.error("==consumer==Exception=={}", e.getMessage());
        } finally {
            consumer.close();
        }
    }
}