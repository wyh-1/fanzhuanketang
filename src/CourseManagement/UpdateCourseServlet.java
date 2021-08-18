package CourseManagement;

import Database.DAOFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.fanzhuanketang.dao.CourseDao;
import com.fanzhuanketang.po.Course;

public class UpdateCourseServlet extends HttpServlet{
	/*
	public void wrong1(){ //对话框提示信息
		String msg="不允许有空，无法修改！";
		int type=JOptionPane.YES_NO_CANCEL_OPTION;
		String title="信息提示";
		JOptionPane.showMessageDialog(null, msg,title,type);
	}
	*/
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Integer usertype = (Integer)session.getAttribute("usertype");
        if (usertype == null || !usertype.equals(1)) {
            response.sendRedirect("/fanzhuanketang/LoginRegister/teaLogin.jsp");
        } else {
            String ID=request.getParameter("ID");
            if(ID.length()==0){
                session.setAttribute("updateCourseWrong", 1);
                response.sendRedirect("/fanzhuanketang/CourseManagement/Delete/UpdateCourse.jsp");
            }else{
                session.setAttribute("updateCourseWrong", 0);
                CourseDao sti= DAOFactory.getCourseDAOInstance();
                List<Course> list2=sti.selectAllCourseByID(ID);
                session.setAttribute("list2", list2);

                ArrayList list3=null;
                Course dd=new Course();
                list3=new ArrayList();
                dd.setID(ID);
                list3.add(dd);
                session.setAttribute("list3", list3);

                response.sendRedirect("/fanzhuanketang/CourseManagement/Update/UpdateMC.jsp");
            }
        }
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
