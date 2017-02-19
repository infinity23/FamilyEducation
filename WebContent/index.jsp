<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body style="text-align: center ;background-size:cover; " background="${pageContext.request.contextPath}/img/bg4.jpg">
  <br><br><br><br><br><br>
  <i><h1><font color="green" size="200">家教信息平台</font></h1></i>
  <h4><font size="3" color="grey">${show_entrance}</font></h4>
  	<c:if test="${entrance==null}">
  	<a href="${pageContext.request.contextPath}/EntranceUIServlet?choose=teacher" target="">教师版</a>
  	<a href="${pageContext.request.contextPath}/EntranceUIServlet?choose=student" >学生版</a>
  	<a href="${pageContext.request.contextPath}/EntranceUIServlet?choose=admin" >管理员版</a>
  	</c:if>
	<c:if test="${entrance!=null && user==null}">
   	<a href="${pageContext.request.contextPath}/RegisterUIServlet" >注册</a>
   	<a href="${pageContext.request.contextPath}/LoginUIServlet" >登录</a>
   	<a href="${pageContext.request.contextPath}/QuitUIServlet">退出</a>
   	
   	</c:if>


	<c:if test="${user!=null}">
		<b>欢迎您，    ${user.name}</b>	<br>
		<br>
		<a href="${pageContext.request.contextPath}/PersonInfoUIServlet" >管理个人信息</a>
			<br>	<br>
		<c:if test="${entrance=='student'}">
			<a href="${pageContext.request.contextPath}/MakeApptUIServlet">预约教员</a>
			<br>	<br>
			<a href="${pageContext.request.contextPath}/MyApptUIServlet">我的预约</a>
			<br>	<br>
		</c:if>
		<c:if test="${entrance=='teacher'}">
			<a href="${pageContext.request.contextPath}/Tch_ApptUIServlet">我的预约</a>
				<br>		<br>	
		</c:if>
		<c:if test="${entrance=='admin'}">
			<a href="${pageContext.request.contextPath}/management.jsp">信息管理</a>
				<br>	<br>		
		</c:if>
			<a href="${pageContext.request.contextPath}/QuitUIServlet">退出</a>

	</c:if>
  </body>
</body>
</html>