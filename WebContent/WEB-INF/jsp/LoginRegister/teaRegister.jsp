<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师注册页面</title>
</head>
<body style="background: url(${pageContext.request.contextPath }/img/LoginRegister/2.png) no-repeat center top;">
<center>
<h2>教师注册</h2>  
<form method="post" action="${pageContext.request.contextPath }/LoginRegister/teacherregister.action">  
<table border bordercolor="#0099FF" bgcolor='#CCFFFF'> 
<tr>
<td width="40%">工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号: </td> 
<td><input type="text" name="id"></td> 
</tr> 
<tr>
<td width="40%">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>   
<td><input type="password" name="password"></td> 
</tr>
<tr><td width="40%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名: </td>    
<td><input type="text" name="name"></td>
</tr>
<tr><td width="40%">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别: </td>   
<td>&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="0">男&nbsp;&nbsp;&nbsp;    
<input type="radio" name="sex" value="1">女</td> 
</tr>
<tr><td width="40%">出生日期: </td>   
<td><input type="date" name="birthday"></td>
</tr>
<tr><td width="40%">院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校: </td>   
<td><input type="text" name="school"></td>
</tr> 
<tr><td width="40%">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</td>   
<td><input type="text" name="pro"></td>
</tr>
<tr><td width="40%">联系方式: </td>   
<td><input type="text" name="phonenum"></td>
</tr>
<tr>  
<td colspan="2" align="center">    
<input type="submit" value="注册">&nbsp;&nbsp;&nbsp;&nbsp;    
<input type="reset" value="清空"> </td>
</tr>
</table>
</form>
</center>
</body>
</html>