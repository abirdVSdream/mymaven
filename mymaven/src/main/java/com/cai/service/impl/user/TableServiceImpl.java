package com.cai.service.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cai.dao.user.TableMapper;
import com.cai.pojo.user.Table;
import com.cai.service.user.TableService;
@Service("TableService")
public class TableServiceImpl implements TableService {
	@Resource
	private TableMapper tabledao;
	public Table selectByPrimaryKey(String tableid) throws Exception {
		// TODO Auto-generated method stub
		
		return this.tabledao.selectByPrimaryKey(tableid);
	}

}
