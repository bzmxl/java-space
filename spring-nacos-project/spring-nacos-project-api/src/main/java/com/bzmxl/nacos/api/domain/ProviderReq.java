package com.bzmxl.nacos.api.domain;

import lombok.Data;

import java.util.Map;

@Data
public class ProviderReq {
    private String name;
    private Integer age;
    private Map<String, Integer> ageMap;
    private ProviderMid mid;
}