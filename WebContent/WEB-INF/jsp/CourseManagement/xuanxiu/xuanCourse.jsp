<%@ page import="com.fanzhuanketang.po.Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>翻转课堂-学生-选修课程</title>
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
</head>
<body bgcolor="CCCFFF">
<%@include file="/html/student-header.html"%>
	<table border="0" cellspacing="0" cellpadding="0" bgcolor="#95BDFF" width="60%" align="center">
		
		<thead>
<tr style="background-color: #FFFFE8" height=20px>
						<th class="biao" >课程号</th>
						<th class="biao">课程名称</th>
						<th class="biao">上课时间</th>
						<th class="biao">选修</th>
</tr>
			</thead>
		<%
		List list = (List)session.getAttribute("Courselist");
		if (list != null) {
			for(int i=0;i<list.size();i++){
				Course mm=(Course)list.get(i);
				//String CourseID=mm.getID();
			
		%>
		<tbody>
					<tr style="background-color: #FFFFE8" height=20px>
						<th ><%=mm.getID() %></th>
						<th><%=mm.getTitle() %></th>
						<th><%=mm.getCourseDate() %></th>
						<th><a href="/fanzhuanketang/CourseManagement/XServlet?CourseID=<%=mm.getID() %>">选修</a></th>
						
						
						
				</tr>
				</tbody>
		
		<%
			}
		}
		%>
	</table>
</body>
</html>