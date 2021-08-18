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

public class UpdateMCServlet extends HttpServlet{
	/*
	public void wrong1(){ //对话框提示信息
		String msg="不允许有空，无法修改！";
		int type=JOptionPane.YES_NO_CANCEL_OPTION;
		String title="信息提示";
		JOptionPane.showMessageDialog(null, msg,title,type);
	}
	public void right(){ 
		String msg="修改成功！";
		int type=JOptionPane.YES_NO_CANCEL_OPTION;
		String title="信息提示";
		JOptionPane.showMessageDialog(null,msg,title,type);
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
            String Title=request.getParameter("Title");
            String CourseDate=request.getParameter("CourseDate");
            String ID=null;
            ArrayList list3=(ArrayList)session.getAttribute("list3");
            for(int i=list3.size()-1;i>=0;i--){
                Course ss=(Course)list3.get(i);
                ID=ss.getID();
            }
            if(Title.length()==0||CourseDate.length()==0){
                session.setAttribute("updateCourseWrong", 1);
                response.sendRedirect("/fanzhuanketang/CourseManagement/Delete/updateCourse.jsp");
            }else{
                try{
                    CourseDao courseDao = DAOFactory.getCourseDAOInstance();
                    Course course = new Course();
                    course.setID(ID);
                    course.setTitle(Title);
                    course.setCourseDate(CourseDate);
                    courseDao.UpdateCourse(course);

                    response.sendRedirect("/fanzhuanketang/CourseManagement/ShowInfoServlet");
                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
