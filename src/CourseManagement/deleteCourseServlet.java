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

public class deleteCourseServlet extends HttpServlet{
    /*
	public void wrong1(){ //对话框提示信息
		String msg="不允许有空，无法删除！";
		int type=JOptionPane.YES_NO_CANCEL_OPTION;
		String title="信息提示";
		JOptionPane.showMessageDialog(null, msg,title,type);
	}
	public void right(){ 
		String msg="删除成功！";
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
            if(ID.length()==0){
                session.setAttribute("deleteCourseWrong", 1);
                response.sendRedirect("/fanzhuanketang/CourseManagement/Delete/deleteCourse.jsp");
            }else{
                CourseDao sti= DAOFactory.getCourseDAOInstance();
                boolean list=sti.deleteCourse(ID);

                //函数
                if(list==true){
                    session.setAttribute("deleteCourseWrong", 0);
                    CourseDao sti2=DAOFactory.getCourseDAOInstance();

                    List<Course> list2=sti2.selectAllCourseByUserID(usertype, (String) session.getAttribute("userid"));

                    session.setAttribute("Courselist", list2);
                    response.sendRedirect("/fanzhuanketang/CourseManagement/Show/Teachershow.jsp");
                }else{
                    session.setAttribute("deleteCourseWrong", 1);
                    response.sendRedirect("/fanzhuanketang/CourseManagement/Delete/deleteCourse.jsp");
                }

			/*try{
                CourseDao sti=DAOFactory.getCourseDAOInstance();
                boolean list=sti.deleteCourse(ID);


                /*Connection con=null;
                PreparedStatement pst=null;
                ResultSet rs=null;
                DBCon db=new DBCon();
                con=db.getConnection();
                ArrayList list4=new ArrayList();

                PreparedStatement pst2=null;
                pst2=con.prepareStatement("select * from Course,TeacherCourse"
                        + " where TeacherCourse.TeacherID='2001' and TeacherCourse.CourseID=Course.ID");
                System.out.println("7！");
                rs=pst2.executeQuery();
                while(rs.next()){
                Course s=new Course();
                s.setID(rs.getString("ID"));
                s.setTitle(rs.getString("Title"));
                s.setCourseDate(rs.getString("CourseDate"));
                list4.add(s);
                HttpSession session=request.getSession();
                session.setAttribute("list", list4);

            }


			//rs.close();
			//pst2.close();
			//right();
			//response.sendRedirect("http://localhost:8080/Course/ShowInfoServlet");
			}catch (Exception e) {
				e.printStackTrace();
			}*/

            }

        }

	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}
}

