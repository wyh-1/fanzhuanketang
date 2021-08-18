<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="all.css" type="text/css">
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
<script src="all.js"></script>
<title>抢答</title>
</head>
<body>
<%
	String userid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	String TestID = "";
	if (userid == null || usertype == null || !usertype.equals(0)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
     request.setCharacterEncoding("UTF-8");
     TestID= request.getParameter("ID");
	}
%>
<%@include file="/html/student-header.html"%>
<h2 align="center">请输入你的答案</h2>
<form name="form1" onSubmit="return check()" action="Stu_answer_do.jsp" method="post">
<table align="center" width="30%" border="1">
	<tr><th>答案：</th>
	<input type="hidden" name="TestID" value="<%=TestID %>">
		<td><input type="text" name="TestKey"></td></tr>
	<tr><th colspan="2">
	<input type="submit" value="submit">
	<input type="reset" value="reset"></th></tr>
</table>
</body>
</html>