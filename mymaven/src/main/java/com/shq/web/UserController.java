package com.shq.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shq.pojo.Tb_user;
import com.shq.service.IUserService;
import com.shq.service.impl.UserService;

@Controller
public class UserController 
{
	@Autowired
	private IUserService userService;
	@RequestMapping("showUser")
	public String toIndex(HttpServletRequest request,Model model)
	{
		int userid = Integer.parseInt(request.getParameter("id"));
		Tb_user user = this.userService.getUserById(userid);
		model.addAttribute("user", user);
		return "User";
	}
	
	
	
}
