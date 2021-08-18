<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.fanzhuanketang.po.*, Database.*" %>
<%@ page import="java.util.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>回复列表</title>
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
<style type="text/css">
.box{text-decoration:none;}
</style>
</head>
<body>
<form action="AnsServlet" method="post"></form>
<%
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (usertype == null || !(usertype.equals(0) || usertype.equals(1))) {
		response.sendRedirect("/fanzhuanketang/LoginRegister/stuLogin.jsp");
	} else {
		if (usertype.equals(0)) {
%>
		<%@include file="/html/student-header.html"%>
<%
		} else if (usertype.equals(1)) {
%>
		<%@include file="/html/teacher-header.html"%>
		<center><a href="Answer.jsp?QuesID=<%=request.getParameter("QuesID")%>" class="box">解答</a></center>
<%
		}
		try{
			String QuesID = request.getParameter("QuesID");
			List<Ques> questions = DAOFactory.getQuesDaoInstance().findById(Integer.parseInt(QuesID));
			Iterator<Ques> iter =questions.iterator();
%>
<center>
 	<%
 	while(iter.hasNext()){
 	Ques ques=iter.next();
 	%>
 <TABLE  border='1' width="60%" bgcolor="white" cellspacing="0" cellpadding="0">
  <TR >
    <TD rowspan="2" align="center">标题：<%=ques.getTitle()%></TD>
    <TD colspan='1'>问题描述:<%=ques.getText()%></TD>
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
			List<Ans> all =DAOFactory.getAnsDaoInstance().findByQuesId(Integer.parseInt(QuesID));
			Iterator<Ans> iter2 =all.iterator();
%>
<center>
 	<%
 	while(iter2.hasNext()){
 	Ans ans=iter2.next();
 	%>
<TABLE  border='1' width="50%" bgcolor="white" cellspacing="0" cellpadding="0">
  <TR >
    <TD rowspan="2" align="center">老师工号：<%=ans.getTeacherID()%></TD>
  </TR>
  <TR >
    <TR>
    <TD rowspan='2' align="center"><img src="images/unface1.gif" width="60px"></TD>
    <TD colspan='1' height="100px">回复内容：<%=ans.getText()%></TD>
  </TR>
  <TR >
    <TD style="float:right"><%=ans.getTime()%></TD>
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


</body>
</html>