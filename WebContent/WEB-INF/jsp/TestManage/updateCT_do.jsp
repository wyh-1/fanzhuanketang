<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.text.SimpleDateFormat,Database.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保存点评</title>
</head>
<body>
<%
	String msg=null;
	String userid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (userid == null || usertype == null || !usertype.equals(1)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
		 request.setCharacterEncoding("UTF-8");
		 String ID = request.getParameter("ID");
		 String Text =request.getParameter("Text");
		String Type =request.getParameter("Type");
		String TestKey =request.getParameter("TestKey");
		String Score =request.getParameter("Score");
		String CreateTime=request.getParameter("CreateTime");
		String TeacherID =request.getParameter("TeacherID");
		String CourseID =request.getParameter("CourseID");
		
		 Connection conn = null;                 //声明Connection对象
		 Statement stmt = null;         //声明PreparedStatement对象
		 DatabaseConnection databaseConnection=null;
		 try {
			 java.util.Date temp=null;
				temp=new SimpleDateFormat("yyyy-MM-dd").parse(CreateTime);
				java.sql.Date CrT=new java.sql.Date(temp.getTime());
			databaseConnection = new DatabaseConnection();
				conn = databaseConnection.getConnection();     //获取数据库连接
			 String sql="update ClassTest set Text=?,Type=?,TestKey=?,Score=?,CreateTime=?,TeacherID=?,CourseID=? where ID=?";
			 PreparedStatement pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, Text);
			 pstmt.setString(2, Type);
			 pstmt.setString(3, TestKey);
			 pstmt.setInt(4, Integer.parseInt(Score));
			 pstmt.setDate(5,CrT);
			 pstmt.setString(6, TeacherID);
			 pstmt.setString(7, CourseID);
			 pstmt.setInt(8, Integer.parseInt(ID));
			 int rs= pstmt.executeUpdate();
			if(rs==1){                
				 msg="修改成功，点击确定回到试题列表页面";
			 }
			 else
			 {
				msg="修改失败，点击确定回到试题列表页面";
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
	response.setHeader("Refresh", "1;url=ClassTest.jsp");
%>
</body>
</html>