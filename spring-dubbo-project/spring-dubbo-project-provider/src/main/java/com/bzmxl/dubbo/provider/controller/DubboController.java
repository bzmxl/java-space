package com.bzmxl.dubbo.provider.controller;

import com.bzmxl.dubbo.common.consumer.api.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dubbo")
public class DubboController {
    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/a")
    public String a() {
        return consumerService.sayHi(2);
    }
}