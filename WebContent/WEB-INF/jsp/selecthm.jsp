<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看作业</title>
</head>
<body>
<table border="1">
<tr>
<th>作业编号</th>    
<th>标题</th>   
<th>截止日期</th>    
<th>类型</th>    
<th>文字内容</th>    
<th>发布日期</th>   
<th>发布教师工号</th>    
<th>所属课程编号</th>  
</tr> 
<tr>
<th>${hm.ID}</th>   
<th>${hm.Title}</th>  
<th>${hm.OverTime}</th>  
<th>${hm.Type}</th>   
<th>${hm.Text}</th>   
<th>${hm.CreateTime}</th>  
<th>${hm.TeacherID}</th>    
<th>${hm.CourseID}</th>
</tr>
</table>
</body>
</html>