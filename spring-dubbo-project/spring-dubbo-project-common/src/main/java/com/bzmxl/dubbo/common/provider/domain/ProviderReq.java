package com.bzmxl.dubbo.common.provider.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class ProviderReq implements Serializable {
    private String name;
    private Integer age;
    private Map<String, Integer> ageMap;
    private ProviderMid mid;
}