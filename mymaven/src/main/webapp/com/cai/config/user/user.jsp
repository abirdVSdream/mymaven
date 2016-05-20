<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setAttribute("rootPath",request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
</head>
<body>

<h3 align="center">用户管理</h3>
<div align="center">
<form action="${rootPath}/user/user.html">
<input type="text" name="userid"/>
<input type="submit" value="查询用户"/>
</form>
</div>

<div align="center">
<table border="1" >
	<tr>
		<th>用户id</th>
		<th>用户名</th>
		<th>用户权限管理</th>
	</tr>
	<tr>
		<td align="center"><input type="text" value="${user.userid}" readonly="readonly"/></td>
		<td align="center"><input type="text" value="${user.username}" readonly="readonly"/></td>
		<td align="center"><a href="${rootPath}/config/user/permission.html?userid=${user.userid}">用户权限管理</a></td>
	</tr>
</table>
</div>
</body>
</html>