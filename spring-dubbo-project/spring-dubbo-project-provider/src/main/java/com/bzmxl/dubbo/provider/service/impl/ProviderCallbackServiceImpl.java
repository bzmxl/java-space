package com.bzmxl.dubbo.provider.service.impl;

import com.bzmxl.dubbo.common.provider.api.ProviderCallbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Primary
public class ProviderCallbackServiceImpl implements ProviderCallbackService {
    @Override
    public int get(int id) {
        return 6666;
    }
}