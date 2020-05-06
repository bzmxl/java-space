package com.bzmxl.nacos.provider.controller;

import com.bzmxl.nacos.provider.feign.FeignConsumerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
    @Autowired
    private FeignConsumerApi consumerApi;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

    @GetMapping("/echo/consumer")
    public String echoProvider() {
        return consumerApi.consumerCall(66666L);
    }
}