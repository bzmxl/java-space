package com.bzmxl.nacos.api.domain;

import lombok.Data;

import java.util.List;

@Data
public class ProviderRsp {
    private String twoName;
    private Long twoAge;
    private List<String> twoBooks;
    private ProviderMid mid;
}