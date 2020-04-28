package com.bzmxl.dubbo.common.serialization;

import com.bzmxl.dubbo.common.provider.domain.ProviderMid;
import com.bzmxl.dubbo.common.provider.domain.ProviderReq;
import com.bzmxl.dubbo.common.provider.domain.ProviderRsp;
import org.apache.dubbo.common.serialize.support.SerializationOptimizer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SerializationOptimizerImpl implements SerializationOptimizer {
    @Override
    public Collection<Class<?>> getSerializableClasses() {
        List<Class<?>> classes = new LinkedList<>();
        classes.add(ProviderReq.class);
        classes.add(ProviderMid.class);
        classes.add(ProviderRsp.class);
        return classes;
    }
}