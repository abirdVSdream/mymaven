package com.cai.service.impl.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cai.dao.user.CorrelationuptMapper;
import com.cai.dao.user.PermissionMapper;
import com.cai.dao.user.TableMapper;
import com.cai.pojo.user.Correlationupt;
import com.cai.pojo.user.Permission;
import com.cai.pojo.user.Table;
import com.cai.service.user.CorrelationuptService;
@Service("CorrelationuptService")
public class CorrelationuptServiceImpl implements CorrelationuptService {
	@Resource
	private CorrelationuptMapper correlationuptdao;
	@Resource
	private PermissionMapper permissiondao;
	@Resource
	private TableMapper tabledao;

	public int deleteByPrimaryKey(String correlationid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Correlationupt record) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(Correlationupt record) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Correlationupt selectByPrimaryKey(String correlationid) throws Exception {
		// TODO Auto-generated method stub
		
		return null;
	}

	public int updateByPrimaryKeySelective(Correlationupt record) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Correlationupt record) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Correlationupt> selectByUserid(String userid) throws Exception {
		// TODO Auto-generated method stub
		
		List<Correlationupt> correlationuptList = this.correlationuptdao.selectByUserid(userid);
		if(null==correlationuptList)
		{
			return null;
		}
		
		for(int i=0;i<correlationuptList.size();i++)
		{
			Table table = this.tabledao.selectByPrimaryKey(correlationuptList.get(i).getTableid());
			Permission permission =this.permissiondao.selectByPrimaryKey(correlationuptList.get(i).getPermissionid());
			correlationuptList.get(i).setTable(table);
			correlationuptList.get(i).setPermission(permission);
		}
		
		return correlationuptList;
	}
	
//	public static void main(String args[])
//	{
//		List<Integer> lis = new ArrayList<Integer>();
//		lis.add(1);
//		lis.add(2);
//		lis.add(3);
//		
//		Object[] array = lis.toArray();
//		for(int i=0;i<array.length;i++)
//		{
//			System.out.println(array[i]);
//		}
//		
//	}

}
