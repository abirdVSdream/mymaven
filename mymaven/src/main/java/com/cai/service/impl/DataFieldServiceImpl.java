package com.cai.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cai.dao.PT_DataFieldMapper;
import com.cai.pojo.PT_DataField;
import com.cai.service.DataFieldService;

@Service
public class DataFieldServiceImpl implements DataFieldService {
	@Resource
	private PT_DataFieldMapper dataFieldDao;


	/**
     * 按主键删除数据
     * @param datafieldbo
     * @return
	 * @throws Exception 
     * 
     */
	public int deleteByPrimaryKey(String datafieldbo) throws Exception{
		// TODO Auto-generated method stub
		if(datafieldbo == null)
		{
			throw new Exception("datafieldbo is null");
		}
		
		int  Result = this.dataFieldDao.deleteByPrimaryKey(datafieldbo);
		
		return Result;
	}


	/**
     * 插入数据不允许存在空值
     * @param ptDataFieldBean
     * @return
	 * @throws Exception 
     * 
     */
	public int insert(PT_DataField ptDataFieldBean) throws Exception {
		// TODO Auto-generated method stub
		if(ptDataFieldBean == null)
		{
			throw new Exception("datafieldbo is null");
		}
		
		int  Result = this.dataFieldDao.insert(ptDataFieldBean);
		
		return Result;
	}

	
	/**
     * 插入数据允许存在空值
     * @param ptDataFieldBean
     * @return
	 * @throws Exception 
     * 
     */
	public int insertSelective(PT_DataField ptDataFieldBean) throws Exception {
		// TODO Auto-generated method stub
		if(ptDataFieldBean == null)
		{
			throw new Exception("datafieldbo is null");
		}
		
		int  Result = this.dataFieldDao.insert(ptDataFieldBean);
		
		return Result;
	}

	/**
     * 按主键查询数据
     * @param ptDataFieldBean
     * @return
	 * @throws Exception 
     * 
     */
	
	  public PT_DataField selectByPrimaryKey(String datafieldbo) throws Exception {
		// TODO Auto-generated method stub
		//入参为空
		if(datafieldbo.equals(null) || datafieldbo.equals(""))
		{
			throw new Exception("datafieldbo is null");
		}
		
		// 存放查询结果
		PT_DataField Result = new PT_DataField();
		
		 Result = this.dataFieldDao.selectByPrimaryKey(datafieldbo);
		
		return Result;
	}

	public int updateByPrimaryKeySelective(PT_DataField ptDataFieldBean) throws Exception {
		// TODO Auto-generated method stub
		if(ptDataFieldBean == null)
		{
			throw new Exception("ptDataFieldBean is null");
		}
		int Result =this.dataFieldDao.updateByPrimaryKeySelective(ptDataFieldBean);
		
		return Result;
	}

	public int updateByPrimaryKey(PT_DataField ptDataFieldBean) throws Exception {
		// TODO Auto-generated method stub
		
		if(ptDataFieldBean == null)
		{
			throw new Exception("ptDataFieldBean is null");
		}
		int result = this.dataFieldDao.updateByPrimaryKey(ptDataFieldBean);
		return result;
	}

}
