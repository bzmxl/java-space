package com.bzmxl.dubbo.consumer.service.impl.dubbo;

import com.bzmxl.dubbo.common.consumer.api.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Primary
public class ConsumerServiceImpl implements ConsumerService {
    @Override
    public String sayHi(Integer num) {
        return "sayHi";
    }
}