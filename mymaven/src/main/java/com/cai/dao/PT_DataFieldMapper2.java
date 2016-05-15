package com.cai.dao;

import java.util.List;

import com.cai.pojo.PT_DataField2;

public interface PT_DataFieldMapper2 {
    int deleteByPrimaryKey(String datafieldbo);

    int insert(PT_DataField2 record);

    int insertSelective(PT_DataField2 record);

    PT_DataField2 selectByPrimaryKey(String datafieldbo);
    PT_DataField2 selectByAnyOne(PT_DataField2 datafield);
    
    List<PT_DataField2> selectAll();

    int updateByPrimaryKeySelective(PT_DataField2 record);

    int updateByPrimaryKey(PT_DataField2 record);
}