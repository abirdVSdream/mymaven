<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户权限管理</title>
</head>
<body>
<h3 align="center">用户权限管理</h3>


<div align="center">
	用户名：<input type="text" readonly="readonly"/>
</div>
<div align="center">
	<input type="text"/><input type="submit" value="权限表"/>
</div>

<div align="center">
<table border="1" id="table">
	<tr>
	<th>是否修改权限</th>
	<th>对应操作的表</th>
	<th>增加权限</th>
	<th>删除权限</th>
	<th>修改权限</th>
	<th>查找权限</th>
	<th>导出数据权限</th>
	<th>审核权限</th>
	</tr>
	<!-- 此处可遍历 List<CorrelationUPT>-->
	<c:forEach items="${lismap}" var="lismap" varStatus="co">
	<tr>
		<td align="center"><input type="checkbox" value='${lismap.("correlationuptList"+co).correlationid}'/></td>
		<td align="center">
			<!-- <input type="text" value="${table.tablename}"/> -->
			<input type="text" value='${lismap.("table"+co).tablename}'/>
		</td>
		<td align="center">
			<select value="${lismap.permission.add}">
				<option>请选择</option>
				<option value="yes">有权限</option>
				<option value="no">无权限</option>
			</select>
		</td>
		<td align="center">
			<select value="${permissionArray[co+1].delete}">
				<option>请选择</option>
				<option value="yes">有权限</option>
				<option value="no">无权限</option>
			</select>
		</td>
		<td align="center">
			<select value="${permissionArray[co+1].update}">
				<option>请选择</option>
				<option value="yes">有权限</option>
				<option value="no">无权限</option>
			</select>
		</td>
		<td align="center">
			<select value="${permissionArray[co+1].search}">
				<option>请选择</option>
				<option value="yes">有权限</option>
				<option value="no">无权限</option>
			</select>
		</td>
		<td align="center">
			<select value="${permissionArray[co+1].export}">
				<option>请选择</option>
				<option value="yes">有权限</option>
				<option value="no">无权限</option>
			</select>
		</td>
		<td align="center">
			<select value="${permissionArray[co+1].check}">
				<option>请选择</option>
				<option value="yes">有权限</option>
				<option value="no">无权限</option>
			</select>
		</td>
	</tr>
	</c:forEach>
</table>
</div>

<div align="center">
	<input type="submit" value="新增"/>
	<input type="submit" value="删除">
	<input type="submit" value="提交修改">
</div>
</body>
</html>