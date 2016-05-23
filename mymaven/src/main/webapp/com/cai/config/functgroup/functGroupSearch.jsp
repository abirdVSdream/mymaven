<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" deferredSyntaxAllowedAsLiteral="true"%>
    <%request.setAttribute("rootPath",request.getContextPath());%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;utf-8">
<title>功能组维护</title>
<link href="${pageContext.request.contextPath}/com/cai/frame/css/css.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/com/cai/frame/js/yui_3.18.1/yui/yui-min.js"></script>
<script src="${pageContext.request.contextPath}/com/cai/frame/js/yui-common.js"></script>
<script type="text/javascript">
var rootPath = '${rootPath}';
YUI().use('node', 'io', 'json-parse', 'json-stringify', 'imes-YuiCommon','node-menunav', function(Y){
	
	var common = Y.YuiCommon;//自定义common模块
	Y.on('io:failure', common.AjaxFailure);//调用Ajax失败方法
	//-------ajax请求数据---------
//	var show_info = Y.one('#infoArea'); 
	var formObj = Y.one('#form');
	var handleSuccess = function(ioId, o){ 
		if (o.responseText !== undefined) { 
			var s = o.responseText; 
			var data = Y.JSON.parse(s);
			var result = data.result;
			for(var j = 0;j < result.length;j++){
				result[j].id = j + 1;
			}
			table.set('data',[]);
			if(result.length > 0){
				table.set('data',result);//添加检索的数据
			}
		} 
	} 
	Y.on('io:success', handleSuccess); 
	var cfg = { 
		method: "POST",
		form : {
        	id : formObj,
            useDisabled: true
        }
	}; 
	var sUrl = "${rootPath}/cai/functgroup/searchFunctGroup.html"; 
	function makeRequest(){ 
		var request = Y.io(sUrl, cfg); 
	} 
	Y.on("click", makeRequest, "#selectData");//注册按钮点击事件 查询数据
	//-------ajax请求数据---------
	
	var toEmpty = function(){
		Y.one("#FUNCT_GROUP").set("value", "");
		Y.one("#DESCRIPTION").set("value", "");
		Y.one("#MEMO").set("value", "");
		table.set('data',[]);
		common.clearMessage();//调用清除消息方法
	}
	Y.on("click", toEmpty, "#toEmpty");//注册按钮点击事件 清空数据
	
	//注册弹出框
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
	
	//-------加载tabview-------
	var htmlStr = '<input id="selectData" type="button" value="查  询" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
					'<input id="toEmpty" type="button" value="清  空" />';
	//tabview 加载渲染完后的回调函数
	var _callBackFn =  function(){
	}
	common.initTabView(htmlStr, _callBackFn);

	var menu = Y.one("#menuBar");
	menu.plug(Y.Plugin.NodeMenuNav);
	//-------加载tabview-------
	
}); 

var table;//
YUI().use('datatable', 'datatable-paginator', 'datatype-number', 'node', function (Y) {	
	//-------加载table---------
	var data = [];
	table = new Y.DataTable({
		columns: [
	  	   // { key: 'HANDLE', label: '序列', width: '10%' },
		    { key: 'functGroup', label: '功能组', width: '20%' },
		    { key: 'description', label: '描述', width: '10%'},
		    { key: 'memo', label: '备注', width: '15%' },
		    { key: 'image', label: '链接路径', width: '10%' },
		    { key: 'handle', label: '明细',
		    	
		    	formatter: function(o){
		        	var funct_group = o.data.functGroup;
		        	var htmlStr = "";
		        	htmlStr = '<a href="${rootPath}/cai/functgroup/gotoPage.html?OPER=CHECK&FUNCT_GROUP=' + funct_group +  '">查看</a>&nbsp;&nbsp;&nbsp;'+
				     		   '<a href="${rootPath}/cai/functgroup/gotoPage.html?OPER=UPDATE&FUNCT_GROUP=' + funct_group + '">更新</a>&nbsp;&nbsp;&nbsp;'+
				     		   '<a href="${rootPath}/cai/functgroup/gotoPage.html?OPER=DELETE&FUNCT_GROUP=' + funct_group + '">删除</a>';
				    return htmlStr;				   
		        },
	        width: '15%',
	        allowHTML: true
	    }
	],
	data: data,
	rowsPerPage: 18, // 一页多少条数据
	width: '100%',
	height: '465px',
	sortable: true, //排序
	paginatorLocation: [Y.one('#paginator2')] //---分页组件
	});

	table.render('#datatable');
	//-------加载table---------
});

</script>
</head>
<body class="yui3-skin-sam">
<div id="functbox">
	<div id="menuBar" class="yui3-menu yui3-menu-horizontal yui3-menubuttonnav">
		<div class="yui3-menu-content" style="background-position-y: -1300px;">
	         <ul class="first-of-type">
	            <li class="yui3-menuitem" style="font-weight:bold; border-right: 0px;">
	            	<a href="#" class="yui3-menuitem-content" style="padding-left: 0px; padding-right: 0px;">系统管理&nbsp;&nbsp;&gt;</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; border-right: 0px;">
	                <a href="#" class="yui3-menuitem-content" style="padding-left: 5px; padding-right: 0px;">功能组维护&nbsp;&nbsp;&gt;</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; border-right: 0px;">
	                <a href="#" class="yui3-menuitem-content" style="padding-left: 5px; padding-right: 0px;">查询</a>
	            </li>
				<li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	            	<a href="#" class="yui3-menuitem-content">帮助</a>
	            </li>
	           	<li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	             	<a href="#" class="yui3-menuitem-content">导出</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	                <a href="${rootPath}/cai/functgroup/gotoPage.html?OPER=DELETE" class="yui3-menuitem-content">删除</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	             	<a href="#" class="yui3-menuitem-content">导入</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	            	<a href="${rootPath}/cai/functgroup/gotoPage.html?OPER=UPDATE" class="yui3-menuitem-content">更新</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	                <a href="${rootPath}/cai/functgroup/gotoPage.html?OPER=SAVE" class="yui3-menuitem-content">创建</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	                <a href="${rootPath}/cai/functgroup/gotoPage.html?OPER=CHECK" class="yui3-menuitem-content">查看</a>
	            </li>
	         </ul>
		</div>
	</div>
	
	<div id="infoArea" class="ftinfo"></div>
	<div id="tabView">
	    <ul>
	        <li><a href="#foo">基础属性</a></li>
	    </ul>
	    <div>
	        <div id="foo" style="height: 100%;">
	             <form id="form" method="post">
					<table>
						<tr>
							<td class="ftkeydatatdlabel">功能组:</td>
							<td>
							  <input id="FUNCT_GROUP" name="FUNCT_GROUP" type="text" size="25"/>	
							</td>
							<td>
								<img id="showGroup" src="${rootPath}/image/search1.png" style="vertical-align: middle;" title="选择以浏览"/>
			    			</td>
		    			</tr>
		    			<tr>
							<td class="ftkeydatatdlabel">描述:</td>
							<td>
								<input id="DESCRIPTION" name="DESCRIPTION" type="text" size="25"/>
							</td>
							<td class="ftkeydatatdlabel">备注:</td>
							<td>
								<input id="MEMO" name="MEMO" type="text" size="25"/>
							</td>
						</tr>
					</table>
				</form>
				<div id="paginator1" align="right"></div>
				<div id="datatable"></div>
				<div id="paginator2" align="right"></div>
	        </div>
	    </div>
	</div>
</div>
</body>
</html>