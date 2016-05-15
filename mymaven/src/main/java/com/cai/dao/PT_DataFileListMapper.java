package com.cai.dao;

import java.util.List;

import com.cai.pojo.PT_DataField2;
import com.cai.pojo.PT_DataFileList;

public interface PT_DataFileListMapper {
    int deleteByPrimaryKey(String handle);

    int insert(PT_DataFileList record);

    int insertSelective(PT_DataFileList record);

    List<PT_DataFileList> selectByPrimaryKey(String handle);
    
    int updateByPrimaryKeySelective(PT_DataFileList record);

    int updateByPrimaryKey(PT_DataFileList record);
}