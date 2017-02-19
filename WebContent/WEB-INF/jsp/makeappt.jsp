<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约教员</title>
</head>
<body>
<body style="text-align: center;"background="${pageContext.request.contextPath}/img/bg5.jpg">
<h1>教师一览表</h1>
	<table border="1" width="90%" cellspacing=0 cellpadding=0 bordercolor=#000000 align="center">
	<tr height="50">
			<td>姓名</td>
			<td>性别</td>
			<td>邮箱</td>
			<td>电话</td>
			<td>科目</td>
			<td colspan="5" abbr="text">个人说明</td>
			<td>
				查看评价
			</td>
			<td>
				预约
			</td>
		</tr>
	<c:forEach var="tch" items="${allTeachers}" >
		<tr height="30">
			<td>${tch.value.name}</td>
			<td>${tch.value.gender }</td>
			<td>${tch.value.email }</td>
			<td>${tch.value.telephone}</td>
			<td>${tch.value.subject }</td>
			<td colspan="5" abbr="text">${tch.value.description}</td>
			<td>
				<a href="${pageContext.request.contextPath}/EvaluationUIServlet?tch_id=${tch.value.id}">查看评价</a>
			</td>
			<td>
				<a href="${pageContext.request.contextPath}/MakeInfoUIServlet?tch_name=${tch.value.name}">预约</a>
			</td>
		</tr>
	</c:forEach>
	</table>
	<br><br>
	<input type="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}'" align="middle">	
	
</body>
</html>