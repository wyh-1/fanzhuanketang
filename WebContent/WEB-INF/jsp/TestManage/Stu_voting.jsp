<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,Database.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String msg=null;
	String Studentid = (String)session.getAttribute("userid");
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (Studentid == null || usertype == null || !usertype.equals(0)) {
		response.sendRedirect("/fanzhuanketang/index");
	} else {
      request.setCharacterEncoding("UTF-8");
      String ID= request.getParameter("ID");   //TestAnswer编号
      String sql="select StudentID from TestAnswer where ID=?";   //StudentID回答学生学号
      String StudentID=null;
      Connection conn = null;                 //声明Connection对象
      PreparedStatement pstmt = null;         //声明PreparedStatement对象
      ResultSet rs = null;                    //声明ResultSet对象
      int flag=0;
	  DatabaseConnection databaseConnection=null;
      try{
    	  databaseConnection = new DatabaseConnection();
			conn = databaseConnection.getConnection();     //获取数据库连接
          pstmt=conn.prepareStatement(sql);
      	  pstmt.setInt(1, Integer.parseInt(ID));
       	  rs = pstmt.executeQuery();
       	if(rs.next()){
       		StudentID = rs.getString("StudentID");
       	}
       	sql="select * from TestAnswerVote where AnswerID=? AND StudentID=?";
  	  pstmt=conn.prepareStatement(sql);
  	  pstmt.setInt(1, Integer.parseInt(ID));
  	  pstmt.setString(2, Studentid);
  	 rs = pstmt.executeQuery();
  	  while(rs.next()){
  		  
  		  flag=1;
  	  }
  	  msg = "投票成功，点击确定跳转到投票页面！";
  	  if(StudentID!=Studentid && flag==0){
 		   sql="insert into TestAnswerVote values(?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(ID));
				pstmt.setString(2, Studentid);
				int rs1= pstmt.executeUpdate();
 	  }
       	  if(flag==1){
       		msg = "投票失败，不能重复投票，点击确定跳转到投票页面！";
       	  }
      }catch (SQLException e) {
          System.out.println(e.toString());
      } finally {
          if (databaseConnection!= null) databaseConnection.close();
      }
	}

%>
<script>window.alert('<%=msg %>');</script>
<%
	response.setHeader("Refresh", "1;url=Stu_vote.jsp");
%>
</body>
</html>