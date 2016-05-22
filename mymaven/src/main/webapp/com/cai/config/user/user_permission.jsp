<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<% request.setAttribute("rootPath",request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户权限管理</title>
</head>
<body>
<!--<c:out value="${user.userid}"></c:out>-->
<div><p>${mess}</p></div>
<h3 align="center">用户权限管理</h3>
<div align="center">
	用户名：<input type="text" name="username" value="${user.username}" readonly="readonly"/>
</div>
<div align="center">
	<form action="${rootPath}/config/user/selectByTablename.html">
		<input name="tablenamefind" type="text"/>
		<input type="hidden" name="userid" value="${user.userid}"/>
		<input type="submit" value="权限表"/>
	</form>
</div>

<div align="center">
<form action="${rootPath}/config/user/update.html">
<table border="1" id="table">
	<tr>
	<th><input onclick="selectAll()" type="checkbox"   name="controlAll" style="controlAll" id="controlAll"/>是否修改 </th>
	<th>对应操作的表</th>
	<th>增加权限</th>
	<th>删除权限</th>
	<th>修改权限</th>
	<th>查找权限</th>
	<th>导出权限</th>
	<th>审核权限</th>
	<th><input type="submit" value="提交修改" ></th>
	</tr>
	<!-- 此处可遍历 List<CorrelationUPT>-->
	<c:forEach items="${correlationuptList}" var="correlationuptList" varStatus="co">
	<tr>
		<td align="left">
			<input type="checkbox" name="checkbox" value='${correlationuptList.correlationid}'/>
		 	<input type="hidden" name="permissionid" value='${correlationuptList.permissionid}'/>
		 	<input type="hidden" name="userid" value="${user.userid}"/>
		</td>
		<td align="center">
			<!-- <input type="text" value="${table.tablename}"/> -->
			<input type="text" name="tablename" value='${correlationuptList.table.tablename}' readonly="readonly"/>
			<input type="hidden" name="tableid" value='${correlationuptList.table.tableid}'/>
		</td>
		<td align="center">
			<select name="selectadd" id="add">
				<c:if test='${correlationuptList.permission.append == "yes"}'>
					<option value="yes" selected="selected">有权限</option>
					<option value="no">无权限</option>
				</c:if>
				<c:if test='${correlationuptList.permission.append == "no"}'>
					<option value="yes" >有权限</option>
					<option value="no" selected="selected">无权限</option>
				</c:if>	
			</select>
		</td>
		<td align="center">
			<select name="selectdelete" id="delete">
			<c:if test='${correlationuptList.permission.del == "yes"}'>
				<option value="yes" selected="selected">有权限</option>
				<option value="no">无权限</option>
			</c:if>
			<c:if test='${correlationuptList.permission.del == "no"}'>
				<option value="yes" >有权限</option>
				<option value="no" selected="selected">无权限</option>
			</c:if>	
			</select>
		</td>
		<td align="center">
			<select name="selectupdate" id="update">
				<c:if test='${correlationuptList.permission.upd == "yes"}'>
					<option value="yes" selected="selected">有权限</option>
					<option value="no">无权限</option>
				</c:if>
				<c:if test='${correlationuptList.permission.upd == "no"}'>
					<option value="yes" >有权限</option>
					<option value="no" selected="selected">无权限</option>
				</c:if>	
			</select>
		</td>
		<td align="center">
			<select name="selectsearch" id="search">
				<c:if test='${correlationuptList.permission.search == "yes"}'>
					<option value="yes" selected="selected">有权限</option>
					<option value="no">无权限</option>
				</c:if>
				<c:if test='${correlationuptList.permission.search == "no"}'>
					<option value="yes" >有权限</option>
					<option value="no" selected="selected">无权限</option>
				</c:if>	
			</select>
		</td>
		<td align="center">
			<select name="selectexport" id="export">
				<c:if test='${correlationuptList.permission.exp == "yes"}'>
					<option value="yes" selected="selected">有权限</option>
					<option value="no">无权限</option>
				</c:if>
				<c:if test='${correlationuptList.permission.exp == "no"}'>
					<option value="yes" >有权限</option>
					<option value="no" selected="selected">无权限</option>
				</c:if>	
			</select>
		</td>
		<td align="center">
			<select name="selectcheck" id="check">
				<c:if test='${correlationuptList.permission.che == "yes"}'>
					<option value="yes" selected="selected">有权限</option>
					<option value="no">无权限</option>
				</c:if>
				<c:if test='${correlationuptList.permission.che == "no"}'>
					<option value="yes" >有权限</option>
					<option value="no" selected="selected">无权限</option>
				</c:if>	
			</select>
		</td>
	</tr>
	</c:forEach>
</table>
</form>
</div>
<div align="center">
	<input type="submit" value="新增" onclick="addRow();"/>
	<input type="submit" value="删除" onclick="deletes();"/>
</div>
<script language="javascript" type="text/javascript">
function addRow() {
    var newTR = document.getElementById("table").insertRow(document.getElementById("table").rows.length);
    var rows = (document.getElementById("table").rows.length)+1;
    var newNameTD = newTR.insertCell(0);
    newNameTD.innerHTML = "<input type='checkbox' name='checkbox'/><input type='hidden' name='userid' value='${user.userid}'/><input type='hidden' name='index' value='index'/>";
    var newNameTD = newTR.insertCell(1);
    newNameTD.innerHTML = "<input name='newtablename' id='tablename' type='text' />";
    var newNameTD = newTR.insertCell(2);
    newNameTD.innerHTML = "<select name='newselectadd' id='add'><option>请选择</option><option value='yes' >有权限</option><option value='no'>无权限</option>";
    var newNameTD = newTR.insertCell(2);
    newNameTD.innerHTML = "<select name='newselectdelete' id='delete'><option>请选择</option><option value='yes' >有权限</option><option value='no'>无权限</option>";
    var newNameTD = newTR.insertCell(2);
    newNameTD.innerHTML = "<select name='newselectupdate' id='update'><option>请选择</option><option value='yes' >有权限</option><option value='no'>无权限</option>";
    var newNameTD = newTR.insertCell(2);
    newNameTD.innerHTML = "<select name='newselectsearch' id='search'><option>请选择</option><option value='yes' >有权限</option><option value='no'>无权限</option>";
    var newNameTD = newTR.insertCell(2);
    newNameTD.innerHTML = "<select name='newselectexport' id='export'><option>请选择</option><option value='yes' >有权限</option><option value='no'>无权限</option>";
    var newNameTD = newTR.insertCell(2);
    newNameTD.innerHTML = "<select name='newselectcheck' id='check'><option>请选择</option><option value='yes' >有权限</option><option value='no'>无权限</option>";
}

function selectAll(){
	 var checklist = document.getElementsByName ("checkbox");
	   if(document.getElementById("controlAll").checked)
	   {
	   for(var i=0;i<checklist.length;i++)
	   {
	      checklist[i].checked = 1;
	   } 
	 }else{
	  for(var j=0;j<checklist.length;j++)
	  {
	     checklist[j].checked = 0;
	  }
	 }
	}
	
function deletes()
{
   var ok=document.getElementsByName("checkbox");
   for(var k=0;k<ok.length;k++)
   {
     if(ok[k].checked==true)
     {
    	 table.deleteRow(k+1);
         k=k-1;
     }
   }
}

</script>
</body>
</html>