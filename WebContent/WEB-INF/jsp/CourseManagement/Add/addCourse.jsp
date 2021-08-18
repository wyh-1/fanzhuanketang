<%@ page import="com.fanzhuanketang.po.Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>翻转课堂-教师-添加课程</title>
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
</head>
<body bgcolor="CCCFFF">
<%
	String userid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (userid == null || usertype == null || !usertype.equals(1)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
%>
	<%@include file="/html/teacher-header.html"%>
	<form action="/fanzhuanketang/CourseManagement/AddCourseServlet" method="post">
	<table border="3" cellspacing="0" cellpadding="0" bgcolor="#95BDFF" width="60%" align="center">
	<tr>
		<td>课程号</td>
		<td><input type="text" name="ID"/></td>
	</tr>
	<tr>
		<td>课程名称</td>
		<td><input type="text" name="Title"/></td>
	</tr>
	<tr>
		<td>上课时间</td>
		<td><input type="text" name="CourseDate"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit"value="确定" size="12">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset"value="清除" size="12">
		</td>
	</tr>
	</table>
	</form>
<% 
	} 
%>
</body>
</html>