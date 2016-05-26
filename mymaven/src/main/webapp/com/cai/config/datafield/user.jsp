<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%request.setAttribute("rootPath",request.getContextPath());%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/com/cai/frame/css/css.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/com/cai/frame/js/yui_3.18.1/yui/yui-min.js"></script>
<script src="${pageContext.request.contextPath}/com/cai/frame/js/yui-common.js"></script>
<script src="${pageContext.request.contextPath}/com/cai/frame/js/jquery-easyui-1.4.2/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/com/cai/frame/js/myjs.js"></script>


<style>
.custom-restricted-width {
    /* To limit the menu width to the content of the menu: */
    display: inline-block;
    /* Or set the width explicitly: */
    /* width: 10em; */
}




.base-cate-nav {
    position: absolute;
    top: 42px;
    width: 181px;
    border: 1px solid #e4e4e4;
    border-top: none;
    background-color: #fff
}

.base-cate-nav dt {
    position: relative;
    overflow: hidden;
    font-size: 13px;
    z-index: 1
}

.base-cate-nav dt a {
    position: relative;
    margin-left: -1px;
    display: block;
    border: 1px solid #fff;
    line-height: 26px;
    overflow: hidden;
    padding: 0;
    text-indent: 15px;
    text-overflow: ellipsis;
    white-space: nowrap;
    width: 181px;
    color: #333
}

.base-cate-nav .curr dt a,.base-cate-nav dt a:hover {
    margin-left: -1px;
    background-color: #fff;
    color: #c00
}

.base-cate-nav .curr dt a {
    border-color: #da6e72 #fff #da6e72 #da6e72
}

.base-cate-nav .curr dt {
    overflow: visible
}

.base-cate-nav .curr dd {
    display: block
}

.base-cate-nav dd {
    position: absolute;
    top: 0;
    left: 181px;
    border: 1px solid #da6e72;
    background-color: #fff;
    display: none;
    overflow: hidden;
    padding: 20px 25px
}

.base-cate-nav dd li {
    font-size: 12px;
    float: left;
    width: 33.3333%;
    line-height: 26px
}

.base-cate-nav .curr dd a {
    display: block;
    margin: 0 8px;
    padding: 0;
    overflow: hidden;
    border-bottom: 1px dashed #d8d8d8;
    text-overflow: ellipsis;
    white-space: nowrap;
    text-indent: 8px;
    color: #333
}

.base-cate-nav .curr dd a:hover {
    color: #c61b21;
    background-color: #fff
}

</style>
</head>


<script type="text/javascript">
var table;//
var HANDLE = "";
var rootPath = '${rootPath}';

YUI().use('node', 'io', 'json-parse', 'json-stringify', 'imes-YuiCommon','node-menunav', function(Y){
	
	var menu = Y.one("#menuBar");
    menu.plug(Y.Plugin.NodeMenuNav);
}); 


<script type="text/javascript">

var myTabs = new YAHOO.widget.TabView("demo");



    myTabs.addTab( new YAHOO.widget.Tab({

        label: 'Tab One Label',

        content: '<p>Tab One Content</p>',

        active: true

    }));



    myTabs.addTab( new YAHOO.widget.Tab({

        label: 'Tab Two Label',

        content: '<p>Tab Two Content</p>'

    }));



    myTabs.appendTo(document.body);

</script>
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
</div>


<div class="on J_base-cate-nav">
    <span class="pure-menu-heading">Yahoo Sites</span>

    <ul class="pure-menu-list">
        <li class="pure-menu-item"><a href="#" class="pure-menu-link">Flickr</a></li>
        <li class="pure-menu-item"><a href="#" class="pure-menu-link">Messenger</a></li>
        <li class="pure-menu-item"><a href="#" class="pure-menu-link">Sports</a></li>
        <li class="pure-menu-item"><a href="#" class="pure-menu-link">Finance</a></li>
        <li class="pure-menu-heading">More Sites</li>
        <li class="pure-menu-item"><a href="#" class="pure-menu-link">Games</a></li>
        <li class="pure-menu-item"><a href="#" class="pure-menu-link">News</a></li>
        <li class="pure-menu-item"><a href="#" class="pure-menu-link">OMG!</a></li>
    </ul>
</div>
</body>
</html>