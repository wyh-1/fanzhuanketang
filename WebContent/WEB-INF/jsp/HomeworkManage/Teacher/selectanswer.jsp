<%@ page import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询客户数据处理页面</title>
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
</head>
<jsp:useBean id="database" scope="request" class="HomeworkManage.Teacher.ADD"/>
<body>
<%
request.setCharacterEncoding("utf-8");
String HomeworkID=request.getParameter("ID");
ResultSet rs=database.select2(HomeworkID);
 %>
<%@include file="/html/teacher-header.html"%>
<table  border="1" width="100%">  
<tr>    
<th>作业编号</th>      
<th>学生编号</th>    
<th>学生姓名</th>    
<th>创建日期</th>  
<th>类型</th>    
<th>题目</th>  
<th>作业内容</th>
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
 </tr>
<%}%>  
</table>  
</body>
</html>