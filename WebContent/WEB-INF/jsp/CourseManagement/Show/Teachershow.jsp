<%@ page import="java.util.List,Database.*,com.fanzhuanketang.po.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看课程</title>
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
</head>
<body bgcolor="CCCFFF">

<%@include file="/html/teacher-header.html"%>
	<table border="0" cellspacing="0" cellpadding="0" bgcolor="#95BDFF" width="60%" align="center">
		
		<thead>
<tr style="background-color: #FFFFE8" height=20px>
						<th class="biao" >课程号</th>
						<th class="biao">课程名称</th>
						<th class="biao">上课时间</th>
						<th class="biao">修改</th>
						<th class="biao">删除</th>
</tr>
			</thead>
		<%
		List list = (List)session.getAttribute("Courselist");
		for(int i=0;i<list.size();i++){
			Course mm=(Course)list.get(i);
		%>
		<tbody>
					<tr style="background-color: #FFFFE8" height=20px>
						<th ><%=mm.getID() %></th>
						<th><%=mm.getTitle() %></th>
						<th><%=mm.getCourseDate() %></th>
						<th><a href="/fanzhuanketang/CourseManagement/XiuGaiServlet?CourseID=<%=mm.getID() %>">修改</a></th>
						<th><a href="/fanzhuanketang/CourseManagement/deleteCourseServlet?ID=<%=mm.getID() %>">删除</a></th>
				</tr>
				</tbody>
		
		<%
			}
		%>
	</table>
</body>
</html>