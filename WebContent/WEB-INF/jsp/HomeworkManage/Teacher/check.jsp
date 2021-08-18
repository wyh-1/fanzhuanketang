<%@page import="HomeworkManage.Teacher.ADD"%>
<%@page import="java.sql.*, java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上传作业数据处理页面</title>
</head>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="database" scope="request" class="HomeworkManage.Teacher.ADD"/>
<body>
    <%
    request.setCharacterEncoding("utf-8");
	String userid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (userid == null || usertype == null || !usertype.equals(1)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
	   String Title=request.getParameter("Title");
	   String Overtime=request.getParameter("Overtime");
	   String Type=request.getParameter("Type");
	   String Text=request.getParameter("Text");
	   String ImgFile=request.getParameter("ImgFile"); 
	   String CreateTime=new java.sql.Date(new java.util.Date().getTime()).toString();
	   String TeacherID=userid;
	   String CourseID=request.getParameter("CourseID");
	database.addInfo(Title, Overtime, Type, Text, CreateTime, TeacherID, CourseID);
		 response.sendRedirect("TeacherLoad.jsp");
	}
   %>
</body>
</html>