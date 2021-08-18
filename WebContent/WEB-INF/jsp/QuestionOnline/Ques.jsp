<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>提问</title>
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
<style type="text/css">
.one{margin-left:10px;margin-top:30px;color:#FF8080;font-size:30px;}
.second{margin-left:300px;text-decoration: none;color:#3385FF;}
.third{text-align:right;}



</style>
<SCRIPT type="text/javascript" src="jquery.js"></SCRIPT>
<SCRIPT type="text/javascript">
function addArticle1() {
	 if (!$('#type').val()) {
	       alert('请输入问题类型');
	       return;
	     }
    if (!$('#title').val()) {
       alert('请输入标题');
       return;
    }
    if (!$('#content').val()) {
       alert('请输入问题内容');
       return;
    }
	addArticleForm.submit();
}
</SCRIPT>
</head>
<body bgcolor="#FFFFFF">
<%@include file="/html/student-header.html"%>
<%
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (usertype == null || !usertype.equals(0)) {
		response.sendRedirect("/fanzhuanketang/LoginRegister/stuLogin.jsp");
	} else {
%>
<form action="/fanzhuanketang/QuestionOnline/QuesServlet" method="post">
<div class="one">
<img src="images/tw.gif" width="100" height="33" />
</div>

<table>
<tr>
<td  bgcolor="#E4E4E4">问题类型：</td>
<td><input type="text"  name="type" id="type" size="65"></td>
</tr>
<tr>
<td  bgcolor="#E4E4E4">问题标题：</td>
<td><input type="text"  name="title" id="title" size="65"></td>
</tr>

<tr>
<td  valign="top" bgcolor="#E4E4E4">问题描述：</td>
<td><textarea name="content" id="content" rows="10" cols="50"></textarea></td>
</tr>

<tr>
 
<td colspan="3">

<input type="submit" value="提交问题" onclick="addArticle1()"/  size="30">
&nbsp;&nbsp;&nbsp;<input type="reset" value="清空" size="30">

</td>

</tr>


</table>

</form>
<%
	}
%>
</body>
</html>