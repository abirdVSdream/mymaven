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
	
	/*
	 * 更新相应的表的权限
	 * 
	 */
	public int updateByPermissionAndTable(List<Correlationupt> record) throws Exception
	{
		for(Correlationupt correlationupt : record)
		{
			if(!(correlationupt.getPermission().getPermissionid() == null ||correlationupt.getPermission().getPermissionid().equals("")))
			{
				//更新权限表
				this.permissiondao.updateByPrimaryKey(correlationupt.getPermission());
			}else
			{
				//以tablename 查找相应的table
				String tablename = correlationupt.getTable().getTablename();
				Table tabl = this.tabledao.selectByTablename(tablename);
				if(tabl == null)
				{
					continue;
				}
				if(tabl.getTableid() == null || tabl.getTableid().equals(""))
				{
					continue;
				}
				String permissionid = tablename+correlationupt.getPermission().getAppend();
				correlationupt.getPermission().setPermissionid(permissionid);
				//插入权限数据
				this.permissiondao.insert(correlationupt.getPermission());
				correlationupt.setTableid(tabl.getTableid());
				correlationupt.setPermissionid(permissionid);
				correlationupt.setCorrelationid(tabl.getTableid()+permissionid);
				//插入关联表
				this.correlationuptdao.insert(correlationupt);
			}
		}
		return 1;
	}
	
/*
 * 根据用户id查找对应表的权限
 * 
 */
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
	
	/*
	 * 根据tablename查找相应的关联权限
	 */
	public List<Correlationupt> selectByTablename(String tablename) throws Exception
	{
		return null;
		
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
