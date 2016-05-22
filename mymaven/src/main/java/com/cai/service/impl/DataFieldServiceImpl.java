package com.cai.service.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cai.dao.DataFieldMapper;
import com.cai.dao.DataFileValueListMapper;
import com.cai.pojo.DataField;
import com.cai.service.DataFieldService;

@Service("dataFieldService")
public class DataFieldServiceImpl implements DataFieldService {
	@Resource
	private DataFieldMapper dataFieldDao;
	@Resource
	private DataFileValueListMapper dataFileListDao;


	/**
     * 按主键删除数据
     * @param datafieldbo
     * @return
	 * @throws Exception 
     * 
     */
	public int deleteByPrimaryKey(String datafield) throws Exception{
		// TODO Auto-generated method stub
		
		
		if(datafield == null || datafield.equals(""))
		{
			throw new Exception("datafieldbo is null");
		}
		
		this.dataFileListDao.deleteByptDataFieldBo(datafield);
		
		int  Result = this.dataFieldDao.deleteByPrimaryKey(datafield);
		
		return Result;
	}


	/**
     * 插入数据不允许存在空值
     * @param ptDataFieldBean
     * @return
	 * @throws Exception 
     * 
     */
	public int insert(DataField ptDataFieldBean) throws Exception {
		// TODO Auto-generated method stub
		if(ptDataFieldBean == null)
		{
			throw new Exception("datafieldbo is null");
		}
		
		//插入主表
	 	Date mydate = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String retStrFormatNowDate = sdFormatter.format(mydate);
        ptDataFieldBean.setCreateDate(Timestamp.valueOf(retStrFormatNowDate));
	       
		this.dataFieldDao.insertSelective(ptDataFieldBean);
		
		//插入从表
		if(ptDataFieldBean.getDataFieldValueList() != null)
		{
			for(int i=0;i<ptDataFieldBean.getDataFieldValueList().size();i++)
			{
				this.dataFileListDao.insertSelective(ptDataFieldBean.getDataFieldValueList().get(i));
			}
		}
		
		return 1;
	}

	
	/**
     * 插入数据允许存在空值
     * @param ptDataFieldBean
     * @return
	 * @throws Exception 
     * 
     */
	public int insertSelective(DataField ptDataFieldBean) throws Exception {
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
	
	  public List<DataField> selectByAnyKey(DataField ptDataFieldBean) throws Exception {
		// TODO Auto-generated method stub
		//入参为空
		if(null==ptDataFieldBean)
		{
			throw new Exception("ptDataFieldBean is null");
		}
		
		// 存放查询结果
		 List <DataField> Result = this.dataFieldDao.selectByAnyOne(ptDataFieldBean);
		return Result;
	}

	/**
	 * 查找所有的数据
	 * @param ptDataFieldBean
	 * @return
	 * @throws Exception 
	 */
		public List<DataField> selectAll() {
			// TODO Auto-generated method stub
			return this.dataFieldDao.selectAll();
		}  
		
		
		 /**
	     * 按主键查询数据
	     * @param ptDataFieldBean
	     * @return
	     * @throws Exception
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
	            
	            ptDataFieldBo = (String)mapDatafiledResult.get("DATA_FIELD");
	            
	            
	            mapDatafiledResult.put("dataFieldValueList",this.dataFileListDao.selectBydatafiledbo(ptDataFieldBo));
	            mapResult.add(mapDatafiledResult);
	            
	            return mapResult;
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	            throw new Exception(e.getMessage());
	        }      
	    }
	    
	/*
	 * 	更新数据允许字段为空
	 */
	  
	public int updateByPrimaryKeySelective(DataField ptDataFieldBean) throws Exception {
		// TODO Auto-generated method stub
		if(ptDataFieldBean == null)
		{
			throw new Exception("ptDataFieldBean is null");
		}
		//更新主表
		Date mydate = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String retStrFormatNowDate = sdFormatter.format(mydate);
        ptDataFieldBean.setModifiedDate(Timestamp.valueOf(retStrFormatNowDate));
		
		int Result =this.dataFieldDao.updateByPrimaryKeySelective(ptDataFieldBean);
		//更新从表
		if(ptDataFieldBean.getDataFieldValueList() != null)
		{
			for(int i=0;i<ptDataFieldBean.getDataFieldValueList().size();i++)
			{
				this.dataFileListDao.updateByPrimaryKeySelective(ptDataFieldBean.getDataFieldValueList().get(i));
			}
		}
		
		return Result;
	}

	public int updateByPrimaryKey(DataField ptDataFieldBean) throws Exception {
		// TODO Auto-generated method stub
		
		if(ptDataFieldBean == null)
		{
			throw new Exception("ptDataFieldBean is null");
		}
		int result = this.dataFieldDao.updateByPrimaryKey(ptDataFieldBean);
		return result;
	}


}
