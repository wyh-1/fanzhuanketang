<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="DB.*"%>
<%@page session="false"%>
<jsp:useBean id="check" class="DB.DBConnection"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加知识点结果</title>
</head>
<body>
<script type="text/javascript">
function turntoPage(){
	window.location.href = "display.jsp";
}
</script>
<%    
    request.setCharacterEncoding("utf-8");
	HttpSession session = request.getSession();
	String userid=(String)session.getAttribute("userid");
	Integer usertype=(Integer)session.getAttribute("usertype");
	if(userid==null||"".equals(userid)||(usertype!=0&&usertype!=1&&usertype!=2))
	{
%>
登陆失败，请重新登陆或注册。
<a href="#">登录</a>
<a href="#">注册</a>
<%
}
else{
    DBConnection.getConnection();
    DBConnection.insert_study(request.getParameter("PointNum"), request.getParameter("bookName"), request.getParameter("LearnPoint"));
%>
<script type="text/javascript">turntoPage()</script>
<%
}
%>
</body>
</html>