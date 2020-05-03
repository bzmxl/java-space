package com.bzmxl.thread.pool.job.controller;

import com.bzmxl.thread.pool.job.tasks.AbortPolicyAsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RestController
@RequestMapping("/AbortPolicy")
public class AbortPol1icyController {
    @Autowired
    private AbortPolicyAsyncTask abortPolicyAsyncTask;

    private volatile ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    @GetMapping("/a")
    public void a() {
        log.info("=============AbortPolicyController main==================" + Thread.currentThread().getId());
        for (int i = 0; i < 50; i++) {
            log.info(abortPolicyAsyncTask.runTask(map));
        }
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
        }
        log.info("==============AbortPolicyController map size========" + map.size());
        for (String key : map.keySet()) {
            log.info("Key = " + key);
        }
    }
}