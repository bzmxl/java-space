package com.bzmxl.dubbo.provider.controller;

import com.bzmxl.dubbo.common.provider.domain.ProviderReq;
import com.bzmxl.dubbo.common.provider.domain.ProviderRsp;
import com.bzmxl.dubbo.provider.service.ProviderMidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ProviderMidService providerMidService;

    @GetMapping("/a")
    public String a() {
        return providerMidService.test();
    }

    @GetMapping("/b")
    public ProviderRsp b() {
        ProviderReq req = new ProviderReq();
        return providerMidService.callProvider(req);
    }
}