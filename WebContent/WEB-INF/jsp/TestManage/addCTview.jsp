<%@ page language="java" import="java.sql.*,Database.*,java.util.*,com.fanzhuanketang.po.*,com.fanzhuanketang.dao.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增试题</title>
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
<link href="all.css" rel="stylesheet" />
<script src="all.js"></script>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String userid = (String)session.getAttribute("userid");
Integer usertype = (Integer)session.getAttribute("usertype");
if (userid == null || usertype == null || !usertype.equals(1)) {
	response.sendRedirect("/fanzhuanketang/index");
} else {
%>
	<%@include file="/html/teacher-header.html"%>
	<div id="div6">
	<h2 align="center">新增试题信息</h2>
	<form name="form1" onSubmit="return check()" action="addCT.jsp" method="post">
	<table align="center" width="30%" border="1">
		<tr><th>内容</th>
			<td><input type="text" name="Text"></td></tr>
		<tr><th>类型</th>
			<td>
			<select name="Type">
				<option value="JSP">JSP</option>
				<option value="数据库">数据库</option>
				<option value="JAVA语言">JAVA语言</option>
				<option value="操作系统">操作系统</option>
			</select>
			</td></tr>
		<tr><th>参考答案</th>
			<td><input type="text" name="TestKey"></td></tr>
		<tr><th>分值</th>
			<td><input type="text" name="Score"></td></tr>
		<tr><th>课程号</th>
			<td>
                <select name="CourseID">
				<%
                	CourseDao coursedao = DAOFactory.getCourseDAOInstance();
                	List<Course> courses = coursedao.selectAllCourseByUserID(usertype, userid);
                	for (Course course : courses) {
                	%>
                		<option value="<%=course.getID()%>"><%=course.getTitle()%></option>
                	<%
                	}
                %>
                </select>
			</td></tr>
		<tr><th colspan="2">
		<input type="submit" value="提交">
		<input type="reset" value="清空"></th></tr>
	</table>
	</form>
	</div>
<%
}
%>
</body>
</html>