package HomeworkManage.Student;
import Database.HomeworkDAO;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fanzhuanketang.po.Homework;

public class SelectAllHomeworkServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("userid");
        Integer usertype = (Integer)session.getAttribute("usertype");
        if (usertype == null || !usertype.equals(0)) {
            response.sendRedirect("/fanzhuanketang/LoginRegister/stuLogin.jsp");
        } else {
            HomeworkDAO homeworkDAO = new HomeworkDAO();
            List<Homework> homeworkList = homeworkDAO.selectHomework(userid);
            session.setAttribute("al", homeworkList);
            response.sendRedirect("/fanzhuanketang/HomeworkManage/Student/selectAllHomework.jsp");
        }
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		doGet(request,response);
	}
}
