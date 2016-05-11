package com.shq.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shq.dao.Tb_userMapper;
import com.shq.pojo.Tb_user;
import com.shq.service.IUserService;

@Service("userService")
public class UserService implements IUserService {
	
	@Resource
	private Tb_userMapper userDao;
	public Tb_user getUserById(int id) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(id);
	}

}
