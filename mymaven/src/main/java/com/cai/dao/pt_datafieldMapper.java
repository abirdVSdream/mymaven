package com.cai.dao;

import com.cai.pojo.pt_datafield;
import com.cai.pojo.pt_datafieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface pt_datafieldMapper {
    int countByExample(pt_datafieldExample example);

    int deleteByExample(pt_datafieldExample example);

    int deleteByPrimaryKey(String datafieldbo);

    int insert(pt_datafield record);

    int insertSelective(pt_datafield record);

    List<pt_datafield> selectByExample(pt_datafieldExample example);

    pt_datafield selectByPrimaryKey(String datafieldbo);

    int updateByExampleSelective(@Param("record") pt_datafield record, @Param("example") pt_datafieldExample example);

    int updateByExample(@Param("record") pt_datafield record, @Param("example") pt_datafieldExample example);

    int updateByPrimaryKeySelective(pt_datafield record);

    int updateByPrimaryKey(pt_datafield record);
}