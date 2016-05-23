package com.cai.dao;

import com.cai.pojo.CmFunct;

public interface CmFunctMapper {
    int deleteByPrimaryKey(String handle);

    int insert(CmFunct record);

    int insertSelective(CmFunct record);

    CmFunct selectByPrimaryKey(String handle);

    int updateByPrimaryKeySelective(CmFunct record);

    int updateByPrimaryKey(CmFunct record);
}