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
  
	
	@RequestMapping("/config/user/permission.html")
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
	
	
	@RequestMapping("/config/user/update.html")
	public String update(HttpServletRequest request,Model model) throws Exception
	{
		
//		String [] tableid = request.getParameterValues("tableid");
		String userid = request.getParameter("userid");
		String index = request.getParameter("index");
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
			permission.setAppend(selectadd[i]);
			permission.setDel(selectdelete[i]);
			permission.setUpd(selectupdate[i]);
			permission.setSearch(selectsearch[i]);
			permission.setExp(selectexport[i]);
			permission.setChe(selectcheck[i]);
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
		
		if(!(index==null))
		{
			for(int i=0; i<newselectadd.length;i++)
			{
				if(newtablename[i] == null||newtablename[i].equals(""))
				{
					continue;
				}
				Permission permission  = new Permission();
				Table table = new Table();
				Correlationupt correlationupt = new Correlationupt();
				table.setTablename(newtablename[i]);
				permission.setAppend(newselectadd[i]);
				permission.setDel(newselectdelete[i]);
				permission.setUpd(newselectupdate[i]);
				permission.setSearch(newselectsearch[i]);
				permission.setExp(newselectexport[i]);
				permission.setChe(newselectcheck[i]);
				correlationupt.setUserid(userid);
				correlationupt.setPermission(permission);
				correlationupt.setTable(table);
				correlationuptList.add(correlationupt);
			}
		}
		
		this.correlationuptService.updateByPermissionAndTable(correlationuptList);
		
		List<Correlationupt> correlationuptListresult = this.correlationuptService.selectByUserid(userid);
		
		User user = this.userservice.selectByPrimaryKey(userid); 
		
		model.addAttribute("user", user);
		model.addAttribute("correlationuptList", correlationuptListresult);
		model.addAttribute("succ", "修改成功");
		return "/config/user/user_permission";
	}
	
	
	@RequestMapping("/config/user/selectByTablename.html")
	public String selectByTablename(HttpServletRequest request,Model model) throws Exception
	{
		String userid = request.getParameter("userid");
		String tablename = request.getParameter("tablenamefind");
		
		List<Correlationupt> correlationuptList = this.correlationuptService.selectByTablename(tablename);

		User user = this.userservice.selectByPrimaryKey(userid); 
		
		model.addAttribute("user", user);
		model.addAttribute("correlationuptList", correlationuptList);
//		model.addAttribute("tableArray", tableArray);
//		model.addAttribute("permissionArray", permissionArray);
		
		return "/config/user/user_permission";
	}
}
