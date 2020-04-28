package com.bzmxl.dubbo.consumer.controller;

import com.bzmxl.dubbo.common.provider.api.ProviderAsyncService;
import com.bzmxl.dubbo.common.provider.api.ProviderService;
import com.bzmxl.dubbo.common.provider.domain.ProviderMid;
import com.bzmxl.dubbo.common.provider.domain.ProviderReq;
import com.bzmxl.dubbo.common.provider.domain.ProviderRsp;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/dubbo")
public class DubboController {
    @Autowired
    private ProviderService providerService;

    @Autowired
    private ProviderAsyncService providerAsyncService;

    @GetMapping("/a")
    public ProviderRsp a() {
        ProviderReq req = new ProviderReq();
        req.setAge(68);
        req.setName("68");
        Map<String, Integer> map = new HashMap<>();
        map.put("68", 68);
        req.setAgeMap(map);
        ProviderMid mid = new ProviderMid();
        mid.setMid("68");
        mid.setMidId(68L);
        req.setMid(mid);
        return providerService.callProvider(req);
    }

    @GetMapping("/sync/a")
    public String sync_a() {
        log.info("sync/a begin " + System.currentTimeMillis());
        // 调用直接返回CompletableFuture
        CompletableFuture<String> future = providerAsyncService.sayHello("async call request");
        // 增加回调
        future.whenComplete((v, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println("Response: " + v);
            }
        });
        // 早于结果输出
        System.out.println("Executed before response return.");
        log.info("sync/a end " + System.currentTimeMillis());
        return "sync a";
    }

    @GetMapping("/sync/b")
    public String sync_b() {
        log.info("sync/b begin " + System.currentTimeMillis());
        // 此调用会立即返回null
        providerAsyncService.sayHello("world");
        // 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
        CompletableFuture<String> helloFuture = RpcContext.getContext().getCompletableFuture();
        // 为Future添加回调
        helloFuture.whenComplete((retValue, exception) -> {
            if (exception == null) {
                System.out.println(retValue);
            } else {
                exception.printStackTrace();
            }
        });
        log.info("sync/b end " + System.currentTimeMillis());
        return "sync b";
    }
}