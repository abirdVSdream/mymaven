package com.cai.service.user;

import java.util.List;

import com.cai.pojo.user.Correlationupt;
import com.cai.pojo.user.Permission;

public interface CorrelationuptService
{
		public int deleteByPrimaryKey(String correlationid) throws Exception;

		public int insert(Correlationupt record) throws Exception;

		public int insertSelective(Correlationupt record) throws Exception;

		public Correlationupt selectByPrimaryKey(String correlationid) throws Exception;
		
		public List<Correlationupt> selectByUserid(String userid) throws Exception;

		public int updateByPrimaryKeySelective(Correlationupt record) throws Exception;

		public int updateByPrimaryKey(Correlationupt record) throws Exception;

}
