package com.bzmxl.nacos.consumer.controller;

import com.bzmxl.nacos.api.domain.ProviderMid;
import com.bzmxl.nacos.api.domain.ProviderReq;
import com.bzmxl.nacos.api.domain.ProviderRsp;
import com.bzmxl.nacos.consumer.feign.FeignProviderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NacosController {
    @Autowired
    private FeignProviderApi providerApi;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/echo/app-name")
    public String echoAppName() {
        //使用 LoadBalanceClient 和 RestTemolate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
        System.out.println("request url:" + url);
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/echo/provider/a")
    public ProviderRsp echoProvider() {
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
        return providerApi.providerCall(req);
    }
}