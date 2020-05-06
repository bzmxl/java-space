package com.bzmxl.nacos.api.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "nacos-consumer")
public interface ConsumerApi {
    @GetMapping(value = "consumer/call")
    String consumerCall(@RequestParam Long age);
}