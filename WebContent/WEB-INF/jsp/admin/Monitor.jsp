<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>学生行为记录</title>
<link rel="stylesheet" href="monitor.css">
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
</head>
<body>
<%@include file="/html/manager-header.html"%>
	<a href="ListSMServlet?pageNos=1&type=all"><button>查询全部记录</button></a>
	<a href="ListSMServlet?pageNos=1&type=day"><button>查询当天记录</button></a>
	<a href="ListSMServlet?pageNos=1&type=week"><button>查询本周记录</button></a>
	<a href="ListSMServlet?pageNos=1&type=month"><button>查询本月记录</button></a>
	
<center>
	<div class="monitor">
		<div class="monitor_list">
			<table width="500" border="1 solid">
				<tbody>
					<tr>
						<th colspan="4" scope="row">用户行为记录</th>
					</tr>
					<tr>
						<th scope="col">操作时间</th>
						<th scope="col">学生学号</th>
						<th scope="col">操作内容</th>
					</tr>
					<c:forEach items="${listss}" var="sm">
						<tr>
							<td>${sm.createtime }</td>
							<td>${sm.studentID }</td>
							<td>${sm.content }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<c:if test="${pageNos>1 }">
				<a href="ListSMServlet?pageNos=1&type=${type}">首页</a>
				<a href="ListSMServlet?pageNos=${pageNos-1 }&type=${type}">上一页</a>
			</c:if>
			<c:if test="${pageNos <recordCount }">
				<a href="ListSMServlet?pageNos=${pageNos+1 }&type=${type}">下一页</a>
				<a href="ListSMServlet?pageNos=${recordCount }&type=${type}">末页</a>
			</c:if>
			<c:if test="${pageNos!=null }">
			<form action="ListSMServlet">
				<h4>
					共${recordCount}页
				 	<c:if test="${recordCount>1 }"> 
						<input type="text" value="${pageNos}" name="pageNos" size="1">页
						<input type="text" value="${type}" name="type" style="display:none;">
						<input type="submit" value="到达">
					</c:if> 
				</h4>
			</form>
			</c:if>
		</div>
	</div>
	</center>
</body>
</html>

