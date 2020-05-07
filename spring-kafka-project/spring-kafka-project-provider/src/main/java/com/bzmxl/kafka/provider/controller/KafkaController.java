package com.bzmxl.kafka.provider.controller;

import com.bzmxl.kafka.provider.domain.KafkaMsg;
import com.bzmxl.kafka.provider.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/send")
    public void send() {
        KafkaMsg kafkaMsg = new KafkaMsg();
        String msg = "" + System.currentTimeMillis();
        kafkaMsg.setMsgId(msg);
        kafkaMsg.setMsg("msg " + msg);
        kafkaService.sendAsync(kafkaMsg);
    }
}