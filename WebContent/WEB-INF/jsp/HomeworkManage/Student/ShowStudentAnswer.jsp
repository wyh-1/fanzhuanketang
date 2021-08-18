<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作业互评</title>
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
</head>
<jsp:useBean id="database" scope="request" class="HomeworkManage.Teacher.ADD"/>
<body bgcolor="CCCFFF">
<%@include file="/html/student-header.html"%>
<div align="center">
<%
  String HomeworkID= request.getParameter("HomeworkID");
  ResultSet rs=database.select2(HomeworkID);
%>
<table  border="1" width="100%">  
<tr>    
<th>作业编号</th>      
<th>学生编号</th>    
<th>学生姓名</th>    
<th>创建日期</th>  
<th>类型</th>    
<th>题目</th>  
<th>回答</th>
<th>操作</th>
</tr> 
<% while(rs.next()) {%>    
 <tr>
  <td><%=rs.getString("HomeworkID")%></td>
     <td><%=rs.getString("StudentID")%></td>
      <td><%=rs.getString("Name")%></td>
     <td><%=rs.getString("CreateTime")%></td>
     <td><%=rs.getString("Type")%></td>
     <td><%=rs.getString("Title")%></td>
     <td><%=rs.getString("Text")%></td>
	 <td><a href="AnswerCM.jsp?AnswerID=<%=rs.getString("ID")%>">评价</a></td>
 </tr>
<%}%>  
</table>
</div>
</body>
</html>