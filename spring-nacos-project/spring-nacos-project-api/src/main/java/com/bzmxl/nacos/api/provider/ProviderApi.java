package com.bzmxl.nacos.api.provider;

import com.bzmxl.nacos.api.domain.ProviderReq;
import com.bzmxl.nacos.api.domain.ProviderRsp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "nacos-provider")
public interface ProviderApi {
    @PostMapping(value = "provider/call")
    ProviderRsp providerCall(@RequestBody ProviderReq req);
}