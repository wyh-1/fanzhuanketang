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

import com.fanzhuanketang.dao.CourseDao;
import com.fanzhuanketang.po.Course;

public class AddCourseServlet extends HttpServlet{
	/*
	public void wrong1(){ //对话框提示信息
		String msg="不允许有空，注册失败！";
		int type=JOptionPane.YES_NO_CANCEL_OPTION;
		String title="信息提示";
		JOptionPane.showMessageDialog(null, msg,title,type);
	}
	public void wrong2(){ //对话框提示信息
		String msg="添加失败！";
		int type=JOptionPane.YES_NO_CANCEL_OPTION;
		String title="信息提示";
		JOptionPane.showMessageDialog(null, msg,title,type);
	}
	public void right(){ 
		String msg="添加成功！";
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
            String ID=request.getParameter("ID");
            String Title=request.getParameter("Title");
            String CourseDate=request.getParameter("CourseDate");
            if(ID.length()==0||Title.length()==0||CourseDate.length()==0){
                session.setAttribute("addCourseWrong", 1);
                response.sendRedirect("/fanzhuanketang/CourseManagement/Add/addCourse.jsp");
            } else{
                Course s=new Course();
                s.setID(ID);
                s.setTitle(Title);
                s.setCourseDate(CourseDate);
                System.out.println(s.getID());
                CourseDao sti= DAOFactory.getCourseDAOInstance();
                boolean tj = sti.insertCourse(s);
                String TeacherID= (String) session.getAttribute("userid");
                String CourseID=ID;
                boolean t=insertTeacherCourse(TeacherID,CourseID);
                request.getSession().setAttribute("addCourseWrong", 0);
                if(tj==true||t==true){
                    CourseDao sti1=DAOFactory.getCourseDAOInstance();

                    List<Course> list=sti1.selectAllCourseByUserID(usertype, TeacherID);

                    session.setAttribute("Courselist", list);
                    response.sendRedirect("/fanzhuanketang/CourseManagement/Show/Teachershow.jsp");
                }else{
                    request.getSession().setAttribute("addCourseWrong", 2);
                    response.sendRedirect("/fanzhuanketang/CourseManagement/Add/addCourse.jsp");
                }
            }
        }
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}
	
	
	private boolean insertTeacherCourse(String TeacherID,String CourseID) {
		boolean b=false;
		try{
			DatabaseConnection db=new DatabaseConnection();
			Connection con=db.getConnection();
			PreparedStatement pst=con.prepareStatement("insert into TeacherCourse values(?,?)");
			pst.setString(1, TeacherID);
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