<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看评价</title>
</head>
<body>
	<body style="text-align: center;"background="${pageContext.request.contextPath}/img/bg5.jpg">
	<h1>所有评价</h1>
	<table border="1" width="80%" cellspacing=0 cellpadding=0 bordercolor=#000000 align="center">
			<tr height="50">
			<td>科目</td>
			<td>评价</td>
			<td>学员</td>
		</tr>
	<c:forEach var="e" items="${evaluations}" >
		<tr height="50">
			<td>${e.value.subject}</td>
			<td>${e.value.description }</td>
			<td>${e.value.stu_name}</td>
		</tr>
	</c:forEach>
	<tr height="30">
		<td colspan="3">
			<input type="button" value="确定" onclick="window.location.href='${pageContext.request.contextPath}/MakeApptUIServlet'">
		</td>
	</tr>
	</table>
</body>
</html>