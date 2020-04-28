package com.bzmxl.dubbo.consumer.controller;

import com.bzmxl.dubbo.common.consumer.api.ConsumerService;
import com.bzmxl.dubbo.consumer.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/a")
    public String a() {
        return testService.test();
    }

    @GetMapping("/b")
    public String b() {
        return consumerService.sayHi(6);
    }
}