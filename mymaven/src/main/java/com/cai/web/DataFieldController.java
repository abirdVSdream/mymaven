package com.cai.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cai.pojo.PT_DataField;
import com.cai.service.DataFieldService;
import com.cai.web.base.BaseController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class DataFieldController extends BaseController
{
	@Autowired
	private DataFieldService dataFieldService;
	
	private static String SEARCH_URL = "config/datafield/dataFieldSearch";
	private static String SAVE_URL = "config/datafield/dataFieldSave";
	private static String CHECK_URL = "config/datafield/dataFieldCheck";
	private static String UPDATE_URL = "config/datafield/dataFieldUpdate";
	private static String DELETE_URL = "config/datafield/dataFieldDelete";

	// 进入页面，不进行任何操作
	@RequestMapping(value = "/config/datafield/gotoPage.html")
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
		
		String datafield = request.getParameter("DATA_FIELD");
		if(!datafield.equals(""))
		{
			List<Map<String, Object>> result = dataFieldService.retrieve(datafield);
			request.setAttribute("result", getJsonText(result));
		}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gotoIndexPage(request, response, urlMap);
	}
	
	//搜索页面
	@RequestMapping(value = "/config/datafield/searchDataField.html")
	public void searchDataField(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String datafield = request.getParameter("DATA_FIELD");
			String description = request.getParameter("DESCRIPTION");
			String datatag = request.getParameter("DATA_TAG");
			String fieldtype = request.getParameter("FIELD_TYPE");
			String maskgroupbo = request.getParameter("MASK_GROUP");
			String fieldunit =request.getParameter("unit");
			
			
			
			if(datafield.equals("") && description.equals("") && datatag.equals("") &&fieldtype.equals(""))
			{
				List<PT_DataField> result = dataFieldService.selectAll();
				outPrintJsonText(request, response, result);
			}else{
				PT_DataField  ptdatafieldbean =  new PT_DataField();
				ptdatafieldbean.setDataField(datafield);;
				ptdatafieldbean.setDataTag(datatag);
				ptdatafieldbean.setDescription(description);
				ptdatafieldbean.setFieldType(fieldtype);
				ptdatafieldbean.setPtMaskGroupBo(maskgroupbo);
				ptdatafieldbean.setFieldUnit(fieldunit);
				
				List<PT_DataField> result = dataFieldService.selectByAnyKey(ptdatafieldbean);
				outPrintJsonText(request, response, result);
			}
		} catch (Exception e) {
			outPrintJsonException(request, response, e);
		}
	}
	
	//新增页面
	@RequestMapping(value = "/config/datafield/saveDataField.html")
	public void saveDataField(HttpServletRequest request,HttpServletResponse response) {
//		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setCharacterEncoding("UTF-8");
//			
//			PtDataFieldBean  ptdatafieldbean =  new PtDataFieldBean();
//			String dataStr = request.getParameter("DATA");
//			JSONObject jsonObj = JSONObject.fromObject(dataStr);
//								
//			String data_field = jsonObj.optString("DATA_FIELD");
//			String description = jsonObj.optString("DESCRIPTION");
//			String data_tag = jsonObj.optString("DATA_TAG");
//			String mark_group = jsonObj.optString("PT_MASK_GROUP_BO");
//			String field_type = jsonObj.optString("FIELD_TYPE");
//			String field_unit = jsonObj.optString("FIELD_UNIT");
//			String value_one = jsonObj.optString("BOOLEAN_ONE_VALUE");
//			String value_zone = jsonObj.optString("BOOLEAN_ZERO_VALUE");
//			
//			ptdatafieldbean.setPlant(this.getPlant(request));
//			ptdatafieldbean.setDataField(data_field);
//			ptdatafieldbean.setDescription(description);
//			ptdatafieldbean.setDataTag(data_tag);
//			
//			PtMaskGroupBean maskGroupBo = new PtMaskGroupBean();
//			maskGroupBo.setCompany(this.getCompany(request));
//			maskGroupBo.setPlant(this.getPlant(request));
//			maskGroupBo.setMaskGroup(mark_group);
//			
//			ptdatafieldbean.setPtMaskGroupBo(maskGroupBo);	
//			ptdatafieldbean.setFieldType(field_type);
//			ptdatafieldbean.setFieldUnit(field_unit);
//			ptdatafieldbean.setBooleanOneValue(value_one);
//			ptdatafieldbean.setBooleanZeroValue(value_zone);
//			ptdatafieldbean.setCompany(this.getCompany(request));
//			ptdatafieldbean.setCreateUserBo(this.getUserBo(request));
//			
//			List<PtDataFieldValueBean> valueList=new ArrayList<PtDataFieldValueBean>();
//			JSONArray jsonArray = jsonObj.optJSONArray("TABLE_DATA");
//			for (int i = 0; i < jsonArray.size(); i++) {
//				PtDataFieldValueBean datafieldvaluebean= ptdatafieldbean.new PtDataFieldValueBean();
//				JSONObject _jsonObj = jsonArray.getJSONObject(i);
//				
//				String sequence = _jsonObj.optString("sequence");
//				String data_value = _jsonObj.optString("data_value");
//				String data_tag1 = _jsonObj.optString("data_tag");
//				String is_default = _jsonObj.optString("is_default");
//			
//				datafieldvaluebean.setSequence(sequence);
//				datafieldvaluebean.setDataValue(data_value);
//				datafieldvaluebean.setDataTag(data_tag1);
//				datafieldvaluebean.setIsDefault(is_default);
//				valueList.add(datafieldvaluebean);
//			}
//			
//			ptdatafieldbean.setDataFieldValueList(valueList);
//			dataFieldService.insert(ptdatafieldbean);
			
			outPrintJsonRight(request, response, "新增成功");
//		} catch (Exception e) {
//			outPrintJsonException(request, response, e);
//		}
	}
	
	//查看页面
	
	/*
	 * 修改中
	 */
	@RequestMapping(value = "/config/datafield/selectDataField.html")
	public void selectDataField(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String dataStr = request.getParameter("DATA");
			JSONObject jsonObj = JSONObject.fromObject(dataStr);

			String datafield = jsonObj.optString("DATA_FIELD");
//			String description = jsonObj.optString("DESCRIPTION");
//			String data_tag = jsonObj.optString("DATA_TAG");
//			String mark_group = jsonObj.optString("pt_mask_group_bo");
//			String field_type = jsonObj.optString("FIELD_TYPE");
//			String field_unit = jsonObj.optString("FIELD_UNIT");
//			String value_one = jsonObj.optString("value_1");
//			String value_zone = jsonObj.optString("value_1");
				
			List<Map<String, Object>> result = dataFieldService.retrieve(datafield);
			outPrintJsonText(request, response, result);

		} catch (Exception e) {
			outPrintJsonException(request, response, e);
		}
	}
	
	 //更新页面
	@RequestMapping(value = "/config/datafield/updateDataField.html")
	public void updateDataField(HttpServletRequest request,
			HttpServletResponse response) {
//		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setCharacterEncoding("UTF-8");
//			
//			PtDataFieldBean ptDataFieldBean = new PtDataFieldBean();
//			String dataStr = request.getParameter("DATA");
//			JSONObject jsonObj = JSONObject.fromObject(dataStr);
//			String data_field = jsonObj.optString("DATA_FIELD");
//			String description = jsonObj.optString("DESCRIPTION");
//			String mark_group = jsonObj.optString("PT_MASK_GROUP_BO");
//			String data_tag = jsonObj.optString("DATA_TAG");
//			String field_type = jsonObj.optString("FIELD_TYPE");
//			String field_unit = jsonObj.optString("FIELD_UNIT");
//			
//			PtMaskGroupBean maskGroupBo = new PtMaskGroupBean();
//			maskGroupBo.setCompany(this.getCompany(request));
//			maskGroupBo.setPlant(this.getPlant(request));
//			maskGroupBo.setMaskGroup(mark_group);
//			
//			ptDataFieldBean.setPtMaskGroupBo(maskGroupBo);	
//			ptDataFieldBean.setPlant(this.getPlant(request));
//			ptDataFieldBean.setCompany(this.getCompany(request));
//			ptDataFieldBean.setDataField(data_field);
//			ptDataFieldBean.setDescription(description);
//			ptDataFieldBean.setDataTag(data_tag);
//			ptDataFieldBean.setFieldType(field_type);
//			ptDataFieldBean.setFieldUnit(field_unit);
//			ptDataFieldBean.setModifiedUserBo(this.getUserBo(request));
//			
//			List<PtDataFieldValueBean> valueList=new ArrayList<PtDataFieldValueBean>();
//			JSONArray jsonArray = jsonObj.optJSONArray("TABLE_DATA");
//			for (int i = 0; i < jsonArray.size(); i++) {
//				PtDataFieldValueBean dataFieldValueBean = ptDataFieldBean.new PtDataFieldValueBean();
//				JSONObject _jsonObj = jsonArray.getJSONObject(i);
//				
//				String sequence = _jsonObj.optString("sequence");
//				String data_value = _jsonObj.optString("data_value");
//				String data_tag1 = _jsonObj.optString("data_tag");
//				String is_default = _jsonObj.optString("is_default");
//			
//				dataFieldValueBean.setSequence(sequence);
//				dataFieldValueBean.setDataValue(data_value);
//				dataFieldValueBean.setDataTag(data_tag1);
//				dataFieldValueBean.setIsDefault(is_default);
//				valueList.add(dataFieldValueBean);
//			}
//			ptDataFieldBean.setDataFieldValueList(valueList);
//			dataFieldService.update(ptDataFieldBean);
			outPrintJsonRight(request, response, "更新成功");
//		} catch (Exception e) {
//			outPrintJsonException(request, response, e);
//		}
	}
	//删除页面
	@RequestMapping(value = "/config/datafield/deleteDataField.html")
	public void deleteDataField(HttpServletRequest request,
			HttpServletResponse response) {
//		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setCharacterEncoding("UTF-8");
//			
			String  datafieldbo = request.getParameter("DATA") ;
//			
//			String dataStr = request.getParameter("DATA");
//			JSONObject jsonObj = JSONObject.fromObject(dataStr);
//			String data_field = jsonObj.optString("DATA_FIELD");
//			
//			ptdatafieldbean.setPlant(this.getPlant(request));
//			ptdatafieldbean.setDataField(data_field);
//			ptdatafieldbean.setCompany(this.getCompany(request));
//			
//			try {
//				dataFieldService.deleteByPrimaryKey(datafieldbo);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				outPrintJsonException(request, response, e);
//			}	
			outPrintJsonRight(request, response, "删除成功");
//		} catch (Exception e) {
//			outPrintJsonException(request, response, e);
//		}
	}

}
