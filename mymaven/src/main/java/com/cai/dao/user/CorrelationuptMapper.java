package com.cai.dao.user;

import com.cai.pojo.user.Correlationupt;

public interface CorrelationuptMapper {
    int deleteByPrimaryKey(String correlationid);

    int insert(Correlationupt record);

    int insertSelective(Correlationupt record);

    Correlationupt selectByPrimaryKey(String correlationid);

    int updateByPrimaryKeySelective(Correlationupt record);

    int updateByPrimaryKey(Correlationupt record);
}