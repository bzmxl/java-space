package com.bzmxl.dubbo.consumer.service.impl;

import com.bzmxl.dubbo.consumer.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test() {
        return "test";
    }
}