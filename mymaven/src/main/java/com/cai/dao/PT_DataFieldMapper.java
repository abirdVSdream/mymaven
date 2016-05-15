package com.cai.dao;

import java.util.List;
import java.util.Map;

import com.cai.pojo.PT_DataField;

public interface PT_DataFieldMapper {
    int deleteByPrimaryKey(String dataField);

    int insert(PT_DataField record);

    int insertSelective(PT_DataField record);

//    PT_DataField selectByPrimaryKey(String dataField);
    Map<String, Object> selectByPrimaryKey(String dataField);
    
    PT_DataField selectByAnyOne(PT_DataField datafield);
    
    List<PT_DataField> selectAll();

    int updateByPrimaryKeySelective(PT_DataField record);

    int updateByPrimaryKey(PT_DataField record);
}