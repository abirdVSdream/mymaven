package com.cai.service;

import java.util.List;

import com.cai.pojo.CmFunctGroup;

public interface FunctGroupService
{
	 	int deleteByPrimaryKey(String handle) throws Exception;

	    int insert(CmFunctGroup record) throws Exception;

	    int insertSelective(CmFunctGroup record) throws Exception;

	    CmFunctGroup selectByPrimaryKey(String handle) throws Exception;
	    
	    List<CmFunctGroup> selectByAnyOne(CmFunctGroup cmfunctgroup) throws Exception;

	    int updateByPrimaryKeySelective(CmFunctGroup record) throws Exception;

	    int updateByPrimaryKey(CmFunctGroup record) throws Exception;
}
