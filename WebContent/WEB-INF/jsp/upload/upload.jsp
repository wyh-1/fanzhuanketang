<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>
<style>
	body{
	margin:0;
	padding:0;
	text-align:center;
	font-size:30px;
	margin-top:200px;
	}
	a{text-decoration:none;
	color:black;}
	.upload_all{
	border:2px solid #000;
	width:800px;
	height:200px;
	margin-left:500px;
	padding-top:50px;
	padding-bottom:50px;
	
	}
</style>
</head>
<body >
<div class="upload_all">
	 <form action="/fanzhuanketang/servlet/UploadHandleServlet" enctype="multipart/form-data" method="post">
         	请选择课程 ：
		<select name="courseId" style="width: 80px">
			<option value="">待选中。。。</option>
			<c:forEach var="course" items="${requestScope.titleList}">
				<option value="${course.courseId}">${course.courseTitle}</option>
			</c:forEach>
		</select><br/>
		请选择知识点 ：
		<select name="learnId" style="width: 80px">
			<option value="">待选中。。。</option>
			<c:forEach var="learnPoint" items="${requestScope.idList}">
				<option value="${learnPoint.learnId}">${learnPoint.learnId}</option>
			</c:forEach>
		</select><br/>
		文件描述：<input type="text" name = "fileDescribe"><br>
         	&nbsp;&nbsp;&nbsp;请选择上传文件：<input type="file" name="file1"><br><br>
         	
         	
         			<input type="submit" value="提交">
     </form>
     <br/>
     <a href="/fanzhuanketang/index">返回首页</a><br/><br/>
</div>
</body>
</html>