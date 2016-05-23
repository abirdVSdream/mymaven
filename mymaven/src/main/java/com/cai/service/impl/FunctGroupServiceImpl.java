package com.cai.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cai.dao.CmFunctGroupMapper;
import com.cai.pojo.CmFunctGroup;
import com.cai.service.FunctGroupService;

@Service("FunctGroupService")
public class FunctGroupServiceImpl implements FunctGroupService {
	@Resource
	private CmFunctGroupMapper CmFunctGroupdao;

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

	public CmFunctGroup selectByPrimaryKey(String handle) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CmFunctGroup> selectByAnyOne(CmFunctGroup cmfunctgroup) throws Exception {
		// TODO Auto-generated method stub
		if(cmfunctgroup == null)
		{
			throw new Exception("cmfunctgroup is null");
		}
		List<CmFunctGroup> cmFunctGrouplist = this.CmFunctGroupdao.selectByAnyOne(cmfunctgroup);
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

}
