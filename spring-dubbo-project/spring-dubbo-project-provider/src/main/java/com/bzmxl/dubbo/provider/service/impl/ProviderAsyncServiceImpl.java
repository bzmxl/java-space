package com.bzmxl.dubbo.provider.service.impl;

import com.bzmxl.dubbo.common.provider.api.ProviderAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@Primary
public class ProviderAsyncServiceImpl implements ProviderAsyncService {
    @Override
    public CompletableFuture<String> sayHello(String name) {
        RpcContext savedContext = RpcContext.getContext();
        // 建议为supplyAsync提供自定义线程池，避免使用JDK公用线程池
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(savedContext.getAttachment("consumer-key1"));
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("================ProviderAsyncServiceImpl====================" + System.currentTimeMillis());
            return "async response from provider.";
        });
    }
}