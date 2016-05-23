<%@ page language="java" contentType="text/html; utf8"
    pageEncoding="utf-8" deferredSyntaxAllowedAsLiteral="true"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%request.setAttribute("rootPath",request.getContextPath());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>功能组维护</title>
<link href="${pageContext.request.contextPath}/com/cai/frame/css/css.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/com/cai/frame/js/yui_3.18.1/yui/yui-min.js"></script>
<script src="${pageContext.request.contextPath}/com/cai/frame/js/yui-common.js"></script>
<script type="text/javascript">
var rootPath = '${rootPath}';
var table;//
var HANDLE = "";
var plant="";
var data_group = '${DATA_GROUP}';
var data_field = '${DATA_FIELD}';
var result = '${result}';
//没实现
YUI().use('node', 'io', 'json-parse', 'json-stringify','event', 'imes-YuiCommon', 'node-menunav', function(Y){
	var common = Y.YuiCommon;//自定义common模块
	Y.on('io:failure', common.AjaxFailure);//调用Ajax失败方法
	
	//-------ajax请求数据---------
	
	var selectData = function(){
		common.clearMessage();//调用清除消息方法
		var funct_group = Y.one("#FUNCT_GROUP").get("value");
		if(funct_group == ""){
			common.setMessage("N", "请输入参数组名称进行检索");
			return;
		}
		var data = {};
		data.FUNCT_GROUP = funct_group;
		var dataStr = Y.JSON.stringify(data);
		var request = Y.io("${rootPath}/admin/functgroup/selectFunctGroup.html", { 
			method: "POST", 
			data: "DATA=" + dataStr,
			on: {
				success: function(ioId, o){ 
					if (o.responseText !== undefined && o.responseText != "") { 
						var s = o.responseText; 
						var data = Y.JSON.parse(s);
						if(data.result.length > 0){
							_setData(s);//给dataTable设值
						} else {
							 toEmpty();
							common.setMessage("N","未找到对应的参数组数据");
						}
					}
				}
			}
		}); 
	} 
	Y.on("click", selectData, "#selectData");//注册按钮点击事件 查询数据
	
	
	
	_setData = function(s){
		var _data = Y.JSON.parse(s);
		var _result = _data.result;
		if(_result.length > 0){
			Y.one("#FUNCT_GROUP").set("value", _result[0].FUNCT_GROUP);
			Y.one("#GROUP_NAME").set("value", _result[0].GROUP_NAME);
			Y.one("#MEMO").set("value", _result[0].MEMO);
			Y.one("#IMAGE").set("value", _result[0].IMAGE);
			if(_result[0].dataGroupFieldList != null)
			{
				for(var i = 0;i < functMemberList.length;i++)
				{
					var funct_name = functMemberList[i].FUNCT_NAME;//描述
					//var id = result[i].id; //value
					//var def_val = result[i].def_val;
					html = html + "<option value='" + id + "' >" + funct_name +"</option>";
				}
				Y.one("#datatable" ).set("innerHTML", html);
				}
			
			
			//Y.one("#CATEGORY").set("value", _result[0].CATEGORY);
			
			var dataGroupFieldList = _result[0].dataGroupFieldList;
			_removeAllRow();
			for(var i = 0;i < dataGroupFieldList.length;i++){
				table.addRow(dataGroupFieldList[i]);
			}
		}
	}
	
	
	/*var html = "<option value='' selected='selected'>===请选择===</option>";
		if(_data.status == "Y"){
			for(var i = 0;i < result.length;i++){
				var desc = result[i].desc;//描述
				var id = result[i].id; //value
				var def_val = result[i].def_val;
				html = html + "<option value='" + id + "' >" + desc +"</option>";
			}
			Y.one("#" + selectIds[j]).set("innerHTML", html);*/
			
	
	
	var toEmpty = function(){
		Y.one("#DATA_GROUP").set("value", "");
		Y.one("#DESCRIPTION").set("value", "");
		Y.one("#CM_STATUS_BO").set("value", "");
		Y.one("#DATA_GROUP_TAG").set("value", "");
		Y.one("#CATEGORY").set("value", "");
		common.clearMessage();//调用清除消息方法
		table.set('data',[]);
	}
	Y.on("click", toEmpty, "#toEmpty");//注册按钮点击事件 清空数据

	//注册弹出框
	
	showfield = function(key){
		var dataField = Y.one("#datd_field_" + key).get("value");
		var searchData = {};
		searchData.dataField = dataField;
		var paramStr = Y.JSON.stringify(searchData);
		var ret = common.showDialog(paramStr, "dataname");
    	if(typeof(ret) != "undefined"){ 
    		var returnData = Y.JSON.parse(ret);
    		Y.one("#datd_field_" + key).set("value", returnData.data_field);
    		Y.one("#data_tag_" + key).set("value", returnData.data_tag);
    	}
	}
	
	var showName = function(){
		var data_group = Y.one("#DATA_GROUP").get("value");
		var searchData = {};
		searchData.dataGroup = data_group;
		var paramStr = Y.JSON.stringify(searchData);
		var ret = common.showDialog(paramStr, "data_group_name");
    	if(typeof(ret) != "undefined"){ 
    		var returnData = Y.JSON.parse(ret);
    		Y.one("#DATA_GROUP").set("value", returnData.data_group);
    	}
	}
	Y.on("click", showName, "#showName");
	
	var getSelect = function(){
		var datas = [];
		var selectIds = [];
		
		var data = {};
		data.SQLID = "status";
		data.PARAM = "DATA_GROUP";
		var data1 = {};
		data1.SQLID = "data_group_type_option";
		
		datas.push(data);
		datas.push(data1);
		
		selectIds.push("CM_STATUS_BO");
		selectIds.push("CATEGORY");
		common.initSelectOptions(datas, selectIds);
		
		if(result != ""){
			_setData(result);
		}
	}
	Y.on("domready", getSelect, window);
	
	//-------加载tabview-------
	var htmlStr = '<input id="selectData" type="button" value="检 索" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
					'<input id="toEmpty" type="button" value="清  空" />';
	//tabview 加载渲染完后的回调函数
	var _callBackFn =  function(){
	}
	common.initTabView(htmlStr, _callBackFn);

	var menu = Y.one("#menuBar");
	menu.plug(Y.Plugin.NodeMenuNav);
	//-------加载tabview-------
});

</script>
</head>
<body class="yui3-skin-sam">
<div id="functbox">
	<div id="menuBar" class="yui3-menu yui3-menu-horizontal yui3-menubuttonnav">
		<div class="yui3-menu-content" style="background-position-y: -1300px;">
	         <ul class="first-of-type">
	            <li class="yui3-menuitem" style="font-weight:bold; border-right: 0px;">
	            	<a href="#" class="yui3-menuitem-content" style="padding-left: 0px; padding-right: 0px;">后台设置&nbsp;&nbsp;&gt;</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; border-right: 0px;">
	                <a href="#" class="yui3-menuitem-content" style="padding-left: 5px; padding-right: 0px;">参数组设定&nbsp;&nbsp;&gt;</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; border-right: 0px;">
	                <a href="#" class="yui3-menuitem-content" style="padding-left: 5px; padding-right: 0px;">查看</a>
	            </li>
				<li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	            	<a href="#" class="yui3-menuitem-content">帮助</a>
	            </li>
	           	<li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	             	<a href="#" class="yui3-menuitem-content">导出</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	             	<a href="#" class="yui3-menuitem-content">导入</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	            	<a href="${rootPath}/admin/functgroup/gotoPage.html?OPER=DELETE" class="yui3-menuitem-content">删除</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	                <a href="${rootPath}/admin/functgroup/gotoPage.html?OPER=UPDATE" class="yui3-menuitem-content">更新</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	                <a href="${rootPath}/admin/functgroup/gotoPage.html?OPER=SAVE" class="yui3-menuitem-content">创建</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	                <a href="${rootPath}/admin/functgroup/gotoPage.html?OPER=SEARCH" class="yui3-menuitem-content">查询</a>
	            </li>
	         </ul>
		</div>
	</div>

	<div id="infoArea" class="ftinfo"></div>
		<table align="center">	
			<tr style="font-weight: bold;">
							<td class="ftkeydatatdlabel">功能组:</td>
							<td>
							  <input id="FUNCT_GROUP" name="FUNCT_GROUP" type="text" size="25"/>	
							</td>
							<td>
								<img id="showGroup" src="${rootPath}/image/search1.png" style="vertical-align: middle;" title="选择以浏览"/>
			    			</td>
   			</tr>
		</table>
	<div id="tabView">
		    <ul>
		        <li><a href="#foo">主要</a></li>
		        <li id="listSet"><a href="#bar">功能</a></li>
		    </ul>
      	<div>
      		<div id="foo" style="height: 400px;"> 
        	 	<table align="center">
						<tr>
							<td class="ftkeydatatdlabel">功能组:</td>
							<td class="ftkeydatatdinput">
								<input id="FUNCT_GROUP" name="FUNCT_GROUP" type="text" size="20" />
							</td>
						</tr>
						<tr>
							<td class="ftkeydatatdlabel">描述:</td>
							<td class="ftkeydatatdinput">
								<input id="GROUP_NAME" name="GROUP_NAME" type="text" size="20" />
							</td>
						</tr>
						<tr>
							<td class="ftkeydatatdlabel">备注:</td>
							<td class="ftkeydatatdinput">
								<input id="MEMO" name="MEMO" type="text" size="20" />
							</td>
								
						</tr>
						<tr>
							<td class="ftkeydatatdlabel">链接:</td>
							<td class="ftkeydatatdinput">
							    <input id="IMAGE" name="IMAGE" type="text" size="20" />
							</td>
						</tr>
					</table>         
        	</div>
        	<div id="bar">
        		<table align="center">
					<tr>
						<td colspan="2">可选功能：
						    <input id="" size="25" name = "FUNCT" />
						    <input type="button" size="10" name="file" value="搜索"/>
						</td> 
						<td>已选功能：</td>
					</tr>
					<tr>
					    <td rowspan="7">
                            <select  id="datatable" name="left" size="10" id="select" multiple style="width:100px; ">
                           	 <option id=""></option>
                            </select>
                        </td>
						<td >
							<input  name="TEMPLATE" type="button" value="&nbsp;&nbsp;>&nbsp;&nbsp;" />
						</td>
						<td rowspan="7">
                             <select name="right" size="10" id="select" multiple style="width:100px; ">
                              	<option id=""></option>
                              </select>
                        </td>
					</tr>
					<tr>
						<td >
							<input  name="TEMPLATE" type="button" value="&nbsp;&nbsp;<&nbsp;&nbsp;" />
						</td>
					</tr>
					<tr>
						<td >
							<input name="TEMPLATE" type="button" value="&nbsp;>>&nbsp;" />
						</td>
					</tr>
					<tr>
						<td >
							<input  name="TEMPLATE" type="button" value="&nbsp;<<&nbsp;" />
						</td>
					</tr>
					<tr>
					    <td rowspan="3">&nbsp;</td>
					</tr>
	       		</table>
        	</div>
       	</div>
    </div>
</div>
</body>
</html>