<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生作业</title>
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
</head>
<body bgcolor="CCCFFF">
<%
	String AnswerID= request.getParameter("AnswerID");
%>
<%@include file="/html/student-header.html"%>
   <center>
   <br>
   <br>
   <br>
   <h3>&nbsp;&nbsp;评价内容</h3>
   <form action="/fanzhuanketang/HomeworkManage/Student/StudentAnswerCM" method="post">
   <input type="hidden" name="AnswerID" value="<%=AnswerID%>">
     <table border="1" width="350">
       <tr>
       <td>写在这里:</td>
         <td><textarea name="content" rows="7" cols="30"></textarea></td>
       </tr>
       <tr align="center">
         <td colspan="2">
            <input name="sure" type="submit" value="提交"/>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input name="clear" type="reset" value="清空"/>
         </td>
       </tr>
       </tr>
     </table>
   </form>
   </center>
</body>
</html>