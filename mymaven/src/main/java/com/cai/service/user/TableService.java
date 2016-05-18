package com.cai.service.user;

import com.cai.pojo.user.Table;

public interface TableService {
	public Table selectByPrimaryKey(String tableid) throws Exception;

}
