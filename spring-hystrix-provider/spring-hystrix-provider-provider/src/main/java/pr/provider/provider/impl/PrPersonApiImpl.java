package pr.provider.provider.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pr.provider.api.feign.PrPersonApi;
import pr.provider.api.request.PrPersonReq;
import pr.provider.api.response.PrPersonRsp;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(tags = "用户模块")
@RequestMapping("/pr")
@RefreshScope
public class PrPersonApiImpl implements PrPersonApi {
    @Value("${pr.name}")
    private String personName;

    @ApiOperation(value = "新建用户")
    @Override
    @PostMapping("/insert")
    public PrPersonRsp insert(@Valid @RequestBody PrPersonReq req) {
        log.info("======req====" + req);
        PrPersonRsp rsp = new PrPersonRsp();
        rsp.setAddress("666");
        rsp.setAge(666);
        rsp.setName(personName);
        rsp.setPhone("666");
        return rsp;
    }
}