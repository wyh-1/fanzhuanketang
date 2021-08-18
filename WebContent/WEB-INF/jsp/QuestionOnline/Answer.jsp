<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>回复</title>
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
<style>
.house{margin-left:350px;text-decoration:none;color:#3388FF;}
.house1{text-align:center; size:30px;}
.house2{margin-left:10px;}
</style>
</head>
<body bgcolor="white">
<%@include file="/html/teacher-header.html"%>
<center>
<img src="images/hd.gif" width="100" height="33" />

<form action="/fanzhuanketang/QuestionOnline/AnsServlet " method="post">
<input type="hidden" name="QuestionID" value="<%=request.getParameter("QuesID")%>">
<table>
<tr>
<td  valign="top" bgcolor="#D0D0FF">回复内容：</td>
<td><textarea name="content"  rows="10" cols="50" ></textarea></td>
</tr>

<tr>
 
<td colspan="3">

<input type="submit" value="提交"   size="30">
&nbsp;&nbsp;&nbsp;<input type="reset" value="清空" size="30">
</td>

</tr>


</table>

</form>
</center>
</body>
</html>