package com.bzmxl.dubbo.common.provider.api;

import java.util.concurrent.CompletableFuture;

public interface ProviderAsyncService {
    CompletableFuture<String> sayHello(String name);
}