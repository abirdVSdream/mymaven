package com.cai.dao;

import java.util.List;
import java.util.Map;

import com.cai.pojo.DataFileValueList;

public interface DataFileValueListMapper {
    int deleteByPrimaryKey(String handle);
    
    int deleteByptDataFieldBo(String handle);

    int insert(DataFileValueList record);

    int insertSelective(DataFileValueList record);

    List<Map<String,Object>> selectByPrimaryKey(String handle);
    
    List<Map<String,Object>> selectBydatafiledbo(String datafilebo);
    
    int updateByPrimaryKeySelective(DataFileValueList record);

    int updateByPrimaryKey(DataFileValueList record);
}