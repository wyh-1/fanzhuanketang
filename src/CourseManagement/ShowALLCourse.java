package CourseManagement;

import Database.DAOFactory;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fanzhuanketang.dao.CourseDao;
import com.fanzhuanketang.po.Course;

public class ShowALLCourse extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Integer usertype = (Integer)session.getAttribute("usertype");
		if (usertype == null || !usertype.equals(0)) {
			response.sendRedirect("/fanzhuanketang/LoginRegister/stuLogin.jsp");
		} else {
            CourseDao sti= DAOFactory.getCourseDAOInstance();

            List<Course> list=sti.selectAllCourse();
            //把个人信息保存到列表中
            //把列表保存到session对象中，以便在别的页面中获取个人信息
            session.setAttribute("Courselist", list);
            response.sendRedirect("/fanzhuanketang/CourseManagement/xuanxiu/xuanCourse.jsp");
		}
	}
}