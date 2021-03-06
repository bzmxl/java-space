package co.consumer.provider.api.impl;

import co.consumer.api.feign.CoPersonApi;
import co.consumer.api.request.CoPersonReq;
import co.consumer.api.response.CoPersonRsp;
import co.consumer.provider.feign.client.PrPersonApiClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pr.provider.api.request.PrPersonReq;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(tags = "用户模块")
@RequestMapping("/co")
@RefreshScope
public class CoPersonApiImpl implements CoPersonApi {
    @Value("${co.name}")
    private String personName;

    @Autowired
    private PrPersonApiClient personApiClient;

    @ApiOperation(value = "新建用户")
    @Override
    @PostMapping("/insert")
    public CoPersonRsp insert(@Valid @RequestBody CoPersonReq req) {
        log.info("======req====" + req);
        CoPersonRsp rsp = new CoPersonRsp();
        rsp.setAddress("666");
        rsp.setAge(666);
        rsp.setName(personName);
        rsp.setPhone("666");
        return rsp;
    }

    @Override
    public String callPr() {
        PrPersonReq req = new PrPersonReq();
        req.setAge(667);
        req.setName("personApiClient");
        return personApiClient.insert(req).getName();
    }
}