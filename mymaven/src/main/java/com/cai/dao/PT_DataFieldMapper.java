package com.cai.dao;

import com.cai.pojo.PT_DataField;
import com.cai.pojo.PT_DataFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PT_DataFieldMapper {

    int deleteByPrimaryKey(String datafieldbo);

    int insert(PT_DataField record);

    int insertSelective(PT_DataField record);

    PT_DataField selectByPrimaryKey(String datafieldbo);

    int updateByPrimaryKeySelective(PT_DataField record);

    int updateByPrimaryKey(PT_DataField record);
}