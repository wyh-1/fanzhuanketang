<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.net.URLEncoder"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>下载文件显示页面</title>
<style>
	.bycourse_all{
	width:800px;
	height:200px;
	margin-left:500px;
	margin-top:100px;
	padding-top:50px;
	padding-bottom:50px;
	font-size:25px;
	}



</style>
</head>
<body>
<div class="bycourse_all">
	<form action="/fanzhuanketang/servlet/ListFileServlet"
		method="post">
		请选择课程名称 ：
	    <select name="courseName">
	    	<option value="">${courseName}</option>
			<c:forEach var="course" items="${requestScope.courseList}">
				<option value="${course.courseCode}">${course.courseTitle}</option>
			</c:forEach>
		</select> 
		<input type="submit" value="查询">
	</form>
	<h3>课程文件如下:</h3>
	
	 <!-- 遍历Map集合 -->

     <c:forEach var="dataBase" items="${dataBaseMap}">
         <c:url value="/DownLoadServlet" var="downurl">
             <c:param name="filename" value="${dataBase.key}"></c:param>
             <c:param name="allPath" value="${dataBasePath}"></c:param>
         </c:url>
         ${dataBase.value}&nbsp;&nbsp;&nbsp;<a href="${downurl}">下载</a>
         <br/>
     </c:forEach>
     
    <br />
	<br />

	<a href="/fanzhuanketang/index">返回首页</a>
	<br />
	<br />
     </div>
</body>
</html>