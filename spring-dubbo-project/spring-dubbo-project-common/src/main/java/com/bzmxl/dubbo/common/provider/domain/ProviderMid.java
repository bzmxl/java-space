package com.bzmxl.dubbo.common.provider.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProviderMid implements Serializable {
    private String mid;
    private Long midId;
}