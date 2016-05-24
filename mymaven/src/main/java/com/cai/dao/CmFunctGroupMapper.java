package com.cai.dao;

import java.util.List;

import com.cai.pojo.CmFunctGroup;

public interface CmFunctGroupMapper {
    int deleteByPrimaryKey(String handle);

    int insert(CmFunctGroup record);

    int insertSelective(CmFunctGroup record);

    CmFunctGroup selectByPrimaryKey(String handle);
    
    List<CmFunctGroup> selectByAnyOne(CmFunctGroup cmfunctgroup);
    
    List<CmFunctGroup> selectgroupnotin();

    int updateByPrimaryKeySelective(CmFunctGroup record);

    int updateByPrimaryKey(CmFunctGroup record);
}