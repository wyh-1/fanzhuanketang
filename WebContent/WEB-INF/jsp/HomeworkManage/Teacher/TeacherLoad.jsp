<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="Database.*,java.sql.*,java.util.*,com.fanzhuanketang.po.*,com.fanzhuanketang.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师</title>
<style>
#name{
width=70px;
height=10px;
}
</style>
<link href="/fanzhuanketang/css/main.css" rel="stylesheet" />
</head>
<body>
<%
String msg=null;
	String userid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (userid == null || usertype == null || !usertype.equals(1)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
	%>
	<%@include file="/html/teacher-header.html"%>
	<form action="check.jsp"method="post">
        <table border="1"width="310"align="left"bgcolor='#CCFFFF'>
           <tr>
              <td colspan="2">
                 <h3 >请填写</h3>
              </td>
           </tr>
            <tr>
               <td align="right">标题:</td>
               <td><input type="text"name="Title"size="20"/></td>
            </tr>
            <tr>
               <td align="right">截止日期:</td>
               <td><input type="date" name="Overtime"size="20"/></td>
            </tr>
            <tr>
               <td align="right">作业类型:</td>
               <td>
					<select class="name" name="Type">
						<option value="JAVA语言设计">JAVA语言设计</option>
						<option value="数据库">数据库</option>
						<option value="JSP">JSP</option>
						<option value="计算机网络">计算机网络</option>
						<option value="计算机系统结构">计算机系统结构</option>
					</select>
               </td>
            </tr>
            <tr>
                <td align="right">作业文字内容:</td>
                <td>
                   <input type="text"name="Text"size="20"/>
                </td>
            </tr>
            <tr>
                <td align="right">所属课程号:</td>
                <td>
                  <select name="CourseID">
                  <%
                	CourseDao coursedao = DAOFactory.getCourseDAOInstance();
                	List<Course> courses = coursedao.selectAllCourseByUserID(usertype, userid);
                	for (Course course : courses) {
                	%>
                		<option value="<%=course.getID()%>"><%=course.getTitle()%></option>
                	<%
                	}
                  %>
                  </select>
                </td>
            </tr>
             <tr>
                <td align="right"><input type="button" oncheck="add(Homework homework)"/>提交</td>
                <td><input type="reset" value="重置"/></td>
             </tr>
          </table>
		</form>
	<%
	}
%>
</body>
</html>