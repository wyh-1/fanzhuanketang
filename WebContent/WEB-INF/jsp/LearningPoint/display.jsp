<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="DB.*"%>
<%@page import="java.sql.*"%>
<jsp:useBean id="check" class="DB.DBConnection"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示所有知识点</title>
</head>
<style>
.div1{
	color:red;
	height:80px;
	font-size:60px;
	text-align:center;
	}
.div2{
	width:100%;
	height:800px;
	text-align:center;
	background:url(images/background.jpg);
	background-size:cover;
	background-repeat:no-repeat;
	}
.A1{
	text-decoration: none;
	}
.div3{
	text-align:center;
	}
</style>
<body>
<div class="div1">
<a href="/fanzhuanketang/index">返回</a>
</div>
<div class="div2">
<table id="T1" width="100%" border="1" align="center">
  <tr>
    <th class="t1" scope="col">12位编号</th>
    <th class="t1" scope="col">教材名</th>
    <th class="t1" scope="col">知识点简介</th>
  </tr>
  <%
  	DBConnection.getConnection();
  	ResultSet rs = null;
  	rs = DBConnection.dispAll();
  	while(rs.next()){
  %>
  <tr>
    <th class="t1" scope="col"><%out.print(rs.getString(1));%></th>
    <th class="t1" scope="col"><%out.print(rs.getString(2));%></th>
    <th class="t1" scope="col"><%out.print(rs.getString(3));%></th>
    <%
  	}
    %>
  </tr>
</table>
</div>
</body>
</html>