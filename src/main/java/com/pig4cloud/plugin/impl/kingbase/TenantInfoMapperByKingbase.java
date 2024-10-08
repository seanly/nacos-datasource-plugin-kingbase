package com.pig4cloud.plugin.impl.kingbase;

import com.alibaba.nacos.plugin.datasource.mapper.TenantInfoMapper;
import com.pig4cloud.plugin.constants.DataSourceConstant;

public class TenantInfoMapperByKingbase extends KingbaseAbstractMapper implements TenantInfoMapper {

	@Override
	public String getDataSource() {
		return DataSourceConstant.KINGBASE;
	}

}
