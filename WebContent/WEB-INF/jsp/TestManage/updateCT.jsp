<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,Database.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="all.css" type="text/css">
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
<title>修改</title>
</head>
<body>
<%@include file="/html/teacher-header.html"%>
<div id="div7">
<%
String userid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (userid == null || usertype == null || !usertype.equals(1)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
		 request.setCharacterEncoding("utf-8");    
		String ID= request.getParameter("ID");
		String sql="select * from ClassTest where ID=?";
		Connection conn = null;                 //声明Connection对象
		Statement stmt = null;         //声明PreparedStatement对象
		ResultSet rs = null;                    //声明ResultSet对象
		DatabaseConnection databaseConnection=null;
		try {
			databaseConnection = new DatabaseConnection();
			conn = databaseConnection.getConnection();     //获取数据库连接
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(ID));
			rs = pstmt.executeQuery();
			String Text =null;
			String Type =null;
			String TestKey =null;
			int Score =0;
			java.util.Date CreateTime=null;
			String TeacherID =null;
			String CourseID =null;
			if(rs.next()){
				Text = rs.getString("Text");
				Type =rs.getString("Type");
				TestKey =rs.getString("TestKey");
				Score=rs.getInt("Score");
				CreateTime=rs.getDate("CreateTime");
				TeacherID =rs.getString("TeacherID");
				CourseID =rs.getString("CourseID");
        %>
           <h2 align="center">修改</h2>
		<form name="form1" onSubmit="return check()" action="updateCT_do.jsp" method="post">
		<input type="hidden" name="ID" value="<%=ID %>">
		<table align="center" width="30%" border="1">
			<tr><th>内容：</th>
				<td><input type="text" name="Text" value="<%=Text %>"></td></tr>
			<tr><th>类型：</th>
				<td><input type="text" name="Type" value="<%=Type %>"></td></tr>
			<tr><th>参考答案：</th>
				<td><input type="text" name="TestKey" value="<%=TestKey %>"></td></tr>
			<tr><th>分值：</th>
				<td><input type="text" name="Score" value="<%=Score %>"></td></tr>
			<tr><th>布置时间：</th>
				<td><input type="text" name="CreateTime" value="<%=CreateTime %>"></td></tr>
			<tr><th>布置教师：</th>
				<td><input type="text" name="TeacherID" value="<%=TeacherID %>"></td></tr>
			<tr><th>课程号：</th>
				<td><input type="text" name="CourseID" value="<%=CourseID %>"></td></tr>
			<tr><th colspan="2">
			  <input type="submit" value="确定">
			  <input type="reset" value="重置"></th></tr>
		</table>
		</form> 
      <%
      }
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			if (databaseConnection!= null) databaseConnection.close();
		}
	}
%> 
</div> 
</body>
</html>