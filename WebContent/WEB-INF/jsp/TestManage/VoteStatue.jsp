<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,Database.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="all.css" type="text/css">
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
<title>学生答案投票情况</title>
</head>
<body>
<%@include file="/html/teacher-header.html"%>
<div id="div11">
<h2 align="center">学生投票情况</h2>
<%
String userid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (userid == null || usertype == null || !usertype.equals(1)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;                 //声明Connection对象
		Statement stmt = null;         //声明PreparedStatement对象
		ResultSet rs = null;                    //声明ResultSet对象
		int AnswerID=0;
		String StudentID=null;
		DatabaseConnection databaseConnection=null;
		try{
			databaseConnection = new DatabaseConnection();
			conn = databaseConnection.getConnection();     //获取数据库连接
			String sql="select * from TestAnswerVote";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
		%>
        <table align="center" width="50%" border="2">
<tr>
<td>回答编号</td>
<td>学生学号</td>
</tr>
 <%
 while (rs.next()) {                 //遍历结果集
     %>
		<tr>
		            <td><%=rs.getInt("AnswerID")%></td>
					<td><%=rs.getString("StudentID") %></td>
					
					
					
	 </tr>
    
     <%
 }
 %>

 </table>
<%	
		}catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			if (databaseConnection!= null) databaseConnection.close();
		}
	}
%>
</div>
</body>
</html>