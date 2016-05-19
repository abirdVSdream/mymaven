package com.cai.web.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cai.pojo.user.Correlationupt;
import com.cai.pojo.user.Permission;
import com.cai.pojo.user.Table;
import com.cai.pojo.user.User;
import com.cai.service.user.CorrelationuptService;
import com.cai.service.user.PermissionService;
import com.cai.service.user.TableService;
import com.cai.service.user.UserService;

@Controller
public class CorrelationuptController 
{
	@Autowired
	private CorrelationuptService correlationuptService;
	@Autowired
	private UserService userservice; 
  
	
	@RequestMapping("/permission.html")
	public String toIndex(HttpServletRequest request,Model model) throws Exception
	{
		String userid = request.getParameter("userid");
//		List<Map<String,Object>> lismap = new ArrayList<Map<String,Object>>();
////		List<Table> tableList = new ArrayList();
////		List<Permission> permissionList = new ArrayList();
////		
		List<Correlationupt> correlationuptList = this.correlationuptService.selectByUserid(userid);
//		if(null==correlationuptList)
//		{
//			return null;
//		}
//		Table[] tableArray = new Table[correlationuptList.size()];
//		Permission [] permissionArray = new Permission[correlationuptList.size()];
//		
//		for(int i=0;i<correlationuptList.size();i++)
//		{
//			Table table = this.tableService.selectByPrimaryKey(correlationuptList.get(i).getTableid());
//			Permission permission =this.permissionService.selectByPrimaryKey(correlationuptList.get(i).getPermissionid());
////			tableList.add(table);
////			permissionList.add(permission);
//			Map<String,Object> coMap = new HashMap<String,Object>();
//			Map<String,Object> taMap = new HashMap<String,Object>();
//			Map<String,Object> peMap = new HashMap<String,Object>();
//			coMap.put("correlationuptList"+i, correlationuptList.get(i));
//			taMap.put("table"+i, table);
//			peMap.put("permission"+i, permission);
//			
//			lismap.add(coMap);
//			lismap.add(taMap);
//			lismap.add(peMap);
//			
//		}
		User user = this.userservice.selectByPrimaryKey(userid); 
		
		model.addAttribute("user", user);
		model.addAttribute("correlationuptList", correlationuptList);
//		model.addAttribute("tableArray", tableArray);
//		model.addAttribute("permissionArray", permissionArray);
		
		return "/config/user/user_permission";
	}
	
	
	@RequestMapping("/update.html")
	public String update(HttpServletRequest request,Model model) throws Exception
	{
		
		String [] tableid = request.getParameterValues("tableid");
		String [] permissionid = request.getParameterValues("permissionid");
		String [] selectadd = request.getParameterValues("selectadd");
		String [] selectdelete = request.getParameterValues("selectdelete");
		String [] selectupdate = request.getParameterValues("selectupdate");
		String [] selectsearch = request.getParameterValues("selectsearch");
		String [] selectexport =request.getParameterValues("selectexport");
		String [] selectcheck = request.getParameterValues("selectcheck");
		
		List<Correlationupt> correlationuptList = new ArrayList<Correlationupt>();
		for(int i=0; i<permissionid.length;i++)
		{
			Permission permission  = new Permission();
			Correlationupt correlationupt = new Correlationupt();
			permission.setPermissionid(permissionid[i]);
			permission.setAdd(selectadd[i]);
			permission.setDelete(selectdelete[i]);
			permission.setUpdate(selectupdate[i]);
			permission.setSearch(selectsearch[i]);
			permission.setExport(selectexport[i]);
			permission.setCheck(selectcheck[i]);
			correlationupt.setPermission(permission);
			correlationuptList.add(correlationupt);
		}
		
		String [] newtablename = request.getParameterValues("newtablename");
		String [] newselectadd = request.getParameterValues("newselectadd");
		String [] newselectdelete = request.getParameterValues("newselectdelete");
		String [] newselectupdate = request.getParameterValues("newselectupdate");
		String [] newselectsearch = request.getParameterValues("newselectsearch");
		String [] newselectexport =request.getParameterValues("newselectexport");
		String [] newselectcheck = request.getParameterValues("newselectcheck");
		
		for(int i=0; i<newselectadd.length;i++)
		{
			if(newtablename[i].equals(null)||newtablename[i].equals(""))
			{
				continue;
			}
			Permission permission  = new Permission();
			Table table = new Table();
			Correlationupt correlationupt = new Correlationupt();
			table.setTablename(newtablename[i]);
			permission.setAdd(newselectadd[i]);
			permission.setDelete(newselectdelete[i]);
			permission.setUpdate(newselectupdate[i]);
			permission.setSearch(newselectsearch[i]);
			permission.setExport(newselectexport[i]);
			permission.setCheck(newselectcheck[i]);
			correlationupt.setPermission(permission);
			correlationupt.setTable(table);
			correlationuptList.add(correlationupt);
		}
		
		this.correlationuptService.updateByPermissionAndTable(correlationuptList);
		
		model.addAttribute("succ", "修改成功");
		return "/config/user/user_permission";
	}
	
}
