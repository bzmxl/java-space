package com.bzmxl.dubbo.common.provider.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProviderRsp implements Serializable {
    private String twoName;
    private Long twoAge;
    private List<String> twoBooks;
    private ProviderMid mid;
}