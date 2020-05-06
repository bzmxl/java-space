package com.bzmxl.nacos.provider.api.impl;

import com.bzmxl.nacos.api.domain.ProviderMid;
import com.bzmxl.nacos.api.domain.ProviderReq;
import com.bzmxl.nacos.api.domain.ProviderRsp;
import com.bzmxl.nacos.api.provider.ProviderApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("provider")
public class ProviderApiImpl implements ProviderApi {
    @Override
    @PostMapping(value = "/call")
    public ProviderRsp providerCall(@Valid @RequestBody ProviderReq req) {
        log.info("=======ProviderMidServiceImpl============" + req.toString());
        ProviderRsp rsp = new ProviderRsp();
        rsp.setTwoAge(6L);
        rsp.setTwoName("66");
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        rsp.setTwoBooks(list);
        ProviderMid mid = new ProviderMid();
        mid.setMid("99");
        mid.setMidId(99L);
        rsp.setMid(mid);
        log.info("=======ProviderMidServiceImpl============" + rsp.toString());
        return rsp;
    }
}