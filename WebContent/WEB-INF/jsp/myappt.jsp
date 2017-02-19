<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的预约</title>
</head>
<body >
	<body style="text-align: center;"background="${pageContext.request.contextPath}/img/bg5.jpg">
	<h1>我的预约</h1>
	<c:forEach var="e" items="${infos}" >
	<form action="${pageContext.request.contextPath}/MakeEvaluationServlet" method="post">
	<table border="1" width="60%" cellspacing=0 cellpadding=0 bordercolor=#000000 align="center" >
		<tr style='height:30px;'>
			<td width="80px">标题</td>
			<td>${e.value.title}</td>
		</tr>
		<tr style='height:30px;'>
			<td>科目</td>
			<td>${e.value.subject}</td>
		</tr>
		<tr style='height:30px;'>
			<td>教师</td>
			<td>${e.key}</td>
		</tr>
		<tr style='height:30px;'>
			<td>备注</td>
			<td>${e.value.description}</td>
		</tr>
		<tr style='height:30px;'>
			<td>状态</td>
			<td>${e.value.state}</td>
		</tr>
	
		<c:if test="${e.value.state=='已完成'&&e.value.eva_state=='未评价'}">
			<tr>
				<td>评价</td>
				<td>
					<textarea rows="5" cols="50" name="evaluation"></textarea>
				</td>
			</tr>
			<tr style='height:30px;'>
				<td colspan="2">
					<input type="submit" value="发布评价" >
				</td>
			</tr>
		</c:if>
	
		<c:if test="${e.value.eva_state=='已评价' }">
			<tr style='height:30px;'>
				<td>评价</td>
				<td>
					已评价
				</td>
			</tr>	
		</c:if>
		
	</table>
	<input type="hidden" name="subject" value="${e.value.subject}">
	<input type="hidden" name="tch_id" value="${e.value.tch_id}">
	<input type="hidden" name="tch_name" value="${e.key}">
	</form>
	<br><br>
</c:forEach>
		<input type="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}'" >
		</body>
</html>