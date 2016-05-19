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
<div><p>${succ}</p></div>
<h3 align="center">用户权限管理</h3>
<div align="center">
	用户名：<input type="text" name="username" value="${user.username}" readonly="readonly"/>
		<input type="hidden" name="userid" value="${user.userid}" />
</div>
<div align="center">
	<input type="text"/><input type="submit" value="权限表"/>
</div>

<div align="center">
<form action="${rootPath}/update.html" method="post">
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
		<td align="left"><input type="checkbox" name="checkbox" value='${correlationuptList.correlationid}'/></td>
		<td align="center">
			<!-- <input type="text" value="${table.tablename}"/> -->
			<input type="text" name="tablename" value='${correlationuptList.table.tablename}'/>
		</td>
		<td align="center">
			<select name="selectadd" id="add">
				<c:if test='${correlationuptList.permission.add == "yes"}'>
					<option value="yes" selected="selected">有权限</option>
					<option value="no">无权限</option>
				</c:if>
				<c:if test='${correlationuptList.permission.add == "no"}'>
					<option value="yes" >有权限</option>
					<option value="no" selected="selected">无权限</option>
				</c:if>	
			</select>
		</td>
		<td align="center">
			<select name="selectdelete" id="delete">
			<c:if test='${correlationuptList.permission.delete == "yes"}'>
				<option value="yes" selected="selected">有权限</option>
				<option value="no">无权限</option>
			</c:if>
			<c:if test='${correlationuptList.permission.delete == "no"}'>
				<option value="yes" >有权限</option>
				<option value="no" selected="selected">无权限</option>
			</c:if>	
			</select>
		</td>
		<td align="center">
			<select name="selectupdate" id="update">
				<c:if test='${correlationuptList.permission.update == "yes"}'>
					<option value="yes" selected="selected">有权限</option>
					<option value="no">无权限</option>
				</c:if>
				<c:if test='${correlationuptList.permission.update == "no"}'>
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
				<c:if test='${correlationuptList.permission.export == "yes"}'>
					<option value="yes" selected="selected">有权限</option>
					<option value="no">无权限</option>
				</c:if>
				<c:if test='${correlationuptList.permission.export == "no"}'>
					<option value="yes" >有权限</option>
					<option value="no" selected="selected">无权限</option>
				</c:if>	
			</select>
		</td>
		<td align="center">
			<select name="selectcheck" id="check">
				<c:if test='${correlationuptList.permission.check == "yes"}'>
					<option value="yes" selected="selected">有权限</option>
					<option value="no">无权限</option>
				</c:if>
				<c:if test='${correlationuptList.permission.check == "no"}'>
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
    newNameTD.innerHTML = "<input type='checkbox' name='checkbox'/>";
    var newNameTD = newTR.insertCell(1);
    newNameTD.innerHTML = "<input name='tablename+"rows"+' id='tablename' type='text' />";
    var newNameTD = newTR.insertCell(2);
    newNameTD.innerHTML = "<select name='selectadd+"rows"+' id='add'><option>请选择</option><option value='yes' >有权限</option><option value='no'>无权限</option>";
    var newNameTD = newTR.insertCell(2);
    newNameTD.innerHTML = "<select name='selectdelete+"rows"+' id='delete'><option>请选择</option><option value='yes' >有权限</option><option value='no'>无权限</option>";
    var newNameTD = newTR.insertCell(2);
    newNameTD.innerHTML = "<select name='selectupdate+"rows"+' id='update'><option>请选择</option><option value='yes' >有权限</option><option value='no'>无权限</option>";
    var newNameTD = newTR.insertCell(2);
    newNameTD.innerHTML = "<select name='selectsearch+"rows"+' id='search'><option>请选择</option><option value='yes' >有权限</option><option value='no'>无权限</option>";
    var newNameTD = newTR.insertCell(2);
    newNameTD.innerHTML = "<select name='selectexport+"rows"+' id='export'><option>请选择</option><option value='yes' >有权限</option><option value='no'>无权限</option>";
    var newNameTD = newTR.insertCell(2);
    newNameTD.innerHTML = "<select name='selectcheck+"rows"+' id='check'><option>请选择</option><option value='yes' >有权限</option><option value='no'>无权限</option>";
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