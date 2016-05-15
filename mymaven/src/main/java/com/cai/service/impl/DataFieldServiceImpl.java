package com.cai.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cai.dao.PT_DataFieldMapper;
import com.cai.dao.PT_DataFileListMapper;
import com.cai.pojo.PT_DataField;
import com.cai.service.DataFieldService;

@Service("dataFieldService")
public class DataFieldServiceImpl implements DataFieldService {
	@Resource
	private PT_DataFieldMapper dataFieldDao;
	private PT_DataFileListMapper dataFileListDao;


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
     * 按任何数据查询数据
     * @param ptDataFieldBean
     * @return
	 * @throws Exception 
     * 
     */
	
	  public List<PT_DataField> selectByAnyKey(PT_DataField ptDataFieldBean) throws Exception {
		// TODO Auto-generated method stub
		//入参为空
		if(null==ptDataFieldBean)
		{
			throw new Exception("ptDataFieldBean is null");
		}
		
		// 存放查询结果
		PT_DataField Rs = new PT_DataField();
		
		 Rs = this.dataFieldDao.selectByAnyOne(ptDataFieldBean);
		 List <PT_DataField> Result = new ArrayList <PT_DataField>();
		 if(Rs!=null)
		 {
			 Result.add(Rs);
		 }
		 
		 
		
		return Result;
	}

	/**
	 * 查找所有的数据
	 * @param ptDataFieldBean
	 * @return
	 * @throws Exception 
	 */
		public List<PT_DataField> selectAll() {
			// TODO Auto-generated method stub
			return this.dataFieldDao.selectAll();
		}  
		
		
		 /**
	     * 按主键查询数据
	     * @param ptDataFieldBean
	     * @return
	     * @throws ImesBussinessException
	     */
	    public List<Map<String, Object>> retrieve(String DataField)
	        throws Exception
	    {
	        // 入参判空
	        if (DataField.equals(""))
	        {
	            throw new Exception("DataField is null");
	        }
	        
	        // 存放查询结果
	        List<Map<String, Object>> mapResult = new ArrayList<Map<String, Object>>();
	        
	        try
	        {
	            // 存放主表PT_DATA_FIELD查询结果
	            Map<String, Object> mapDatafiledResult =  this.dataFieldDao.selectByPrimaryKey(DataField);
	            
	            // 查询从表数据
	            if (null == mapDatafiledResult)
	            {
	                return mapResult;
	            }
	            String ptDataFieldBo = null;
	            
	            ptDataFieldBo = (String)mapDatafiledResult.get("dataField")+(String)mapDatafiledResult.get("squence");
	            
	            
	            mapDatafiledResult.put("dataFieldValueList", dataFileListDao.selectByPrimaryKey(ptDataFieldBo));
	            mapResult.add(mapDatafiledResult);
	            
	            return mapResult;
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	            throw new Exception(e.getMessage());
	        }      
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
