<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,Database.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="all.css" type="text/css">
<title>保存点评</title>
</head>
<body>
<div id="div10">
<%
	String msg=null;
	String userid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (userid == null || usertype == null || !usertype.equals(1)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
		 request.setCharacterEncoding("UTF-8");
		 String ID = request.getParameter("ID");
		 String CTeacherComment = request.getParameter("CTeacherComment");
		 String CTeacherID = request.getParameter("CTeacherID");
		 Connection conn = null;                 //声明Connection对象
		 Statement stmt = null;         //声明PreparedStatement对象
		 DatabaseConnection databaseConnection = null;
		 try {
			databaseConnection = new DatabaseConnection();
			conn = databaseConnection.getConnection();     //获取数据库连接
			 String sql="update TestAnswer set CTeacherID=?,CTeacherComment=? where ID=?";
			 PreparedStatement pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, CTeacherID);
			 pstmt.setString(2, CTeacherComment);
			 pstmt.setInt(3, Integer.parseInt(ID));
			 int rs= pstmt.executeUpdate();
			if(rs==1){                
				 msg="点评成功，点击确定回到试题列表页面";
			 }
			 else
			 {
				msg="点评失败，点击确定回到试题列表页面";
			 }             //关闭结果集
			 pstmt.close(); 
		 } catch (SQLException e) {
			 System.out.println(e.toString());
		 } finally {
			 if (databaseConnection!= null) databaseConnection.close();
		 }
	}
%>
<script>window.alert('<%=msg %>');</script>
<%
	response.setHeader("Refresh", "1;url=TestAnswer.jsp");
%>
</div>
</body>
</html>