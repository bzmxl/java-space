package co.consumer.provider.api.impl;

import co.consumer.api.feign.CallHystrixApi;
import co.consumer.provider.feign.client.PrHystrixApiClient;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(tags = "Hystrix消费模块")
@RequestMapping("/hystrix")
public class CallHystrixApiImpl implements CallHystrixApi {
    @Autowired
    private PrHystrixApiClient hystrixApiClient;

    @Override
    @GetMapping("/ok")
    public String callOK() {
        return hystrixApiClient.ok();
    }

    @Override
    @GetMapping("/timeOut")
    public String callTimeOut() {
        return hystrixApiClient.timeOut();
    }

    @Override
    @GetMapping("/error")
    public String callError() {
        return hystrixApiClient.error();
    }
}