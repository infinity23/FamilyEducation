<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="3;url=${pageContext.request.contextPath}/index.jsp"> 
<title>消息显示页面</title>
</head>
<body>
<body style="text-align: center;"background="${pageContext.request.contextPath}/img/bg5.jpg">

<br><br><br><h1>${message}</h1>
<br><br>
3秒之后将会跳转到首页...
</body>
</html>