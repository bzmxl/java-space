package com.bzmxl.nacos.consumer.api.impl;

import com.bzmxl.nacos.api.consumer.ConsumerApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("consumer")
public class ConsumerApiImpl implements ConsumerApi {
    @Override
    @GetMapping(value = "/call")
    public String consumerCall(@RequestParam Long age) {
        log.info("==========ConsumerApiImpl====================" + age);
        return "ConsumerApiImpl consumerCall";
    }
}