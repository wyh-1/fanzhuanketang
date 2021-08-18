<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>根据上传者查询</title>
<style>
	.byuser_all{
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
<div class="byuser_all">
	<form action="/fanzhuanketang/FindFileByUserServlet"
		method="post">
		请选择上传者 ：
		<select name="userName" style="width: 80px">
			<option value="${teacherID }">${teacherID }</option>
			<c:forEach var="courseWare" items="${requestScope.nameList}">
				<option value="${courseWare.teacherID}">${courseWare.teacherID}</option>
			</c:forEach>
		</select> <input type="submit" value="查询">
	</form>
	<h3>上传文件如下:</h3>
	<!-- 遍历Map集合 -->
	<c:forEach var="dataBase" items="${dataBaseMap}">
		<c:url value="/DownLoadServlet" var="downurl">
			<c:param name="filename" value="${dataBase.key}"></c:param>
			<c:param name="allPath" value="${dataBasePath}"></c:param>
		</c:url>
         ${dataBase.value}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上传者：${teacherID }&nbsp;&nbsp;&nbsp;<a
			href="${downurl}">下载</a>
		<br />
	</c:forEach>
	<br />
	<br />

	<a href="/fanzhuanketang/index">返回首页</a>
	<br />
	<br />
	</div>
</body>
</html>