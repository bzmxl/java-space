package com.bzmxl.thread.pool.job.controller;

import com.bzmxl.thread.pool.job.tasks.DiscardPolicyAsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
@RequestMapping("/DiscardPolicy")
public class DiscardPolicyController {
    @Autowired
    private DiscardPolicyAsyncTask discardPolicyAsyncTask;

    private volatile ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    private volatile AtomicInteger atomicInteger = new AtomicInteger();

    @GetMapping("/a")
    public void a() {
        log.info("=============DiscardPolicyController main==================" + Thread.currentThread().getId());
        for (int i = 0; i < 50; i++) {
            log.info(discardPolicyAsyncTask.runTask(map, atomicInteger));
        }
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
        }
        log.info("==============DiscardPolicyController map size========" + map.size());
        for (String key : map.keySet()) {
            log.info("Key = " + key);
        }
    }
}