package com.cai.service;

import java.util.List;

import com.cai.pojo.CmFunct;

public interface FunctService 
{
	int deleteByPrimaryKey(String handle) throws Exception;

    int insert(CmFunct record) throws Exception;

    int insertSelective(CmFunct record) throws Exception;

    CmFunct selectByPrimaryKey(String handle) throws Exception;
    
    List<CmFunct> selectfunctnotin() throws Exception;

    int updateByPrimaryKeySelective(CmFunct record) throws Exception;

    int updateByPrimaryKey(CmFunct record) throws Exception;
}
