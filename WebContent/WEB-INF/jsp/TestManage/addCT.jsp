<%@ page language="java" import="java.sql.*,Database.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增试题</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String msg=null;
	String userid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (userid == null || usertype == null || !usertype.equals(1)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
		request.setCharacterEncoding("UTF-8");
		DatabaseConnection databaseConnection = null;
		Connection conn=null;                 //声明Connection对象
		try {
			databaseConnection = new DatabaseConnection();
			conn = databaseConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("{call dbo.addCT(?,?,?,?,?,?,?)}");  
			pstmt.setNString(1,request.getParameter("Text"));
			pstmt.setNString(2,request.getParameter("Type"));
			pstmt.setNString(3,request.getParameter("TestKey"));
			pstmt.setNString(4,request.getParameter("Score"));
			java.util.Date nowDate = new java.util.Date();
			pstmt.setDate(5,new java.sql.Date(nowDate.getTime()));
			pstmt.setNString(6,userid);
			pstmt.setNString(7,request.getParameter("CourseID"));
			int rs= pstmt.executeUpdate();
			if(rs==1){                
				msg="新增成功，点击确定回到试题列表页面";
			}
			else
			{
				msg="新增失败，点击确定回到试题列表页面";
			}             //关闭结果集
			pstmt.close(); 
		}
		catch (SQLException e) {
			System.out.println(e.toString());
			msg="新增失败，点击确定回到试题列表页面";
			
		} finally {
			if (databaseConnection!= null) databaseConnection.close();
		}
	}
%>
<script>window.alert('<%=msg %>');</script>
<%
	response.setHeader("Refresh", "1;url=ClassTest.jsp");
%>
</body>
</html>