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
	String userid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (userid == null || usertype == null || !usertype.equals(1)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
		String TeacherID=userid;
		ResultSet rs=database.select(TeacherID);
 %>
<%@include file="/html/teacher-header.html"%>
<table  border="1" width="100%">  
<tr>    
<th>作业编号</th>    
<th>标题</th>   
<th>截止日期</th>    
<th>类型</th>    
<th>文字内容</th>    
<th>发布日期</th>   
<th>发布教师工号</th>    
<th>所属课程编号</th>
<th>操作</th>  
</tr> 
<% while(rs.next()) {%>    
 <tr>
     <td><%=rs.getString("ID")%></td>
     <td><%=rs.getString("Title")%></td>
     <td><%=rs.getString("Overtime")%></td>
     <td><%=rs.getString("Type")%></td>
      <td><%=rs.getString("Text")%></td>
     <td><%=rs.getString("CreateTime")%></td>
     <td><%=rs.getString("TeacherID")%></td>
     <td><%=rs.getString("CourseID")%></td>
	<td><a href="selectanswer.jsp?ID=<%=rs.getString("ID")%>">查看学生答案</a></td>
 </tr>

<%
		}
	}
%>  
</table>  

</body>
</html>