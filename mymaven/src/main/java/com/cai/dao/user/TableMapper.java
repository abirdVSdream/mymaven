package com.cai.dao.user;

import com.cai.pojo.user.Table;

public interface TableMapper {
    int deleteByPrimaryKey(String tableid);

    int insert(Table record);

    int insertSelective(Table record);

    Table selectByPrimaryKey(String tableid);

    int updateByPrimaryKeySelective(Table record);

    int updateByPrimaryKey(Table record);
}