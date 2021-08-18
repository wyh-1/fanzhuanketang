<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,Database.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String msg=null;
	String userid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (userid == null || usertype == null || !usertype.equals(0)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
		 request.setCharacterEncoding("UTF-8");
		 String ID= request.getParameter("TestID");
		 String StudentID=userid;
		 String Text= request.getParameter("TestKey");
		 String sql="select * from ClassTest where ID=?";
		 Connection conn = null;                 //声明Connection对象
		 Statement stmt = null;         //声明PreparedStatement对象
		 ResultSet rs = null;                    //声明ResultSet对象
		 DatabaseConnection databaseConnection = null;
		 try {
			databaseConnection = new DatabaseConnection();
			conn = databaseConnection.getConnection();     //获取数据库连接
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(ID));
			rs = pstmt.executeQuery();
			String Type =null;
			int Score =0;
			java.util.Date CreateTime=null;
			String TeacherID =null;
			String CourseID =null;
			if(rs.next()){
				Type =rs.getString("Type");
				Score=rs.getInt("Score");
				CreateTime=rs.getDate("CreateTime");
				TeacherID =rs.getString("TeacherID");
				CourseID =rs.getString("CourseID");
			   }
			String sql1="insert into TestAnswer values(?,?,?,?,?,null)";
			PreparedStatement pstmt1=conn.prepareStatement(sql1);
			pstmt1.setString(1, Text);
			pstmt1.setString(2, StudentID);
			pstmt1.setString(3, Type);
			pstmt1.setString(4, ID);
			pstmt1.setString(5,TeacherID);
			//pstmt1.executeUpdate();
			int result = pstmt1.executeUpdate();
			msg = "抢答失败，点击确定跳转到试题抢答页面！";
			if(result == 1){
				msg = "抢答成功，点击确定跳转到试题抢答页面！";
			}
		 } catch (SQLException e) {
			 System.out.println(e.toString());
		 } finally {
			 if (databaseConnection!= null) databaseConnection.close();
		 }
	}
%>
<script>window.alert('<%=msg %>');</script>
<%
	response.setHeader("Refresh", "1;url=Stu_classtest.jsp");
%>
</body>
</html>