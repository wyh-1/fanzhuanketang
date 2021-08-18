<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师登录界面</title>
</head>
<script type="text/javascript">//script用于定义客户端脚本
function mycheck(){
	//判断用户名是否为空
	var name=document.getElementById("1");
	var key=document.getElementById("2");
	if(name.value==""){
		alert("用户名不能为空，请输入用户名！");
		return false;
	}
	//判断密码是否为空
	if(key.value==""){
		alert("密码不能为空，请输入密码！");
		return false;
	}
	return true;
}
</script>
<script type="text/javascript">
function jump1(){
	 window.location.href=request.getContextPath()+"/LoginRegister/loginpage.action?usertype=0";
	}
function jump2(){
	 window.location.href=request.getContextPath()+"/LoginRegister/loginpage.action?usertype=2";
	}
</script>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">
<img src="${pageContext.request.contextPath}/img/LoginRegister/1.jpg" width="100%" height="100%"/>
</div>
<center> 
<h2>教师登录</h2>
<form action="${pageContext.request.contextPath}/LoginRegister/teacherlogin.action" method="post">
<table border bordercolor="#0099FF" bgcolor='#CCFFFF'>
<tr>
<td width="40%">工号：</td>
<td><input type="text"  name="id" id="1"></td>
</tr>
<tr>
<td width="40%">密码：</td>
<td><input type="password"name="password" id="2"></td>
</tr>
<tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="登录" onclick="mycheck();">
<input type="reset" value="清空">
</td>
</tr>
</table>
</form>
<br>
<%
	String errorInfo = (String)request.getAttribute("errorInfo");
	if (errorInfo != null && errorInfo.equals("error id or password")) {
%>
<p>错误的用户名或密码!</p>
<%
	}
%>
<a href="${pageContext.request.contextPath}/LoginRegister/registerpage.action?usertype=1">新用户注册</a>
<br>
<br>
<div>
<form>
	<input type="radio" name="login" value="学生登录"onclick='javascript:jump1()'/>学生登录
	<input type="radio" name="login" value="教师登录" checked/>教师登录
	<input type="radio" name="login" value="管理员登录"onclick='javascript:jump2()'/>管理员登录
</form>
</div>
</center>
</body>
</html>