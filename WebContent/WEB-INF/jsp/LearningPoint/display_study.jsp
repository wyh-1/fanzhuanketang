<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="DB.*"%>
<%@page import="java.sql.*"%>
<%@page session="false"%>
<jsp:useBean id="check" class="DB.DBConnection"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>知识点查询课件结果</title>
</head>
<style>
* { padding:0; margin:0;}
.div1{
	color:red;
	height:80px;
	font-size:60px;
	text-align:center;
	}
.div2{
	text-align:center;
	height:100px;
	}
.div3{
	width:100%;
	height:800px;
	text-align:center;
	background:url(images/background.jpg);
	background-size:cover;
	background-repeat:no-repeat;
	}
.div4{
	height:100px;
	}
.A1{
	text-decoration: none;
	}
</style>
<body>
<div class="div1">
<a href="/fanzhuanketang/index">返回</a>
</div>
<div class="div2">
</div>
<div class="div3">
<table id="T1" width="100%" border="1" align="center">
  <tr>
    <th class="t1" scope="col">课件编号</th>
    <th class="t1" scope="col">标题</th>
    <th class="t1" scope="col">说明</th>
    <th class="t1" scope="col">课件种类</th>
    <th class="t1" scope="col">知识点所属教材编号</th>
    <th class="t1" scope="col">文件路径</th>
    <th class="t1" scope="col">上传教师工号</th>
    <th class="t1" scope="col">所属课程号</th>
    <th class="t1" scope="col">上传时间</th>
  </tr>
  <%
  request.setCharacterEncoding("utf-8");
    		DB.DBConnection.getConnection();
    		ResultSet rs = null;
    		rs=DB.DBConnection.select_Study(request.getParameter("study"));
    		while(rs.next()){
  %>
  <tr>
    <th class="t1" scope="col"><%out.print(rs.getString(1));%></th>
    <th class="t1" scope="col"><%out.print(rs.getString(2));%></th>
    <th class="t1" scope="col"><%out.print(rs.getString(3));%></th>
    <th class="t1" scope="col"><%out.print(rs.getString(4));%></th>
    <th class="t1" scope="col"><%out.print(rs.getString(5));%></th>
    <th class="t1" scope="col"><%out.print(rs.getString(6));%></th>
    <th class="t1" scope="col"><%out.print(rs.getString(7));%></th>
    <th class="t1" scope="col"><%out.print(rs.getString(8));%></th>
    <th class="t1" scope="col"><%out.print(rs.getString(9));%></th>
    <%
  		}
  	//}
    %>
  </tr>
</table>
</div>
</body>
</html>