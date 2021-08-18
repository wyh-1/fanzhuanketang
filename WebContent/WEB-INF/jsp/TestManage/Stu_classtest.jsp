<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,Database.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="all.css" type="text/css">
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
<title>课堂试题</title>
</head>
<body>
<%@include file="/html/student-header.html"%>
<div id="div2" >
<h2 align="center">课堂试题</h2>
<%
	String userid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (userid == null || usertype == null || !usertype.equals(0)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
		request.setCharacterEncoding("UTF-8");
		String sql = "select * from ClassTest";   //定义查询数据库的SQL语句
		Connection conn = null;                 //声明Connection对象
		Statement stmt = null;         //声明PreparedStatement对象
		ResultSet rs = null;                    //声明ResultSet对象
		DatabaseConnection databaseConnection = null;
		try {
			databaseConnection = new DatabaseConnection();
			conn = databaseConnection.getConnection();     //获取数据库连接
			stmt = conn.createStatement(); //根据sql创建PreparedStatement
			rs = stmt.executeQuery(sql);           //执行查询，返回结果集
			%>
               <table align="center" width="80%" border="2">
  <tr>
    <td>编号</td>
    <td>内容</td>
    <td>类型</td>
    <td>分值</td>
    <td>操作</td>
  </tr>
        <%
        while (rs.next()) {                 //遍历结果集
        	int ID=rs.getInt("ID");
            %>
    		<tr>
    		            <td><%=rs.getInt("ID")%></td>
						<td><%=rs.getString("Text") %></td>
						<td><%=rs.getString("Type") %></td>
						<td><%=rs.getInt("Score") %></td>
						<td><a href="Stu_answer.jsp?ID=<%=ID %>">抢答</a></td>
 		   </tr>
           
            <%
        }%>
        </table>
        <%
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