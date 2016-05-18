package com.cai.dao.user;

import com.cai.pojo.user.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(String permissionid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String permissionid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}