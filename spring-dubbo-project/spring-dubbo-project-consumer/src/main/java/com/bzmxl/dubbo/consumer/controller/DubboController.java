package com.bzmxl.dubbo.consumer.controller;

import com.bzmxl.dubbo.common.provider.api.ProviderService;
import com.bzmxl.dubbo.common.provider.domain.ProviderMid;
import com.bzmxl.dubbo.common.provider.domain.ProviderReq;
import com.bzmxl.dubbo.common.provider.domain.ProviderRsp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/dubbo")
public class DubboController {
    @Autowired
    private ProviderService providerService;

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
}