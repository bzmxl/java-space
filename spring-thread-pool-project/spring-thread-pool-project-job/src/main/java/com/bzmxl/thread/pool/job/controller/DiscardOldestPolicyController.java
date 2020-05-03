package com.bzmxl.thread.pool.job.controller;

import com.bzmxl.thread.pool.job.tasks.DiscardOldestPolicyAsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
@RequestMapping("/DiscardOldestPolicy")
public class DiscardOldestPolicyController {
    @Autowired
    private DiscardOldestPolicyAsyncTask discardOldestPolicyAsyncTask;

    private volatile ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    private volatile AtomicInteger atomicInteger = new AtomicInteger();

    @GetMapping("/a")
    public void a() {
        log.info("=============DiscardOldestPolicy main==================" + Thread.currentThread().getId());
        for (int i = 0; i < 50; i++) {
            log.info(discardOldestPolicyAsyncTask.runTask(map, atomicInteger));
        }
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
        }
        log.info("==============DiscardOldestPolicy map size========" + map.size());
        for (String key : map.keySet()) {
            log.info("Key = " + key);
        }
    }
}