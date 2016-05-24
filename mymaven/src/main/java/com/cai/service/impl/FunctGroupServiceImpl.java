package com.cai.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cai.dao.CmFgMemberMapper;
import com.cai.dao.CmFunctGroupMapper;
import com.cai.dao.CmFunctMapper;
import com.cai.pojo.CmFgMember;
import com.cai.pojo.CmFunct;
import com.cai.pojo.CmFunctGroup;
import com.cai.service.FunctGroupService;

@Service("FunctGroupService")
public class FunctGroupServiceImpl implements FunctGroupService {
	@Resource
	private CmFunctGroupMapper functGroupdao;
	@Resource
	private CmFunctMapper functdao;
	@Resource
	private CmFgMemberMapper fgMemberdao;

	public int deleteByPrimaryKey(String handle) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(CmFunctGroup record) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(CmFunctGroup record) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public List<CmFunctGroup> selectFunctGroupNotInList() throws Exception {
		// TODO Auto-generated method stub
		List<CmFunctGroup> functGrouplist = this.functGroupdao.selectgroupnotin();
		return functGrouplist;
	}
	
	 public List<CmFunct> selectFunctNotInList() throws Exception
	 {
		 List<CmFunct> functList = this.functdao.selectfunctnotin();
		 return functList;
	 }
	
	public CmFunctGroup selectByPrimaryKey(String handle) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map<String,Object> selectfromCmFgMember(CmFunctGroup CmFunctGroup) throws Exception {
		// TODO Auto-generated method stub
		
		
			if (null == CmFunctGroup)
	        {
	            throw new Exception("crudBean is null");
	        }
	        Map<String,Object> res= new HashMap<String,Object>() ;
	        if(CmFunctGroup.getHandle()!=null || CmFunctGroup.getHandle().isEmpty())
	        {
	        	//获取功能包含的功能列表和子功能组列表
	        	
	        	String functGroupBo = CmFunctGroup.getHandle();
	        	Map<String, Object> paramMap=new HashMap<String,Object>();
	        	paramMap.put("cm_funct_group_bo", functGroupBo);
	        	
	        	
	        	List<CmFgMember> functGroupMemberList = this.fgMemberdao.selectByFunctGroupBo(functGroupBo);
	        	
	        	res.put("functGroupMemberList", functGroupMemberList);
	        	
//	        	List<CmFgMember> functMemberList = this.fgMemberdao.selectByFunctGroupBo(functGroupBo);
//	        	for(int i=0; i<functGroupMemberList.size();i++)
//	        	{
//	        		functMemberList.a
//	        	}
//	        	res.put("functMemberList", functMemberList);
	        	
	        	
	        	//同时还需获取没有分配功能组的功能列表 
	        	List<CmFunct> functList = this.functdao.selectfunctnotin();
	        	res.put("functUnAssignedList", functList);
	        	
	        	//同时还需要获取没有分给给该功能组的功能组列表
	        	List<CmFunctGroup> functGrouplist = this.functGroupdao.selectgroupnotin();
	        	res.put("functGroupNotInList", functGrouplist);
	        	
	        }
	        
	        return res;
	}

	public List<CmFunctGroup> selectByAnyOne(CmFunctGroup cmfunctgroup) throws Exception {
		// TODO Auto-generated method stub
		if(cmfunctgroup == null)
		{
			throw new Exception("cmfunctgroup is null");
		}
		List<CmFunctGroup> cmFunctGrouplist = this.functGroupdao.selectByAnyOne(cmfunctgroup);
		return cmFunctGrouplist;
	}

	public int updateByPrimaryKeySelective(CmFunctGroup record) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(CmFunctGroup record) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public CmFunctGroup selectfromCmFgMember(String handle) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
