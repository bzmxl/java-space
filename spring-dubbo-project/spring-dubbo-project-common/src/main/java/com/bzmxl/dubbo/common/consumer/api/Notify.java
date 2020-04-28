package com.bzmxl.dubbo.common.consumer.api;

public interface Notify {
    void onreturn(int msg, Integer id);

    void onthrow(Throwable ex, Integer id);
}