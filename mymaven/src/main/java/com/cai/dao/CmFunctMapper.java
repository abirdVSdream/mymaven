package com.cai.dao;

import java.util.List;

import com.cai.pojo.CmFunct;

public interface CmFunctMapper {
    int deleteByPrimaryKey(String handle);

    int insert(CmFunct record);

    int insertSelective(CmFunct record);

    CmFunct selectByPrimaryKey(String handle);
    
    List<CmFunct> selectfunctnotin();

    int updateByPrimaryKeySelective(CmFunct record);

    int updateByPrimaryKey(CmFunct record);
}