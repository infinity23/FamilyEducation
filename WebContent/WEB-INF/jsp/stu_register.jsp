<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生注册页面</title>
</head>
<body>
	<body style="text-align: center;"background="${pageContext.request.contextPath}/img/bg5.jpg">
    <h1>用户注册</h1>
    <form action="${pageContext.request.contextPath}/StuRegisterServlet" method="post" >
	 <table width="50%" border="1" align="center">
    	<tr>
    		<td>用户名</td>
    		<td>
    			<input type="text" name="name" >
    		</td>
    	</tr>
    	
    	<tr>
    		<td>密码</td>
    		<td>
    			<input type="password" name="passwd">
    		</td>
    	</tr>
    	
  
    	
    	<tr>
    		<td>性别</td>
    		<td>
    			<input type="radio" name="gender" value="male">男
    			<input type="radio" name="gender" value="female">女    	
    		</td>
    	</tr>
    	
    	<tr>
    		<td>邮箱</td>
    		<td>
    			<input type="text" name="email" >
    		</td>
    	</tr>
    	
    	<tr>
    		<td>电话</td>
    		<td>
    			<input type="text" name="telephone">
    		</td>
    	</tr>
    	
    	<tr>
    		<td>备注</td>
    		<td>
    			<textarea rows="5" cols="50" name="description"></textarea>
    		</td>
    	</tr>
    	
    	<tr >
    		<td colspan="2">
 				<input type="submit" value="注册" >
 				<input type="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}'" >
 			</td>
 		</tr>
    </table>
     	
    </form>
    
   
</body>
</html>