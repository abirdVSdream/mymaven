package com.cai.dao.user;

import com.cai.pojo.user.Permission2;

public interface PermissionMapper2 {
    int deleteByPrimaryKey(String permissionid);

    int insert(Permission2 record);

    int insertSelective(Permission2 record);

    Permission2 selectByPrimaryKey(String permissionid);

    int updateByPrimaryKeySelective(Permission2 record);

    int updateByPrimaryKey(Permission2 record);
}