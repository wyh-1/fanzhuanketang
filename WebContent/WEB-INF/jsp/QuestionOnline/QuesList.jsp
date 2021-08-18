<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="Database.*,com.fanzhuanketang.po.*,com.fanzhuanketang.dao.*" %>
<%@ page import="java.util.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问题列表</title>
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
<style type="text/css">
.box{text-decoration:none;}
</style>
</head>
<body>

<%
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (usertype == null || !(usertype.equals(0) || usertype.equals(1))) {
		response.sendRedirect("/fanzhuanketang/LoginRegister/stuLogin.jsp");
	} else {
		if (usertype.equals(0)) {
%>
			<%@include file="/html/student-header.html"%>
			<center><a href="Ques.jsp" class="box">我要提问</a></center>
<%
		} else if (usertype.equals(1)) {
%>
			<%@include file="/html/teacher-header.html"%>
<%
		}
		try{
			List<Ques> all =DAOFactory.getQuesDaoInstance().findAll();
			Iterator<Ques> iter =all.iterator();	
%>
<center>
 	<%
 	while(iter.hasNext()){
 	Ques ques=iter.next();
 	%>
 <TABLE  border='1' width="60%" bgcolor="white" cellspacing="0" cellpadding="0">
  <TR >
    <TD rowspan="2" align="center"><a href="AnsList.jsp?QuesID=<%=ques.getId()%>" class="box"><%=ques.getTitle()%></TD>
    <TD colspan='1'>类型:<%=ques.getType()%></TD>
  </TR>
  <TR>
    <TD style="float:right"><%=ques.getTime()%></TD>
    </TR>
    </TABLE>
 	<% 
 	}
 	%>

 </center>
 	<% 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
 	%>
</body>
</html>