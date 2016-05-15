<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" deferredSyntaxAllowedAsLiteral="true"%>
    <%request.setAttribute("rootPath",request.getContextPath());%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;utf-8">
<title>数据字段定义</title>
<link href="${pageContext.request.contextPath}/com/cai/frame/css/css.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/com/cai/frame/js/yui_3.18.1/yui/yui-min.js"></script>
<script src="${pageContext.request.contextPath}/com/cai/frame/js/yui-common.js"></script>
<script type="text/javascript">
var table;//
var HANDLE = "";
var rootPath = '${rootPath}';

YUI().use('node', 'io', 'json-parse', 'json-stringify', 'imes-YuiCommon','node-menunav', function(Y){
	
	var common = Y.YuiCommon;//自定义common模块
	Y.on('io:failure', common.AjaxFailure);//调用Ajax失败方法
	//-------ajax请求数据---------
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
	var handleFailure = function(ioId, o){ 
	if (o.responseText !== undefined) { 
			show_info.set("innerHTML", "handleFailure"); 
		}	 
	} 
	Y.on('io:success', handleSuccess); 
	Y.on('io:failure', handleFailure); 
	var cfg = { 
		method: "POST",
		form : {
        	id : formObj,
            useDisabled: true
        }
	}; 
	var sUrl = "${rootPath}/config/datafield/searchDataField.html"; 
	function requestData(){ 
		var request = Y.io(sUrl, cfg); 
	} 
	Y.on("click", requestData, "#selectData");//注册按钮点击事件 查询数据
	//-------ajax请求数据---------
	
	var toEmpty = function(){
		Y.one('#DATA_FIELD').set("value", "");
		Y.one('#DESCRIPTION').set("value", "");
		Y.one('#DATA_TAG').set("value", "");
		Y.one('#MASK_GROUP').set("value", "");
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
	
	var htmlStr = '<input id="selectData" type="button" value="查  询" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
				'<input id="toEmpty" type="button" value="清  空" />' ;
	//tabview 加载渲染完后的回调函数
	var _callBackFn =  function(){
	}
	common.initTabView(htmlStr, _callBackFn);
	//-------加载tabview-------

	//-------加载menuBar---------
	var menu = Y.one("#menuBar");
    menu.plug(Y.Plugin.NodeMenuNav);
}); 

var table;//
YUI().use('datatable', 'datatable-paginator', 'datatype-number', 'node', function (Y) {	
	//-------加载table---------
	var data = [];
	table = new Y.DataTable({
		columns: [
	  	    //{ key: 'id', label: '序列', width: '10%' },
		    { key: 'sequence',  label: '字段编号',width: '10%' },
		    { key: 'dataField', label: '字段名称', width: '10%' },
		    { key: 'dataTag', label: '字段标识', width: '10%' },
		    { key: 'description', label: '字段描述', width: '15%' },
		    { key: 'fieldType', label: '类型', width: '10%' },
		    { key: 'ptMaskGroupBo', label: '掩码', width: '10%' },
		    { key: 'fieldUnit', label: '单位', width: '10%' },
		    { key: 'HANDLE', label: '操作',
		    	
		    	formatter: function(o){
		        	var datafield = o.data.dataField;
		        	var htmlStr = "";
		        	htmlStr = '<a href="${rootPath}/config/datafield/gotoPage.html?OPER=CHECK&DATA_FIELD=' + datafield +  '">查看</a>&nbsp;&nbsp;&nbsp;'+
				     		   '<a href="${rootPath}/config/datafield/gotoPage.html?OPER=UPDATE&DATA_FIELD=' + datafield +  '">更新</a>&nbsp;&nbsp;&nbsp;'+
				     		   '<a href="${rootPath}/config/datafield/gotoPage.html?OPER=DELETE&DATA_FIELD=' + datafield +  '">删除</a>';
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
	            	<a href="#" class="yui3-menuitem-content" style="padding-left: 0px; padding-right: 0px;">后台设置&nbsp;&nbsp;&gt;</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; border-right: 0px;">
	                <a href="#" class="yui3-menuitem-content" style="padding-left: 5px; padding-right: 0px;">数据字段定义&nbsp;&nbsp;&gt;</a>
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
	             	<a href="#" class="yui3-menuitem-content">导入</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	            	<a href="${rootPath}/config/datafield/gotoPage.html?OPER=DELETE" class="yui3-menuitem-content">删除</a>
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
						<tr style="font-weight: bold;">
								<td class="ftkeydatatdlabel"><font style="color: red">*</font>工厂：</td>
								<td class="ftkeydatatdinput">
									<%=(String)request.getSession().getAttribute("plant") == null ? "":(String)request.getSession().getAttribute("plant") %>
								</td>
								<td colspan="2"></td>
								<td colspan="2"></td>
						</tr>
						<tr>
							<td class="ftkeydatatdlabel">字段名称:</td>
							<td>
								<input id="DATA_FIELD" name="DATA_FIELD" type="text" size="20"/>
								<img id="showName" src="${rootPath}/image/search1.png" style="vertical-align: middle;" title="选择以浏览"/>
							</td>
							<td class="ftkeydatatdlabel">字段描述:</td>
							<td>
								<input id="DESCRIPTION" name="DESCRIPTION" type="text" size="20"/>
							</td>
							<td class="ftkeydatatdlabel">字段标识:</td>
							<td>
								<input id="DATA_TAG" name="DATA_TAG" type="text" size="20"/>
							</td>
						</tr>
						<tr>
							<td class="ftkeydatatdlabel">类型:</td>
							<td>
							     <select id="FIELD_TYPE" name="FIELD_TYPE" class="type">
									<option value="">请选择</option>
									<option value="int">数值</option>
                                	<option value="char">文本</option>
                                	<option value="boolean">文本域</option>
                                	<option value="float">日期</option>
                                	<option value="boolean">列表</option>
                                	<option value="float">布尔</option>
								</select>
							</td>
							<td class="ftkeydatatdlabel">掩码:</td>
							<td>
								<input id="MASK_GROUP" name="MASK_GROUP" type="text" size="20"/>
							</td>
							<td class="ftkeydatatdlabel">单位:</td>
							<td>
								<select name="unit" >
								<option value="">请选择&nbsp;&nbsp;&nbsp;&nbsp;</option>
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