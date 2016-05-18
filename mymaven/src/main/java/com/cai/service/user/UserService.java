package com.cai.service.user;

import com.cai.pojo.user.User;

public interface UserService 
{

	  public User selectByPrimaryKey(String userid) throws Exception;

}
