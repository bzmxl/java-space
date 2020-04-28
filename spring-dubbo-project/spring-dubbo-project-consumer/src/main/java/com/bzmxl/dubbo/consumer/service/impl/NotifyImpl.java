package com.bzmxl.dubbo.consumer.service.impl;

import com.bzmxl.dubbo.common.consumer.api.Notify;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class NotifyImpl implements Notify {
    public Map<Integer, Integer> ret = new HashMap<Integer, Integer>();
    public Map<Integer, Throwable> errors = new HashMap<Integer, Throwable>();

    @Override
    public void onreturn(int msg, Integer id) {
        log.info("====onreturn======" + msg + "====" + id);
        ret.put(id, msg);
    }

    @Override
    public void onthrow(Throwable ex, Integer id) {
        errors.put(id, ex);
        log.info("====onthrow======" + ex + "====" + id);
    }
}