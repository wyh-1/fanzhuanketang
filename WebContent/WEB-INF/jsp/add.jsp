<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
</head>

<body>
<form action="${pageContext.request.contextPath}/Teacher/add.action" method="post">
<div>
<table width=20% height="16%" border="1">
<tr>
	<td>上传作业</td>
	<td><a href="selectzy.jsp">作业查询</a></td>
</tr>
</table>
</div>
<div>
 <br><br><br>
        <table border="1"width="310"align="left">
           <tr>
              <td colspan="2">
                 <h3 >请填写</h3>
              </td>
           </tr>
           <tr>
              <td align="right">作业编号:</td>
<!--               <td><input type="text"name="ID"size="20"></td> -->
           </tr>
            <tr>
               <td align="right">标题:</td>
               <td><input type="text"name="Title"size="20"value="${Title}"/></td>
            </tr>
            <tr>
               <td align="right">截止日期:</td>
               <td><input type="date" id="name" name="Overtime" size="50"value="${Overtime}"/></td>
            </tr>
            <tr>
               <td align="right">作业类型:</td>
               <td>
               <input type="text"name="Type"size="20"value="${Type}"/> 
					<select class="name" name="Type">
					<option value="数据库">数据库</option>
					<option value="JSP">JSP</option>
					<option value="计算机网络">计算机网络</option>
					<option value="计算机系统结构">计算机系统结构</option></select>
               </td>
            </tr>
            <tr>
                <td align="right">作业文字内容:</td>
                <td>
                   <input type="text" name="Text"size="20"value="${Text}"/>
                </td>
            </tr>
             <tr>
                <td align="right">发布时间:</td>
                <td>
                  <input type="date"id="time" name="CreateTime"size="20"value="${CreateTime}"/>
                </td>
            </tr>
            <tr>
                <td align="right">发布教师工号:</td>
                <td>
                  <input type="text"class="name" name="TeacherID"size="20"value="${TeacherID}"/>
                </td>
            </tr>
            <tr>
                <td align="right">所属课程号:</td>
                <td><input type="text"class="name" name="CourseID"size="20"value="${CourseID}"/></td>
            </tr>
             <tr>
                <td align="right"><input type="submit" value="提交"/></td>
                <td><input type="reset" value="重置"/></td>
             </tr>
          </table>
          
</div>
</form>
</body>
</html>