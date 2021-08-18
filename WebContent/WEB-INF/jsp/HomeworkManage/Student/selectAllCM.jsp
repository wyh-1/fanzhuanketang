<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, Database.*,com.fanzhuanketang.po.*"%>
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
           <th>评价学生</th>
           <th>评价时间</th>
           <th>评价内容</th>
        </tr>
     <%
       List<HwAnsComment> al=(List<HwAnsComment>)session.getAttribute("alCM");
	   if (al != null ) {
		 for(int i=0;i<al.size();i++){
			 HwAnsComment st=al.get(i);
     %>
     <tr align="center">
           <td><%=st.getStuID()%></td>
           <td><%=st.getCreateTime()%></td>
           <td><%=st.getComment()%></td>
        </tr>
     <%
		}
	   }
     %>
     </table>
  </center>
</body>
</html>