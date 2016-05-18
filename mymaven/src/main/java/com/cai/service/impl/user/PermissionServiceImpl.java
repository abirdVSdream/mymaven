package com.cai.service.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cai.dao.user.PermissionMapper;
import com.cai.pojo.user.Permission;
import com.cai.service.user.PermissionService;
@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {

	@Resource
	PermissionMapper permissiondao;
	public Permission selectByPrimaryKey(String permissionid) throws Exception {
		// TODO Auto-generated method stub
		return this.permissiondao.selectByPrimaryKey(permissionid);
	}

}
