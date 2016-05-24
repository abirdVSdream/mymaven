package com.cai.service;

import java.util.List;
import java.util.Map;

import com.cai.pojo.CmFunct;
import com.cai.pojo.CmFunctGroup;

public interface FunctGroupService
{
	 	int deleteByPrimaryKey(String handle) throws Exception;

	    int insert(CmFunctGroup record) throws Exception;

	    int insertSelective(CmFunctGroup record) throws Exception;

	    CmFunctGroup selectByPrimaryKey(String handle) throws Exception;
	    
	    List<CmFunctGroup> selectByAnyOne(CmFunctGroup cmfunctgroup) throws Exception;
	    
	    public List<CmFunctGroup> selectFunctGroupNotInList() throws Exception;
	    
	    public Map<String,Object> selectfromCmFgMember(CmFunctGroup CmFunctGroup) throws Exception;
	    
	    public List<CmFunct> selectFunctNotInList() throws Exception;
	    
		public CmFunctGroup selectfromCmFgMember(String handle) throws Exception;

	    int updateByPrimaryKeySelective(CmFunctGroup record) throws Exception;

	    int updateByPrimaryKey(CmFunctGroup record) throws Exception;
}
