package com.cai.dao;

import java.util.List;
import java.util.Map;

import com.cai.pojo.DataField;

public interface DataFieldMapper {
    int deleteByPrimaryKey(String dataField);

    int insert(DataField record);

    int insertSelective(DataField record);

//    PT_DataField selectByPrimaryKey(String dataField);
    Map<String, Object> selectByPrimaryKey(String dataField);
    
    List<DataField> selectByAnyOne(DataField datafield);
    
    List<DataField> selectAll();

    int updateByPrimaryKeySelective(DataField record);

    int updateByPrimaryKey(DataField record);
}