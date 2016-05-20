package com.cai.web.user;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cai.pojo.user.User;
import com.cai.service.user.UserService;
import com.shq.pojo.Tb_user;

@Controller
public class UserController 
{
	@Autowired
	private UserService userservice; 
	
//	@RequestMapping("/user.html")
//	public User searchDataField(HttpServletRequest request,
//			HttpServletResponse response) {
//		User user = null;
//		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setCharacterEncoding("UTF-8");
//			
//			String userid = request.getParameter("userid"); 
//			
//			 user = this.userservice.selectByPrimaryKey(userid);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return user;
//		
//	}
	
	@RequestMapping("/user/user.html")
	public String toIndex(HttpServletRequest request,Model model) throws Exception
	{
		String userid = request.getParameter("userid"); 
		User user = null;
		 user = this.userservice.selectByPrimaryKey(userid);
		model.addAttribute("user", user);
		return "/config/user/user";
	}
	

}
