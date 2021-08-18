<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看学生作业答案</title>
</head>
<body>
<table  border="1" width="100%">  
<tr>    
<th>作业编号</th>      
<th>学生编号</th>    
<th>学生姓名</th>    
<th>教师工号</th>   
<th>类型</th>    
<th>题目</th>  
<th>作业内容</th>
</tr> 
<tr>    
<th>${hmanswer.ID}</th>   
<th>${hw.Title}</th>  
<th>${stu.Name}</th>  
<th>${hw.Type}</th>   
<th>${hmanswer.Text}</th>    
<th>${hmanswer.TeacherID}</th>    
<th>${hmanswer.CourseID}</th>
</tr> 
</table>
</body>
</html>