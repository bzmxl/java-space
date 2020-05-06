package com.bzmxl.nacos.provider.feign;

import com.bzmxl.nacos.api.consumer.ConsumerApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "nacos-consumer")
public interface FeignConsumerApi extends ConsumerApi {
    @GetMapping(value = "consumer/call")
    String consumerCall(@RequestParam Long age);
}