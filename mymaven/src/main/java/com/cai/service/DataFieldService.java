package com.cai.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.cai.pojo.PT_DataField;

public interface DataFieldService 
{

	public int deleteByPrimaryKey(String datafieldbo) throws Exception;

	public int insert(PT_DataField ptDataFieldBean) throws Exception;

	public int insertSelective(PT_DataField ptDataFieldBean) throws Exception;

	public PT_DataField selectByPrimaryKey(String datafieldbo) throws Exception;

	public int updateByPrimaryKeySelective(PT_DataField ptDataFieldBean) throws Exception;

	public int updateByPrimaryKey(PT_DataField ptDataFieldBean) throws Exception;
}
