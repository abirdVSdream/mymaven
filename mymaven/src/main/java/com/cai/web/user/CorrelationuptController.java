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
		String [] useri = request.getParameterValues("select");
		for(int i=0;i<useri.length;i++)
		{
			System.out.println(useri[i]);
		}
		
		model.addAttribute("succ", "修改成功");
		return "/config/user/user_permission";
	}
	
}
