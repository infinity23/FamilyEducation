<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约信息</title>
</head>
<body>
	<body style="text-align: center;"background="${pageContext.request.contextPath}/img/bg5.jpg">
	<h1>预约信息</h1>
	 <form action="${pageContext.request.contextPath}/MakeApptServlet" method="post">
	 <table width="40%" border="1" align="center">
    	<tr>
    		<td>标题</td>
    		<td>
    			<input type="text" name="title" value="">
    		</td>
    	</tr>
    	
    	<tr>
    		<td>教师</td>
    		<td>
    			${teacher.name}
    		</td>
    	</tr>
    	
    	<tr>
    		<td>科目</td>
    		<td>
    			${teacher.subject}
    		</td>
    	</tr>
    	
    	<tr>
    		<td>备注</td>
    		<td>
    			<textarea rows="5" cols="50" name="description"></textarea>
    		</td>
    	</tr>
    
    	<tr>
    		<td colspan="2">
    			<input type="submit" value="确定">
    			<input type="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}'" align="middle">	
    		</td>
    	</tr>
    
    </table>
     	
    </form>
    
</body>
</html>