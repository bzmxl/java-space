package com.bzmxl.thread.pool.job.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class AbortPolicyAsyncTask {
    @Async("AbortPolicy")
    public String runTask(ConcurrentHashMap<String, String> map) {
        log.info("========AbortPolicyAsyncTask========");
        map.put("" + Thread.currentThread().getId(), "");
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        return "AbortPolicyAsyncTask";
    }
}