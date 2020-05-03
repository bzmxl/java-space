package com.bzmxl.thread.pool.job.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class CallerRunsPolicyAsyncTask {
    @Async("CallerRunsPolicy")
    public String runTask(ConcurrentHashMap<String, String> map) {
        log.info("========CallerRunsPolicyAsyncTask========" + Thread.currentThread().getId());
        map.put("" + Thread.currentThread().getId(), "");
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        return "CallerRunsPolicyAsyncTask";
    }
}