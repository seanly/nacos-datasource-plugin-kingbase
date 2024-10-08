package com.alibaba.nacos.plugin.datasource.impl.kingbase8;

import com.alibaba.nacos.plugin.datasource.constants.DataSourceConstant;
import com.alibaba.nacos.plugin.datasource.mapper.TenantInfoMapper;

/**
 * The mysql implementation of TenantInfoMapper.
 *
 * @author kqq
 **/

public class TenantInfoMapperByKingbase extends AbstractMapperByKingbase8 implements TenantInfoMapper {

    @Override
    public String getDataSource() {
        return DataSourceConstant.KINGBASE;
    }
}
