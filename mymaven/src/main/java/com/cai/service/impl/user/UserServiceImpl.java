package com.cai.service.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cai.dao.user.UserMapper;
import com.cai.pojo.user.User;
import com.cai.service.user.UserService;
@Service("userservice")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userdao;

	public User selectByPrimaryKey(String userid) throws Exception {
		
		User user = this.userdao.selectByPrimaryKey(userid);
		return user;
	}
}
