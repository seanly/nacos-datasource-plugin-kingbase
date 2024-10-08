package com.alibaba.nacos.plugin.datasource.impl.kingbase8;

import com.alibaba.nacos.plugin.datasource.enums.kingbase8.TrustedKingbase8FunctionEnum;
import com.alibaba.nacos.plugin.datasource.mapper.AbstractMapper;

public abstract class AbstractMapperByKingbase8 extends AbstractMapper {

    @Override
    public String getFunction(String functionName) {
        return TrustedKingbase8FunctionEnum.getFunctionByName(functionName);
    }
}
