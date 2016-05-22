package com.cai.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.cai.pojo.DataField;

public interface DataFieldService 
{

	public int deleteByPrimaryKey(String datafieldbo) throws Exception;

	public int insert(DataField ptDataFieldBean) throws Exception;

	public int insertSelective(DataField ptDataFieldBean) throws Exception;
	
	public List<Map<String, Object>> retrieve(String DataField) throws Exception;
	
	public List<DataField> selectByAnyKey(DataField ptDataFieldBean) throws Exception;
	
	public List<DataField> selectAll();
	
	public int updateByPrimaryKeySelective(DataField ptDataFieldBean) throws Exception;

	public int updateByPrimaryKey(DataField ptDataFieldBean) throws Exception;
}
