<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理页面</title>
</head>
<body>
<body style="text-align: center;"background="${pageContext.request.contextPath}/img/bg5.jpg">
<h1>学员信息管理</h1>
<form action="${pageContext.request.contextPath}/ManagementUIServlet">
<table width="30%" border="1" align="center">
	<tr>
		<td>
			学员姓名：
		</td>
		<td>
			<input type="text" name="stu_name">
		</td>
	</tr>
	
	<tr>
		<td>
			教员姓名:
		</td>
		<td>
			<input type="text" name="tch_name">
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="submit" value="确定">
			<input type="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}'">
		</td>
	</tr>
</table>
</form>
</body>
</html>