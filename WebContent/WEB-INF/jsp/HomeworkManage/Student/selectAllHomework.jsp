<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.fanzhuanketang.po.Homework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生作业任务信息查询页面</title>
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
</head>
<body bgcolor="CCCFFF">
<%@include file="/html/student-header.html"%>
  <center>
     <br><br><br>
     <table border="2" bgcolor="CCCEEE" width="600">
      <tr bgcolor="CCCCCC" align="center">
           <th>标题</th>
           <th>截止时间</th>
           <th>作业类型</th>
           <th>作业内容</th>
           <th>发布时间</th>
           <th>课程名</th> 
		   <th>解答</th>
		   <th>互评</th>
        </tr>
     <%
       List<Homework> al=(List<Homework>)session.getAttribute("al");
	   if (al != null ) {
		 for(int i=0;i<al.size();i++){
			 Homework st=al.get(i);
     %>
     <tr align="center">
           <td><%=st.getTitle()%></td>
           <td><%=st.getOverTime()%></td>
           <td><%=st.getType()%></td>
           <td><%=st.getText()%></td>
           <td><%=st.getCreateTime()%></td>
           <td><%=st.getCourseTitle()%></td>
		   <td><a href="StudentAnswer.jsp?HomeworkID=<%=st.getId()%>">写作业</a></td>
		   <td>
			<a href="ShowStudentAnswer.jsp?HomeworkID=<%=st.getId()%>">作业互评</a>
			<a href="/fanzhuanketang/HomeworkManage/Student/SelectAllCM?HomeworkID=<%=st.getId()%>">查看评价</a>
		   </td>
        </tr>
     <%
		}
	   }
     %>
     </table>
  </center>
</body>
</html>