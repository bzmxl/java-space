package com.bzmxl.kafka.provider.tasks;

import com.bzmxl.kafka.provider.config.KafKaConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class KafkaAsyncTask {
    //使用线程池的方式发送任务
    //生产者线程安全，消费者线程不安全
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafKaConfiguration kafKaConfiguration;

    @Async("CallerRunsPolicy")
    public void send(final String msg) {
        log.info("============" + Thread.currentThread().getId());
        //没有key，使用轮询
        final ProducerRecord<String, String> record = new ProducerRecord<>(kafKaConfiguration.getTopicName(), msg);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(record);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> stringKafkaMsgSendResult) {
                log.info("========handleSuccess=========" + stringKafkaMsgSendResult.getRecordMetadata().offset());
                log.info("========handleSuccess=========" + stringKafkaMsgSendResult.getProducerRecord().value());
            }

            @Override
            public void onFailure(Throwable throwable) {
                //保存在数据库表中，下次处理/或者重发
                log.error("======handleFailure======={}", throwable.getMessage());
                log.info("=====handleFailure=====" + msg);
            }
        });
    }
}