/**
 * TODO
 * @author caizelin
 * 2015年3月10日下午4:25:42
*/

package com.cai.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cai.pojo.CmFunct;
import com.cai.pojo.CmFunctGroup;
import com.cai.service.FunctGroupService;
import com.cai.web.base.BaseController;



@Controller
public class FunctGroupController extends BaseController {
	@Autowired
	private FunctGroupService functGroupService;
//	@Autowired
//	private ParamGroupServiceI paramGroupService;
	
	private static String SEARCH_URL = "config/functgroup/functGroupSearch";
	private static String SAVE_URL = "config/functgroup/functGroupSave";
	private static String CHECK_URL = "config/functgroup/functGroupCheck";
	private static String UPDATE_URL = "config/functgroup/functGroupUpdate";
	private static String DELETE_URL = "config/functgroup/functGroupDelete";
	
	// 进入页面，不进行任何操作
	@RequestMapping(value = "/cai/functgroup/gotoPage.html")
	public ModelAndView gotoPage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> urlMap = new HashMap<String, String>();
		urlMap.put("SEARCH", SEARCH_URL);
		urlMap.put("SAVE", SAVE_URL);
		urlMap.put("CHECK", CHECK_URL);
		urlMap.put("UPDATE", UPDATE_URL);
		urlMap.put("DELETE", DELETE_URL);
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			String functGroup = request.getParameter("FUNCT_GROUP");
			
			CmFunctGroup cmFunctGroupBean = new CmFunctGroup();
			
			cmFunctGroupBean.setHandle(1001+functGroup);
			cmFunctGroupBean.setFunctGroup(functGroup);
			
			// 检索数据
//			List<CmFunctGroup>functGroupNotIntList = functGroupService.selectFunctGroupNotInList();
//			List<CmFunct>functNotIntList = functGroupService.selectFunctNotInList();
//
//			request.setAttribute("functGroupNotIntList", getJsonText(functGroupNotIntList));
//			request.setAttribute("functNotIntList", getJsonText(functNotIntList));
//			
			Map<String, Object> map = functGroupService.selectfromCmFgMember(cmFunctGroupBean);
			
			request.setAttribute("FUNCTGROUP_RESULT", getJsonText(map));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gotoIndexPage(request, response, urlMap);
	}
	
	//查询
	@RequestMapping(value="/cai/functgroup/searchFunctGroup.html")
	public void searchFunMaintenance(HttpServletRequest request, 
			HttpServletResponse response){
		try{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			//查询条件
			String functGroup = request.getParameter("FUNCT_GROUP");
			String description = request.getParameter("DESCRIPTION");
			String memo = request.getParameter("MEMO");
			
			CmFunctGroup cmFunctGroupBean = new CmFunctGroup();
			
			cmFunctGroupBean.setFunctGroup(functGroup);
			cmFunctGroupBean.setDescription(description);
			cmFunctGroupBean.setMemo(memo);
			
			List<CmFunctGroup> list = functGroupService.selectByAnyOne(cmFunctGroupBean);//按照查询条件查询到的数据
			outPrintJsonText(request, response, list);//把list查询结果转换成json字符串并传递到页面--chy
		}catch(Exception e){
			outPrintJsonException(request, response, e);
		}	
	}
	
	//查看
	@RequestMapping(value="/cai/functgroup/checkFunctGroup.html")
	public void  checkFunMaintenance(HttpServletRequest request , HttpServletResponse response){
		try{
			
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String dataStr = request.getParameter("DATA");
			JSONObject jsonObj = JSONObject.fromObject(dataStr);
			
			String functGroup = jsonObj.optString("FUNCT_GROUP");
			
			
			CmFunctGroup cmFunctGroupBean = new CmFunctGroup();
			
			cmFunctGroupBean.setHandle(1001+functGroup);
			cmFunctGroupBean.setFunctGroup(functGroup);
			
			Map<String, Object> list = functGroupService.selectfromCmFgMember(cmFunctGroupBean);
			outPrintJsonText(request, response, list);
		}catch(Exception e){
			outPrintJsonException(request, response, e);
			}
	}
	
//	public CmFunctGroupBean showParam(HttpServletRequest request,String dataStr)
//	{
//		JSONObject jsonObj = JSONObject.fromObject(dataStr);
//		String functGroup = jsonObj.optString("FUNCT_GROUP");
//		String groupName = jsonObj.optString("GROUP_NAME");
//		String functGroupList = jsonObj.optString("functGroupList");
//		String functList = jsonObj.optString("functList");
//		
//		String group [] = functGroupList.substring(1, functGroupList.length()-1).replace("\"", "").split(",");
//		String funct [] = functList.substring(1, functList.length()-1).replace("\"", "").split(",");
//		
//		String company = this.getCompany(request);
//		List <CmFunctGroupBean> GroupList = new ArrayList <CmFunctGroupBean>();
//		List <CmFunctBean> functListA = new ArrayList <CmFunctBean>();
//		
//		for(int i=0;i<group.length;i++)
//		{
//			CmFunctGroupBean cmFunctGroupBean = new CmFunctGroupBean();
//			cmFunctGroupBean.setCompany(company);
//			cmFunctGroupBean.setFunctGroup(group[i]);;
//			GroupList.add(cmFunctGroupBean);
//		}
//
//		for(int i=0;i<funct.length;i++)
//		{
//			CmFunctBean cmFunctBean = new CmFunctBean();
//			cmFunctBean.setCompany(company);
//			cmFunctBean.setFunct(funct[i]);
//			functListA.add(cmFunctBean);
//		}
//		
//		
//		CmFunctGroupBean cmFunctGroupBean = new CmFunctGroupBean();
//		cmFunctGroupBean.setCompany(company);
//		cmFunctGroupBean.setFunctGroup(functGroup);
//		cmFunctGroupBean.setGroupName(groupName);
//		cmFunctGroupBean.setFunctGroupMemberList(GroupList);
//		cmFunctGroupBean.setFunctMemberList(functListA);
//		return cmFunctGroupBean;
//	
//	}
//	//新建保存
//	@RequestMapping(value="/admin/functgroup/saveFunctgroup.html")
//	public void insertFunMaintenance(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
//	{
//		try{
//			request.setCharacterEncoding("UTF-8");
//			response.setCharacterEncoding("UTF-8");
//			
//			String dataStr = request.getParameter("DATA");
//			
//			CmFunctGroupBean cmFunctGroupBean = showParam(request, dataStr);
//			cmFunctGroupBean.setCreateUserBo(this.getUserBo(request));
//			
//			functGroupService.insert(cmFunctGroupBean);
//			outPrintJsonRight(request, response, "新建保存成功");
//		}catch(Exception e){
//			outPrintJsonException(request, response, e);
//		}
//	}
//	
//	//删除
//	@RequestMapping(value="/admin/functgroup/deleteFunctgroup.html")
//	public void deleteFunMaintenance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//	{
//		try{
//			request.setCharacterEncoding("UTF-8");
//			response.setCharacterEncoding("UTF-8");
//			
//			String dataStr = request.getParameter("DATA");
//			JSONObject jsonObj = JSONObject.fromObject(dataStr);
//			String functGroup = jsonObj.optString("FUNCT_GROUP");
//			
//			CmFunctGroupBean cmFunctGroupBean = new CmFunctGroupBean();
//			cmFunctGroupBean.setCompany(this.getCompany(request));
//			cmFunctGroupBean.setFunctGroup(functGroup);
//			functGroupService.delete(cmFunctGroupBean);
//			outPrintJsonRight(request, response, "删除成功");
//		}catch(Exception e){
//			outPrintJsonException(request, response, e);
//		}
//	}
//	
//	//更新
//	@RequestMapping(value="/admin/functgroup/updateFunctgroup.html")
//	public void updatelabels(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
//	{
//		try{
//			
//			request.setCharacterEncoding("UTF-8");
//			response.setCharacterEncoding("UTF-8");
//			
//			String dataStr = request.getParameter("DATA");
//			JSONObject jsonObj = JSONObject.fromObject(dataStr);
//			String funct_group = jsonObj.optString("FUNCT_GROUP");
//			
//			CmFunctGroupBean cmFunctGroupBean = showParam(request, dataStr);
//			cmFunctGroupBean.setCompany(this.getCompany(request));
//			cmFunctGroupBean.setFunctGroup(funct_group);
//			cmFunctGroupBean.setModifiedUserBo(this.getUserBo(request));
//			
//			functGroupService.update(cmFunctGroupBean);
//			outPrintJsonRight(request, response, "更新成功");
//		}catch(Exception e){
//			outPrintJsonException(request, response, e);
//		}
//	}
//
//	@Override
//	public BaseServiceI getService() {
//		return this.functGroupService;
//	}

}

