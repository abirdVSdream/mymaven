package com.cai.service.user;

import com.cai.pojo.user.Permission;

public interface PermissionService 
{
 public Permission selectByPrimaryKey(String permissionid) throws Exception;
}
