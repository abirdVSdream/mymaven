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
var FUNCTGROUP_RESULT = '${FUNCTGROUP_RESULT}';
var functGroupMemberList = [];
var functGroupNotInList = [];
var functMemberList = [];
var functUnAssignedList = [];
//没实现
YUI().use('node', 'io', 'json-parse', 'json-stringify','event', 'imes-YuiCommon', 'node-menunav', function(Y){
	var common = Y.YuiCommon;//自定义common模块
	Y.on('io:failure', common.AjaxFailure);//调用Ajax失败方法
	
	//-------ajax请求数据---------
	
	var selectData = function(){
		common.clearMessage();//调用清除消息方法
		functGroupMemberList = [];
		functGroupNotInList = [];
		functMemberList = [];
		functUnAssignedList = [];
		
		var funct_group = Y.one("#FUNCT_GROUP").get("value");
		if(funct_group == ""){
			common.setMessage("N", "请输入功能组进行检索");
			return;
		}
		var data = {};
		data.FUNCT_GROUP = funct_group;
		var dataStr = Y.JSON.stringify(data);
		var request = Y.io("${rootPath}/cai/functgroup/checkFunctGroup.html", { 
			method: "POST", 
			data: "DATA=" + dataStr,
			on: {
				success: function(ioId, o){ 
					if (o.responseText !== undefined && o.responseText != "") { 
						var s = o.responseText; 
						var data = Y.JSON.parse(s);
						if(data.result != null){
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
		var result = _data.result;
		Y.one("#FUNCT_GROUP").set("value", result.FUNCT_GROUP);
		Y.one("#GROUP_NAME").set("value", result.GROUP_NAME);
			/** var html = "";
			if(result.functGroupMemberList != null)
			{
				for(var i = 0;i < result.functGroupMemberList.length;i++)
				{
					var group_name = result.functGroupMemberList[i].GROUP_NAME;//描述
					var funct_group = result.functGroupMemberList[i].FUNCT_GROUP; //value
					functGroupMemberList[i] = funct_group + "," + group_name;
					html = html + "<option value='" + funct_group + "' >" + group_name +"</option>";
				}
				Y.one("#functGroup" ).set("innerHTML", html);
			} */
			
			var html = "";
			if(result.functGroupMemberList != null)
			{
				for(var i = 0;i < result.functGroupMemberList.length;i++)
				{
					var cmFunctGroupBo = result.functGroupMemberList[i].cmFunctGroupBo;//描述
					functGroupMemberList[i] = funct_group + "," + group_name;
					html = html + "<option value='" + cmFunctGroupBo + "' >" + cmFunctGroupBo +"</option>";
				}
				Y.one("#functGroup" ).set("innerHTML", html);
			}
			
			/** var html2="";
			if(result.functGroupNotInList != null)
			{
				for(var i = 0;i < result.functGroupNotInList.length;i++)
				{
					var group_name = result.functGroupNotInList[i].GROUP_NAME;//描述
					var funct_group = result.functGroupNotInList[i].FUNCT_GROUP; //value
					functGroupNotInList[i] = funct_group + "," + group_name;
					html2 = html2 + "<option value='" + funct_group + "' >" + group_name +"</option>";
				}
				Y.one("#functGroupNotIn" ).set("innerHTML", html2);
			}
			*/
			var html2="";
			if(result.functGroupNotInList != null)
			{
				for(var i = 0;i < result.functGroupNotInList.length;i++)
				{
					var description = result.functGroupNotInList[i].description;//描述
					var functGroup = result.functGroupNotInList[i].functGroup; //value
					functGroupNotInList[i] = funct_group + "," + group_name;
					html2 = html2 + "<option value='" + functGroup + "' >" + description +"</option>";
				}
				Y.one("#functGroupNotIn" ).set("innerHTML", html2);
			}
			
			
			/** var html3 = "";
			if(result.functMemberList != null)
			{
				for(var i = 0;i < result.functMemberList.length;i++)
				{
					var funct_name = result.functMemberList[i].FUNCT_NAME;//描述
					var funct = result.functMemberList[i].FUNCT; //value
					functMemberList[i] = funct + "," + funct_name ;
					html3 = html3 + "<option value='" + funct + "' >" + funct_name+"</option>";
				}
				Y.one("#funct" ).set("innerHTML", html3);
			}*/
			var html3 = "";
			if(result.functGroupMemberList != null)
			{
				for(var i = 0;i < result.functGroupMemberList.length;i++)
				{
				
					functGroupMemberList[i] = funct_group + "," + group_name;
					html3 = html3 + "<option value='" + cmFunctBo + "' >" + cmFunctBo +"</option>";
				}
				Y.one("#functGroup" ).set("innerHTML", html);
			}
			
			/** var html4="";
			if(result.functUnAssignedList != null)
			{
				for(var i = 0;i < result.functUnAssignedList.length;i++)
				{
					var funct_name = result.functUnAssignedList[i].FUNCT_NAME;//描述
					var funct = result.functUnAssignedList[i].FUNCT; //value
					functUnAssignedList[i] = funct + "," +funct_name;
					html4 = html4 + "<option value='" + funct + "' >" + funct_name+"</option>";
				}
				Y.one("#functUnAssigned" ).set("innerHTML", html4);
			}
			*/
			var html4="";
			
			if(result.functUnAssignedList != null)
			{
				for(var i = 0;i < result.functUnAssignedList.length;i++)
				{
					var description = result.functUnAssignedList[i].description;//描述
					var funct = result.functUnAssignedList[i].funct; //value
					functUnAssignedList[i] = funct + "," +funct_name;
					html4 = html4 + "<option value='" + funct + "' >" + description+"</option>";
				}
				Y.one("#functUnAssigned" ).set("innerHTML", html4);
			}
			
	}
	
	var toRight = function moveSelected()
	{
		
		 var test1 = Y.one("#functGroupNotIn").get("value");
		 var test2 = Y.one("#functUnAssigned").get("value");
		 var html="";
		 if(test1 != "")
		 {
			 	 for(var j = 0;j < functGroupMemberList.length;j++)
				 {
				 	var num = [];
					num = functGroupMemberList[j].split(",");
					html = html + "<option value='" + num[0] + "' >" + num[1]+"</option>";
				 }
			     for(var i=0;i<functGroupNotInList.length; i++)  
			     {  
			    	var num1 = [];
					num1 = functGroupNotInList[i].split(",");
					if(test1 == num1[0])  
			        {  
						html = html + "<option value='" + test1 + "'>" + num1[1] +"</option>";
						functGroupMemberList[functGroupMemberList.length] = functGroupNotInList[i];
						functGroupNotInList.splice(i,1);
			         }  
			     }  
   				 Y.one("#functGroup" ).set("innerHTML", html);
			     var html2="";
			     for(var i = 0;i < functGroupNotInList.length;i++)
				 {
			    	  var num2 = [];
					  num2 = functGroupNotInList[i].split(",");
					  html2 = html2 + "<option value='" + num2[0] + "' >" + num2[1]+"</option>";
			     }
				 Y.one("#functGroupNotIn" ).set("innerHTML", html2);
		}else if(test2 != "")
		 {
			 	 for(var j = 0;j < functMemberList.length;j++)
				 {
		        	//alert(functRoleList[j]);
				 	var num = [];
					num = functMemberList[j].split(",");
					html = html + "<option value='" + num[0] + "' >" + num[1]+"</option>";
				 }
			     for(var i=0; i<functUnAssignedList.length; i++)  
			     {  
			    	var num1 = [];
					num1 = functUnAssignedList[i].split(",");
					if(test2 == num1[0])  
			        {  
						html = html + "<option value='" + test2 + "'>" + num1[1] +"</option>";
						functMemberList[functMemberList.length] = functUnAssignedList[i];
						functUnAssignedList.splice(i,1);
			         }  
			      }  
   				  Y.one("#funct" ).set("innerHTML", html);
			      var html2="";
			      for(var i = 0;i < functUnAssignedList.length;i++)
				  {
			    	  var num2 = [];
					  num2 = functUnAssignedList[i].split(",");
					  html2 = html2 + "<option value='" + num2[0] + "' >" + num2[1]+"</option>";
			  }
					Y.one("#functUnAssigned" ).set("innerHTML", html2);
		}
		 
	  }
	  Y.on("click", toRight, "#toRight");
	  
	var toLeft = function moveSelected()
	{
		 var test3 = Y.one("#functGroup").get("value");
		 var test4 = Y.one("#funct").get("value");
		 var html="";
		 if(test3 != "")
		 {
			 for(var j = 0;j < functGroupNotInList.length;j++)
			 {
			 	var num = [];
				num = functGroupNotInList[j].split(",");
				html = html + "<option value='" + num[0] + "' >" + num[1]+"</option>";
			 }
		     for(var i=0; i<functGroupMemberList.length; i++)  
		     {  
		    	var num1 = [];
				num1 = functGroupMemberList[i].split(",");
				if(test3 == num1[0])  
		        {  
					html = html + "<option value='" + test3 + "'>" + num1[1] +"</option>";
					functGroupNotInList[functGroupNotInList.length] = functGroupMemberList[i];
					functGroupMemberList.splice(i,1);
		         }  
		      }  
			  Y.one("#functGroupNotIn" ).set("innerHTML", html);
		      var html2="";
		      for(var i = 0;i < functGroupMemberList.length;i++)
			  {
		    	  var num2 = [];
				  num2 = functGroupMemberList[i].split(",");
				  html2 = html2 + "<option value='" + num2[0] + "' >" + num2[1]+"</option>";
		  	  }
			  Y.one("#functGroup" ).set("innerHTML", html2);
		 }else if(test4 != "")
			{
				 for(var j = 0;j < functUnAssignedList.length;j++)
				 {
				 	var num = [];
					num = functUnAssignedList[j].split(",");
					html = html + "<option value='" + num[0] + "' >" + num[1]+"</option>";
				 }
			    for(var i=0; i<functMemberList.length; i++)  
			    {  
				   	var num1 = [];
					num1 = functMemberList[i].split(",");
					if(test4 == num1[0])  
			        {  
						html = html + "<option value='" + test4 + "'>" + num1[1] +"</option>";
						functUnAssignedList[functUnAssignedList.length] = functMemberList[i];
						functMemberList.splice(i,1);
			        }  
			    }  
				Y.one("#functUnAssigned" ).set("innerHTML", html);
			    	var html2="";
			    for(var i = 0;i < functMemberList.length;i++)
				{
				   	 var num2 = [];
					 num2 = functMemberList[i].split(",");
					 html2 = html2 + "<option value='" + num2[0] + "' >" + num2[1]+"</option>";
			 	}
				Y.one("#funct" ).set("innerHTML", html2);
			}
	}
	Y.on("click", toLeft, "#toLeft");
	
	//搜索 可选功能或者功能组
	var findg = function(){
		var temp1 = Y.one("#findGroup").get("value");
		var html5 = "";
			for(var i = 0;i < functGroupNotInList.length;i++)
			{
				if(functGroupNotInList[i].indexOf(temp1) > -1)
				{
					var num1 = [];
					num1 = functGroupNotInList[i].split(",");
					html5 = html5 + "<option value='" + num1[0] + "' >" + num1[1]+"</option>";
				}
			}
			Y.one("#functGroupNotIn" ).set("innerHTML", html5);
	}
	Y.on("click", findg, "#findg");//注册按钮点击事件 清空数据
	
	var findf = function(){
		var temp2 = Y.one("#findFunct").get("value");
		var html5 = "";
		for(var i = 0;i < functUnAssignedList.length;i++)
		{
			if(functUnAssignedList[i].indexOf(temp2) > -1)
			{
				var num2 = [];
				num2 = functUnAssignedList[i].split(",");
				html5 = html5 + "<option value='" + num2[0] + "' >" + num2[1] +"</option>";
			}
		}
		Y.one("#functUnAssigned" ).set("innerHTML", html5);
		
	}
	Y.on("click", findf, "#findf");//注册按钮点击事件 清空数据
	
	
	var toEmpty = function(){
		common.clearMessage();//调用清除消息方法
		Y.one('#FUNCT_GROUP').set("value", "");
		Y.one("#GROUP_NAME").set("value", "");
		Y.one("#functGroup" ).set("innerHTML", "");
		Y.one("#functGroupNotIn" ).set("innerHTML", "");
		Y.one("#funct" ).set("innerHTML", "");
		Y.one("#functUnAssigned" ).set("innerHTML", "");
	}
	Y.on("click", toEmpty, "#toEmpty");//注册按钮点击事件 清空数据

	//注册弹出框
	var showGroup = function(){
		var funct_group = Y.one("#FUNCT_GROUP").get("value");
		var searchData = {};
		searchData.funct_group = funct_group;
		var paramStr = Y.JSON.stringify(searchData);
		var ret = common.showDialog(paramStr, "funct_group");
    	if(typeof(ret) != "undefined"){ 
    		var returnData = Y.JSON.parse(ret);
    		Y.one("#FUNCT_GROUP").set("value", returnData.funct_group);
    		Y.one("#GROUP_NAME").set("value", returnData.group_name);
    	}
	}
	Y.on("click", showGroup, "#showGroup");
	
	
	//-------加载tabview-------
	var htmlStr = '<input id="selectData" type="button" value="检 索" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
					'<input id="toEmpty" type="button" value="清  空" />';
	//tabview 加载渲染完后的回调函数
	var _callBackFn =  function(){
	}
	common.initTabView(htmlStr, _callBackFn);
	
	if(FUNCTGROUP_RESULT != "")
	{
		_setData(FUNCTGROUP_RESULT);
	}	

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
	                <a href="#" class="yui3-menuitem-content" style="padding-left: 5px; padding-right: 0px;">功能组维护&nbsp;&nbsp;&gt;</a>
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
	            	<a href="${rootPath}/cai/functgroup/gotoPage.html?OPER=DELETE" class="yui3-menuitem-content">删除</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	                <a href="${rootPath}/cai/functgroup/gotoPage.html?OPER=UPDATE" class="yui3-menuitem-content">更新</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	                <a href="${rootPath}/cai/functgroup/gotoPage.html?OPER=SAVE" class="yui3-menuitem-content">创建</a>
	            </li>
	            <li class="yui3-menuitem" style="font-weight:bold; float: right; border-right: 0px;">
	                <a href="${rootPath}/cai/functgroup/gotoPage.html?OPER=SEARCH" class="yui3-menuitem-content">查询</a>
	            </li>
	         </ul>
		</div>
	</div>

	<div id="infoArea" class="ftinfo"></div>
			<table align="center">	
				<tr>
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
		        <li><a href="#foo">功能组</a></li>
		        <li id="listSet"><a href="#bar">功能</a></li>
		    </ul>
      	<div>
      		<div id="foo" style="height: 400px;"> 
        	 	<div>
		       	 	<table align="center">
			       	 	<tr>
			       	 		<td>功能组描述：</td>
							<td>
							  <input id="GROUP_NAME" name="GROUP_NAME" type="text" size="15"/>	
							</td>
						<tr>
					</table>
				</div>
				<div>
        	 	<table align="center">
					<tr>
						<td colspan="2">可选功能组：
						    <input id = "findGroup" size="15"  />
						    <input id="findg" type="button" size="10" name="find" value="搜索"/>
						</td> 
						<td>已选功能组：</td>
					</tr>
					<tr>
					    <td rowspan="7">
                            <select  id="functGroupNotIn" size="19"  multiple style="width:250px; "></select>
                        </td>
						<td >
						<input  id="toRight"  name ="toRight" type="button" size="4" value="&nbsp;&nbsp;>&nbsp;" />
						</td>
						<td rowspan="7">
                            <select   size="19" id="functGroup" multiple style="width:250px; "></select>
                        </td>
					</tr>
					<tr>
						<td >
							<input  id="toLeft" name="toleft" type="button" size="4" value="&nbsp;&nbsp;<&nbsp;" />
						</td>
					</tr>
					<tr>
						<td >
							<input name="TEMPLATE" type="button" size="3" value="&nbsp;>>&nbsp;" />
						</td>
					</tr>
					<tr>
						<td >
							<input  name="TEMPLATE" type="button" size="3" value="&nbsp;<<&nbsp;" />
						</td>
					</tr>
					<tr>
					    <td rowspan="3">&nbsp;</td>
					</tr>
			    </table> 
			    </div>          
        	</div>
        	<div id="bar" style="height: 100%;">
	           <table align="center">
					<tr>
						<td colspan="2">可选功能：
						    <input id = "findFunct" size="15"  />
						    <input id="findf" type="button" size="10"  value="搜索"/>
						</td> 
						<td>已选功能：</td>
					</tr>
					<tr>
					    <td rowspan="7">
                            <select  id="functUnAssigned" size="20"  multiple style="width:250px; "></select>
                        </td>
						<td >
						<input  id="toRight"  name ="toRight" type="button" size="4" value="&nbsp;&nbsp;>&nbsp;" />
						</td>
						<td rowspan="7">
                            <select   size="20" id="funct" multiple style="width:250px; "></select>
                        </td>
					</tr>
					<tr>
						<td >
							<input  id="toLeft" name="toleft" type="button" size="4" value="&nbsp;&nbsp;<&nbsp;" />
						</td>
					</tr>
					<tr>
						<td >
							<input name="TEMPLATE" type="button" size="3" value="&nbsp;>>&nbsp;" />
						</td>
					</tr>
					<tr>
						<td >
							<input  name="TEMPLATE" type="button" size="3" value="&nbsp;<<&nbsp;" />
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