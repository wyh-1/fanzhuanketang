package CourseManagement;

import Database.DAOFactory;
import Database.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.fanzhuanketang.dao.CourseDao;
import com.fanzhuanketang.po.Course;

public class XServlet extends HttpServlet{
	/*
	public void right(){ 
		String msg="选课成功！";
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
        if (usertype == null || !usertype.equals(0)) {
            response.sendRedirect("/fanzhuanketang/LoginRegister/stuLogin.jsp");
        } else {
            String CourseID=request.getParameter("CourseID");
            String StudentID=(String)session.getAttribute("userid");
            boolean t=insertStudentCourse(StudentID,CourseID);
            //right();
            if(t==true){

                CourseDao sti1= DAOFactory.getCourseDAOInstance();

                List<Course> list=sti1.selectAllCourseByUserID(usertype, StudentID);
                session.setAttribute("Courselist", list);
                response.sendRedirect("/fanzhuanketang/CourseManagement/Show/Studentshow.jsp");
            }
        }
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}
	
	
	public boolean insertStudentCourse(String StudentID,String CourseID) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean b=false;
		try{
			DatabaseConnection db=new DatabaseConnection();
			con=db.getConnection();
			pst=con.prepareStatement("insert into StudentCourse values(?,?)");
			pst.setString(1, StudentID);
			pst.setString(2, CourseID);
			int i=pst.executeUpdate();
			if(i>0){
				b=true;
			}
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	
	
}