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

import com.cai.pojo.DataField;
import com.cai.pojo.DataFileValueList;
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
		if(!(datafield==null ||datafield.equals("")))
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
			String fieldunit =request.getParameter("FIELD_UNIT");
			
			List<DataField> result = new ArrayList<DataField>();
				DataField  ptdatafieldbean =  new DataField();
				ptdatafieldbean.setDataField(datafield);;
				ptdatafieldbean.setDataTag(datatag);
				ptdatafieldbean.setDescription(description);
				ptdatafieldbean.setFieldType(fieldtype);
				ptdatafieldbean.setPtMaskGroupBo(maskgroupbo);
				ptdatafieldbean.setFieldUnit(fieldunit);
				
				result = dataFieldService.selectByAnyKey(ptdatafieldbean);
			
				if(result.isEmpty())
				{
					outPrintJsonError(request, response, "查找的数据为空");
				}
				outPrintJsonText(request, response, result);
				
			} catch (Exception e) {
			outPrintJsonException(request, response, e);
		}
	}
	
	//新增页面
	@RequestMapping(value = "/config/datafield/saveDataField.html")
	public void saveDataField(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		
			DataField  ptdatafieldbean =  new DataField();
			String dataStr = request.getParameter("DATA");
			JSONObject jsonObj = JSONObject.fromObject(dataStr);
								
			String data_field = jsonObj.optString("DATA_FIELD");
			String description = jsonObj.optString("DESCRIPTION");
			String data_tag = jsonObj.optString("DATA_TAG");
			String ptMaskGroupBo = jsonObj.optString("PT_MASK_GROUP_BO");
			String field_type = jsonObj.optString("FIELD_TYPE");
			String field_unit = jsonObj.optString("FIELD_UNIT");
			String value_one = jsonObj.optString("BOOLEAN_ONE_VALUE");
			String value_zone = jsonObj.optString("BOOLEAN_ZERO_VALUE");
			
			
			ptdatafieldbean.setSequence(1001+data_field);
			ptdatafieldbean.setDataField(data_field);
			ptdatafieldbean.setDescription(description);
			ptdatafieldbean.setDataTag(data_tag);
			
			
			ptdatafieldbean.setFieldType(field_type);
			ptdatafieldbean.setFieldUnit(field_unit);
			ptdatafieldbean.setBooleanOneValue(value_one);
			ptdatafieldbean.setBooleanZeroValue(value_zone);
			ptdatafieldbean.setPtMaskGroupBo(ptMaskGroupBo);
			
			List<DataFileValueList> valueList=new ArrayList<DataFileValueList>();
			JSONArray jsonArray = jsonObj.optJSONArray("TABLE_DATA");
			for (int i = 0; i < jsonArray.size(); i++) {
				DataFileValueList datafieldvaluebean= new DataFileValueList();
				JSONObject _jsonObj = jsonArray.getJSONObject(i);
				
				String sequence = _jsonObj.optString("sequence");
				String data_value = _jsonObj.optString("data_value");
				String data_tag1 = _jsonObj.optString("data_tag");
				String is_default = _jsonObj.optString("is_default");
				
				datafieldvaluebean.setHandle(data_field+sequence);
				datafieldvaluebean.setPtDataFieldBo(data_field);
				datafieldvaluebean.setSequence(sequence);
				datafieldvaluebean.setDataValue(data_value);
				datafieldvaluebean.setDataTag(data_tag1);
				datafieldvaluebean.setIsDefault(is_default);
				valueList.add(datafieldvaluebean);
			}
			
			ptdatafieldbean.setDataFieldValueList(valueList);
			dataFieldService.insert(ptdatafieldbean);
			
			outPrintJsonRight(request, response, "新增成功");
		} catch (Exception e) {
			outPrintJsonException(request, response, e);
		}
	}
	
	/*
	 * 查看页面
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
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			DataField ptdatafieldbean = new DataField();
			String dataStr = request.getParameter("DATA");
			JSONObject jsonObj = JSONObject.fromObject(dataStr);
			String data_field = jsonObj.optString("DATA_FIELD");
			String description = jsonObj.optString("DESCRIPTION");
			String mark_group = jsonObj.optString("PT_MASK_GROUP_BO");
			String data_tag = jsonObj.optString("DATA_TAG");
			String field_type = jsonObj.optString("FIELD_TYPE");
			String field_unit = jsonObj.optString("FIELD_UNIT");
			
			ptdatafieldbean.setSequence(1001+data_field);
			ptdatafieldbean.setPtMaskGroupBo(mark_group);	
			ptdatafieldbean.setDataField(data_field);
			ptdatafieldbean.setDescription(description);
			ptdatafieldbean.setDataTag(data_tag);
			ptdatafieldbean.setFieldType(field_type);
			ptdatafieldbean.setFieldUnit(field_unit);
			
			List<DataFileValueList> valueList=new ArrayList<DataFileValueList>();
			JSONArray jsonArray = jsonObj.optJSONArray("TABLE_DATA");
			for (int i = 0; i < jsonArray.size(); i++) {
				DataFileValueList datafieldvaluebean = new DataFileValueList();
				JSONObject _jsonObj = jsonArray.getJSONObject(i);
				
				String sequence = _jsonObj.optString("sequence");
				String data_value = _jsonObj.optString("data_value");
				String data_tag1 = _jsonObj.optString("data_tag");
				String is_default = _jsonObj.optString("is_default");
			
				datafieldvaluebean.setHandle(data_field+sequence);
				datafieldvaluebean.setSequence(sequence);
				datafieldvaluebean.setDataValue(data_value);
				datafieldvaluebean.setDataTag(data_tag1);
				datafieldvaluebean.setIsDefault(is_default);
				valueList.add(datafieldvaluebean);
			}
			ptdatafieldbean.setDataFieldValueList(valueList);
			this.dataFieldService.updateByPrimaryKeySelective(ptdatafieldbean);
			outPrintJsonRight(request, response, "更新成功");
		} catch (Exception e) {
			outPrintJsonException(request, response, e);
		}
	}
	//删除页面
	@RequestMapping(value = "/config/datafield/deleteDataField.html")
	public void deleteDataField(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String dataStr = request.getParameter("DATA");
			JSONObject jsonObj = JSONObject.fromObject(dataStr);
			String datafield = jsonObj.optString("DATA_FIELD");
			
			dataFieldService.deleteByPrimaryKey(datafield);
			outPrintJsonRight(request, response, "删除成功");
		} catch (Exception e) {
			outPrintJsonException(request, response, e);
		}
	}

}
