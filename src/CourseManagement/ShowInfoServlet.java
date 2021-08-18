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

public class ShowInfoServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		//CourseDao sti=DAOFactory.getCourseDAOInstance();
		//List<Course> list=sti.selectAllCourseByUserID();
		//request.setAttribute("CourseList", list);
		//request.getRequestDispatcher("/show.jsp").forward(request, response);
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
		CourseDao sti= DAOFactory.getCourseDAOInstance();

		HttpSession session=request.getSession();
        String userid = (String) session.getAttribute("userid");
        Integer usertype = (Integer) session.getAttribute("usertype");
        if (userid != null && usertype != null) {
            //把个人信息保存到列表中
            //把列表保存到session对象中，以便在别的页面中获取个人信息
            List<Course> list=sti.selectAllCourseByUserID(usertype, userid);
            session.setAttribute("Courselist", list);
            if (usertype.equals(1)){
                //如果教师跳转到Teachershow.jsp
                response.sendRedirect("/fanzhuanketang/CourseManagement/Show/Teachershow.jsp");
            } else if (usertype.equals(0)) {
                //如果是学生跳转到Studentshow.jsp
                response.sendRedirect("/fanzhuanketang/CourseManagement/Show/Studentshow.jsp");
            } else {
                //管理员
                response.sendRedirect("/fanzhuanketang/managerMain.jsp");
            }
        } else {
            response.sendRedirect("/fanzhuanketang/index");
        }

	}
}
