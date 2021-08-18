package HomeworkManage.Student;
import Database.HomeworkDAO;

import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class StudentAnswerServlet extends HttpServlet{
protected void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	HttpSession session = request.getSession();
	Integer usertype = (Integer)session.getAttribute("usertype");
	if (usertype == null || !usertype.equals(0)) {
		response.sendRedirect("/fanzhuanketang/LoginRegister/stuLogin.jsp");
	} else {
		String studentID = (String) session.getAttribute("userid");
		String HomeworkID = request.getParameter("HomeworkID");
		String Text = request.getParameter("content");
		HomeworkDAO homeworkDAO = new HomeworkDAO();
		if (homeworkDAO.addHomework(studentID, new java.sql.Date(new Date().getTime()), HomeworkID, Text)) {
			response.sendRedirect("/fanzhuanketang/HomeworkManage/Student/1.jsp");
		} else {
			response.sendRedirect("/fanzhuanketang/HomeworkManage/Student/StudentAnswer.jsp");
		}
	}
}
protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
			doGet(request,response);
		}
}
			

