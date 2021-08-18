<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,Database.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="all.css" type="text/css">
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
<title>点评</title>
</head>
<body>
<%@include file="/html/teacher-header.html"%>
<div id="div9">
<%
	String userid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (userid == null || usertype == null || !usertype.equals(1)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
		request.setCharacterEncoding("UTF-8");  
		String ID= request.getParameter("ID");
		String sql="select * from TestAnswer where ID=?";
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
			String CTeacherComment =null;
			String CTeacherID =null;
			if(rs.next()){
				CTeacherComment = rs.getString("CTeacherComment");
				CTeacherID =rs.getString("CTeacherID");
    	
        %>
           <h2 align="center">点评</h2>
		<form name="form1" onSubmit="return check()" action="Comment_do.jsp" method="post">
		<input type="hidden" name="ID" value="<%=ID %>">
		<table align="center" width="30%" border="1">
			<tr><th>批注教师：</th>
				<td><input type="text" name="CTeacherID" value="<%=CTeacherID %>"></td></tr>
			<tr><th>内容：</th>
				<td><input type="text" name="CTeacherComment" value="<%=CTeacherComment %>"></td></tr>
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