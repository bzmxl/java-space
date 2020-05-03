package com.bzmxl.thread.pool.job.controller;

import com.bzmxl.thread.pool.job.tasks.CallerRunsPolicyAsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RestController
@RequestMapping("/CallerRunsPolicy")
public class CallerRunsPolicyController {
    @Autowired
    private CallerRunsPolicyAsyncTask callerRunsPolicyAsyncTask;

    private volatile ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    @GetMapping("/a")
    public void a() {
        log.info("=============CallerRunsPolicyController main==================" + Thread.currentThread().getId());
        for (int i = 0; i < 50; i++) {
            log.info(callerRunsPolicyAsyncTask.runTask(map));
        }
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
        }
        log.info("==============CallerRunsPolicyController map size========" + map.size());
        for (String key : map.keySet()) {
            log.info("Key = " + key);
        }
    }
}