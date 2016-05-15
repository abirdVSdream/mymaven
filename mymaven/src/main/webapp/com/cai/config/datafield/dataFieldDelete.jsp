<%@ page language="java" contentType="text/html; utf8"
    pageEncoding="utf-8" deferredSyntaxAllowedAsLiteral="true"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%request.setAttribute("rootPath",request.getContextPath());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>数据字段定义</title>
<link href="${pageContext.request.contextPath}/com/cai/frame/css/css.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/com/cai/frame/js/yui_3.18.1/yui/yui-min.js"></script>
<script src="${pageContext.request.contextPath}/com/cai/frame/js/yui-common.js"></script>
<script type="text/javascript">
var rootPath = '${rootPath}';
var table;//
var HANDLE = "";
var result = '${result}';
YUI().use('datatable', 'datatable-scroll', 'datatype-number', 'node', function (Y) {	
	//-------加载table---------
	var data = [];
	table = new Y.DataTable({
		columns: [
		  		  	    { key: 'select', label: '<input type="checkbox" class="protocol-select-all"/>选择', 
				  	    	width: '10%', allowHTML: true, 
				  	    	formatter: function(o){
				  	    		var rowCount = table.data.toArray().length;
				  	    		var htmlStr = '<input type="checkbox" id="check_' + (rowCount - 1) + '" />';
				                  return htmlStr;
				              } 
				  	    },
				  	  { key: 'SEQUENCE', label: '序号', width: '15%', allowHTML: true,
					    	formatter: function(o){
					    		var rowCount = table.data.toArray().length;
					    		var sequence = o.data.SEQUENCE || "";
					    		var htmlStr = '<input type="text" id="sequence_' + (rowCount - 1) + '" value="' + sequence + '"/>';
				                return htmlStr;
				            }
					    },
				  	    { key: 'DATA_VALUE', label: '指定值', width: '30%', allowHTML: true,
				  	    	formatter: function(o){
				  	    		var rowCount = table.data.toArray().length;
				  	    		var data_value = o.data.DATA_VALUE || "";
				  	    		var htmlStr = '<input type="text" id="data_value_' + (rowCount - 1) + '" value="' + data_value + '" />';
				                  return htmlStr;
				              }
				  	    },
				  	    { key: 'DATA_TAG', label: '对应标识', width: '30%', allowHTML: true,
				  	    	formatter: function(o){
				  	    		var htmlStr = "";
				  	    		var rowCount = table.data.toArray().length;
				  	    		var data_tag = o.data.DATA_TAG || "";
				  	    			htmlStr = '<input type="text" id="data_tag_' + (rowCount - 1) + '" value="' + data_tag + '" />'
				                  return htmlStr;
				              }
				  	    },
				  	    { key: 'IS_DEFAULT', label: '默认标签', width: '15%', allowHTML: true,
				  	    	formatter: function(o){
				  	    		var htmlStr = "";
				  	    		var rowCount = table.data.toArray().length;
				  	    		var is_default= o.data.IS_DEFAULT|| "";
				  	    		if(is_default=="true")
			  	    			{
			  	    				 htmlStr = '<input type="radio" id="is_default_' + (rowCount - 1) + '"  name="is_default" checked="checked" />';
			  	    			}else{
			  	    				 htmlStr = '<input type="radio" id="is_default_' + (rowCount - 1) + '"  name="is_default" />';
			  	    			}
				                  return htmlStr;
				              }
				  	    }
				  	],
	data: data,
	width: '100%'
	});

	table.render('#datatable');
	//-------加载table---------
});


var  _getData;
var _setData;
var _removeAllRow;
YUI().use('node', 'json-parse', 'json-stringify', function(Y) {
	//操作datatable
	  var _addRowToDataTable = function(){
		  table.addRow({});
	}
	Y.on("click", _addRowToDataTable, "#addRow");
	
	//全选全不选功能
	table.delegate('click', function (e) {
        var checked = e.target.get('checked') || undefined;
        if(checked){
        	table.data.each(function (data, i) {
        		Y.one('#check_' + i).set("checked", true);
        	});
        }else{
        	table.data.each(function (data, i) {
        		Y.one('#check_' + i).set("checked", false);
        	});
        }
    }, '.protocol-select-all', table);//根据样式得到dom
    
  	//移除全部功能
  	_removeAllRow = function(){
  		table.set('data', []);
    }
	Y.on("click", _removeAllRow, "#removeAllRow");
	
	//移除选定项功能
	var _removeRow = function(){
  		var tableData = table.data.toArray();
		var rowCount = tableData.length;
		var tableRowValue = [];
		for(var i = rowCount - 1;i >= 0;i--){
			var checked = Y.one('#check_' + i).get("checked") || undefined;
	  		if(checked){
				table.removeRow(i);
			}else{
				var tableRow = {};
				tableRow.SEQUENCE = Y.one('#sequence_' + i).get("value");
				tableRow.DATA_VALUE = Y.one('#data_value_' + i).get("value");
				tableRow.DATA_TAG = Y.one('#data_tag_' + i).get("value");
				tableRow.IS_DEFAULT = Y.one('#is_default_' + i).get("value");
				tableRowValue.push(tableRow);
			}
		}
		table.set("data", []);
		for(var j = tableRowValue.length - 1;j >= 0;j--){
			table.addRow(tableRowValue[j]);
		}
    }
	Y.on("click", _removeRow, "#removeRow");
	
	
	_getData = function(){
		var data = {};
		var data_field = Y.one("#DATA_FIELD").get("value");
		var description = Y.one("#DESCRIPTION").get("value");
		var data_tag = Y.one("#DATA_TAG").get("value");
		var field_type = Y.one("#FIELD_TYPE").get("value");
		var pt_mask_group_bo = Y.one("#PT_MASK_GROUP_BO").get("value");
		var field_unit = Y.one("#FIELD_UNIT").get("value");
		var value_1 = Y.one("#value_1").get("value");
		var value_0 = Y.one("#value_0").get("value");

		data.DATA_FIELD = data_field;
		data.DESCRIPTION = description;
		data.DATA_TAG = data_tag;
		data.FIELD_TYPE = field_type;
		data.PT_MASK_GROUP_BO = pt_mask_group_bo;
		data.FIELD_UNIT = field_unit;
		data.BOOLEAN_ONE_VALUE = value_1;
		data.BOOLEAN_ZERO_VALUE = value_0;
		var tableData = [];
		var rowCount = table.data.toArray().length;
		for(var i = 0;i < rowCount;i++){
			var rowData = {};
			rowData.sequence = Y.one('#sequence_' + i).get("value");
			rowData.data_value = Y.one('#data_value_' + i).get("value");
			rowData.data_tag = Y.one('#data_tag_' + i).get("value");
			rowData.is_default = Y.one('#is_default_' + i).get("checked");
			tableData.push(rowData);
		}
		data.TABLE_DATA = tableData;
		return data;
	}
	
	_setData = function(s){
		var _data = Y.JSON.parse(s);
		var _result = _data.result;
		if(_result.length > 0){
			HANDLE = _result[0].DATA_FIELD;//标记检索的数据的handle
			Y.one("#DATA_FIELD").set("value", _result[0].DATA_FIELD);
			Y.one("#DESCRIPTION").set("value", _result[0].DESCRIPTION);
			Y.one("#DATA_TAG").set("value", _result[0].DATA_TAG);
			Y.one("#PT_MASK_GROUP_BO").set("value", _result[0].MASK_GROUP);
			Y.one("#FIELD_TYPE").set("value", _result[0].FIELD_TYPE);
			Y.one("#FIELD_UNIT").set("value", _result[0].FIELD_UNIT);
			Y.one('#value_1').set("value",_result[0].BOOLEAN_ONE_VALUE || "");
			Y.one('#value_0').set("value",_result[0].BOOLEAN_ZERO_VALUE || "");
			
			var dataFieldValueList = _result[0].dataFieldValueList;
			_removeAllRow();
			for(var i = 0;i < dataFieldValueList.length;i++){
				table.addRow(dataFieldValueList[i]);
			}
		}	
	}
});

YUI().use('node', 'io', 'json-parse', 'json-stringify', 'imes-YuiCommon','node-menunav', function(Y){
	var common = Y.YuiCommon;//自定义common模块
	Y.on('io:failure', common.AjaxFailure);//调用Ajax失败方法

	common.clearMessage();
	//有问题 
	var deleteData = function(){
		var data_field = Y.one("#DATA_FIELD").get("value");
		if(data_field == ""){
			common.setMessage("N", "请输入字段名称");
			return;
		}
		if(HANDLE == ""){
			common.setMessage("N", "请先检索数据再进行更新操作");
			return;
		}
		if(HANDLE != data_field){
			var plant = <%=(String)request.getSession().getAttribute("plant") %>;
			common.setMessage("N", "请先检索工厂" + plant + "下数据字段" + data_field + "数据再进行删除操作");
			return;
		}
		
		var data = _getData();
		var dataStr = Y.JSON.stringify(data);
		var request = Y.io("${rootPath}/config/datafield/deleteDataField.html", { 
			method: "POST", 
			data: "DATA=" + dataStr,
			on: {
				success: function(ioId, o){ 
					if (o.responseText !== undefined) { 
						var s = o.responseText;
						toEmpty();
						common.setMessage("Y", o.responseText);
					} 
				}
			}
		}); 
	} 
	Y.on("click", deleteData, "#deleteData");//注册按钮点击事件 
	//-------ajax请求数据---------
	
	var selectData = function(){
		common.clearMessage();
		var data_field = Y.one("#DATA_FIELD").get("value");
		if(data_field == ""){
			common.setMessage("N", "请输入字段名称");
			return;
		}
		var data = {};
		data.DATA_FIELD = data_field;
		var dataStr = Y.JSON.stringify(data);
		var request = Y.io("${rootPath}/config/datafield/selectDataField.html", { 
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
							_removeAllRow();
							common.setMessage("N","未找到对应的参数组数据");
						}
					}
				}
			}
		}); 
	} 
	Y.on("click", selectData, "#selectData");//注册按钮点击事件 查询数据
	
	var toEmpty = function(){
		Y.one('#DATA_FIELD').set("value", "");
		Y.one('#DESCRIPTION').set("value", "");
		Y.one('#DATA_TAG').set("value", "");
		Y.one('#PT_MASK_GROUP_BO').set("value", "");
		Y.one('#value_1').set("value", "");
		Y.one('#value_0').set("value", "");
		common.clearMessage();
		HANDLE="";
		table.set('data',[]);
	}
	Y.on("click", toEmpty, "#toEmpty");//注册按钮点击事件 清空数据
	
	var showName = function(){
		var data_field = Y.one("#DATA_FIELD").get("value");
		var searchData = {};
		searchData.dataField = data_field;
		var paramStr = Y.JSON.stringify(searchData);
		var ret = common.showDialog(paramStr, "dataname");
    	if(typeof(ret) != "undefined"){ 
    		var returnData = Y.JSON.parse(ret);
    		Y.one("#DATA_FIELD").set("value", returnData.data_field);
    	}
	}
	Y.on("click", showName, "#showName");
	
	var showMark = function(){
		var maskGroup = Y.one("#PT_MASK_GROUP_BO").get("value");
		var searchData = {};
		searchData.maskGroup = maskGroup;
		var paramStr = Y.JSON.stringify(searchData);
		var ret = common.showDialog(paramStr, "mask_group");
    	if(typeof(ret) != "undefined"){ 
    		var returnData = Y.JSON.parse(ret);
			Y.one("#PT_MASK_GROUP_BO").set("value", returnData.mask_group);
    	}
	}
	Y.on("click", showMark, "#showMark");
	
	var changeEvent = function(){
		var obj = document.getElementById("value_0");
		var obj1 = document.getElementById("value_1");
		if(Y.one("#FIELD_TYPE").get("value") == "boolean"){
			obj.disabled = false;
			obj1.disabled = false;
		}else{
			obj.disabled = true;
			obj1.disabled = true;
		};
		if(Y.one("#FIELD_TYPE").get("value") == "list"){
			Y.one("#listSet").setStyle("display", "inline");
		}else{
			Y.one("#listSet").setStyle("display", "none");
		}
	}
	Y.on("change", changeEvent, "#FIELD_TYPE");
	
	
	
	var htmlStr = '<input id="selectData" type="button" value="检  索" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
				'<input id="deleteData" type="button" value="删  除" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
				'<input id="toEmpty" type="button" value="清  空" />' ;
	//tabview 加载渲染完后的回调函数
	var _callBackFn =  function(){
	}
	common.initTabView(htmlStr, _callBackFn);
	//-------加载tabview-------
	
	var getSelect = function(){
	if(result != ""){
	_setData(result);
	}
	}
	Y.on("domready", getSelect, window);
	
	//-------加载menuBar---------
	var menu = Y.one("#menuBar");
    menu.plug(Y.Plugin.NodeMenuNav);
	
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
	                <a href="#" class="yui3-menuitem-content" style="padding-left: 5px; padding-right: 0px;">数据字段定义&nbsp;&nbsp;&gt;</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; border-right: 0px;">
	                <a href="#" class="yui3-menuitem-content" style="padding-left: 5px; padding-right: 0px;">删除</a>
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
	            	<a href="${rootPath}/config/datafield/gotoPage.html?OPER=UPDATE" class="yui3-menuitem-content">更新</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	                <a href="${rootPath}/config/datafield/gotoPage.html?OPER=SAVE" class="yui3-menuitem-content">创建</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	                <a href="${rootPath}/config/datafield/gotoPage.html?OPER=CHECK" class="yui3-menuitem-content">查看</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	                <a href="${rootPath}/config/datafield/gotoPage.html" class="yui3-menuitem-content">查询</a>
	            </li>
	         </ul>
		</div>
	</div>
	<div id="infoArea" class="ftinfo"></div>
	
		<table align="center">
			<tr style="font-weight: bold;">
				<td class="ftkeydatatdlabel"><font style="color: red">*</font>工厂：</td>
				<td class="ftkeydatatdinput">
					<%=(String)request.getSession().getAttribute("plant") == null ? "":(String)request.getSession().getAttribute("plant") %>
				</td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td class="ftkeydatatdlabel"><font style="color: red">*</font>字段名称:</td>
				<td class="ftkeydatatdinput">
					<input id="DATA_FIELD" name="DATA_FIELD" type="text" size="20" />
				</td>
				<td>
					<img id="showName" src="${rootPath}/image/search1.png" style="vertical-align: middle;" title="选择以浏览"/>
				</td>
			</tr>
		</table>
		<div id="tabView">
		    <ul>
		        <li><a href="#foo">主要</a></li>
		        <li id="listSet" style="display: none;"><a href="#bar">列表设定</a></li>
		    </ul>
		      <div>
		       <div id="foo" style="height: 400px;"> 
		        	 <table>
						<tr>
							<td class="ftkeydatatdlabel" >字段描述:</td>
							<td class="ftkeydatatdinput">
								<input id="DESCRIPTION" name="DESCRIPTION" type="text" size="20" />
							</td>
						</tr>
						<tr>
							<td class="ftkeydatatdlabel" >字段标识:</td>
							<td class="ftkeydatatdinput">
								<input id="DATA_TAG" name="DATA_TAG" type="text" size="20" />
							</td>
						</tr>
						<tr>
						<td class="ftkeydatatdlabel" >类型:</td>
							<td class="ftkeydatatdinput">
							     <select id="FIELD_TYPE" name="FIELD_TYPE">
									<option value="number">数值</option>
	                               	<option value="text">文本</option>
	                               	<option value="textarea">文本域</option>
	                               	<option value="date">日期</option>
	                               	<option value="list">列表</option>
	                               	<option value="boolean">布尔</option>
								</select>
								</td>
								
		                        <td><font style="color: red">*</font>0值<input id="value_0" disabled="disabled"/></td>
							    <td><font style="color: red">*</font>1值<input id="value_1" disabled="disabled"/></td>
								
								</tr>
								
						<tr><td class="ftkeydatatdlabel" >掩码:</td>
							<td class="ftkeydatatdinput">
									<input id="PT_MASK_GROUP_BO" name="PT_MASK_GROUP_BO" type="text" size="20" />
							</td>
							<td>
									<img id="showMark" src="${rootPath}/image/search1.png" style="vertical-align: middle;" title="选择以浏览"/>
							</td>
						</tr>
						<tr>
							<td class="ftkeydatatdlabel">单位:</td>
							<td  class="ftkeydatatdinput">
								<select id="FIELD_UNIT" >
								<option value="cm">厘米(cm)&nbsp;&nbsp;&nbsp;</option>
                                <option value="mm">毫米(dm)&nbsp;&nbsp;&nbsp;</option>
                                <option value="dm">分米(mm)&nbsp;&nbsp;&nbsp;</option>
                                <option value="m">米(m)&nbsp;&nbsp;&nbsp;&nbsp;</option>
                                <option value="g">克(g)&nbsp;&nbsp;&nbsp;&nbsp;</option>
                                <option value="kg">千克(kg)&nbsp;&nbsp;&nbsp;</option>
                                <option value="pcs">个(pcs)&nbsp;&nbsp;&nbsp;</option>
								</select>
							</td>
						</tr>
						
					</table>         
		        </div>
		        <div id="bar">
		        	<div id="paginator1" align="left">
		        	<a id="addRow">插入新项</a>
	        		<a id="removeRow">移除选定项</a>
	        		<a id="removeAllRow">全部移除</a>
		        	</div>
		            	<div id="datatable"></div>
		        </div>
		    </div>
		</div>
</div>
</body>
</html>