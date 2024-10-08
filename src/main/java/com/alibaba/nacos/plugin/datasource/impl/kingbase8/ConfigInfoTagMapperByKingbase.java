package com.alibaba.nacos.plugin.datasource.impl.kingbase8;

import com.alibaba.nacos.plugin.datasource.constants.DataSourceConstant;
import com.alibaba.nacos.plugin.datasource.mapper.ConfigInfoTagMapper;
import com.alibaba.nacos.plugin.datasource.model.MapperContext;
import com.alibaba.nacos.plugin.datasource.model.MapperResult;

import java.util.Collections;

/**
 * The mysql implementation of ConfigInfoTagMapper.
 *
 * @author kqq
 **/

public class ConfigInfoTagMapperByKingbase extends AbstractMapperByKingbase8 implements ConfigInfoTagMapper {
    
    @Override
    public MapperResult findAllConfigInfoTagForDumpAllFetchRows(MapperContext context) {
        String sql = " SELECT t.id,data_id,group_id,tenant_id,tag_id,app_name,content,md5,gmt_modified "
                + " FROM (  SELECT id FROM config_info_tag  ORDER BY id LIMIT " + context.getStartRow() + ","
                + context.getPageSize() + " ) " + "g, config_info_tag t  WHERE g.id = t.id  ";
        return new MapperResult(sql, Collections.emptyList());
    }
    
    @Override
    public String getDataSource() {
        return DataSourceConstant.KINGBASE;
    }
}
