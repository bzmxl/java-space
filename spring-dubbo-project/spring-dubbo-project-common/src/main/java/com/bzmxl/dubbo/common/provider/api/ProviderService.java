package com.bzmxl.dubbo.common.provider.api;

import com.bzmxl.dubbo.common.provider.domain.ProviderReq;
import com.bzmxl.dubbo.common.provider.domain.ProviderRsp;

public interface ProviderService {
    ProviderRsp callProvider(ProviderReq req);
}