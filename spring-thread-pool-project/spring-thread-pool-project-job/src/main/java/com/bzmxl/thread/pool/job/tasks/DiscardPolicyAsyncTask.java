package com.bzmxl.thread.pool.job.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class DiscardPolicyAsyncTask {
    @Async("DiscardPolicy")
    public String runTask(ConcurrentHashMap<String, String> map, AtomicInteger atomicInteger) {
        log.info("========DiscardPolicyAsyncTask========" + atomicInteger.getAndIncrement());
        map.put("" + Thread.currentThread().getId(), "");
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        return "DiscardPolicyAsyncTask";
    }
}