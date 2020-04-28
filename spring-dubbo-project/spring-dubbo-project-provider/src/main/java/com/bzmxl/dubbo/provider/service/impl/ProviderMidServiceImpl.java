package com.bzmxl.dubbo.provider.service.impl;

import com.bzmxl.dubbo.common.provider.domain.ProviderMid;
import com.bzmxl.dubbo.common.provider.domain.ProviderReq;
import com.bzmxl.dubbo.common.provider.domain.ProviderRsp;
import com.bzmxl.dubbo.provider.service.ProviderMidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Primary
public class ProviderMidServiceImpl implements ProviderMidService {
    @Override
    public String test() {
        return "ProviderMidServiceImpl";
    }

    @Override
    public ProviderRsp callProvider(ProviderReq req) {
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