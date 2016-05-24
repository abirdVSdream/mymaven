package com.cai.service.impl;

import java.util.List;

import com.cai.dao.CmFunctMapper;
import com.cai.pojo.CmFunct;
import com.cai.service.FunctService;

public class FunctServiceImpl implements FunctService {
	
	private CmFunctMapper functdao;

	public int deleteByPrimaryKey(String handle) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(CmFunct record) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(CmFunct record) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public CmFunct selectByPrimaryKey(String handle) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CmFunct> selectfunctnotin() throws Exception {
		// TODO Auto-generated method stub
		List<CmFunct> cmFunctlist = this.functdao.selectfunctnotin();
		return cmFunctlist;
	}

	public int updateByPrimaryKeySelective(CmFunct record) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(CmFunct record) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
