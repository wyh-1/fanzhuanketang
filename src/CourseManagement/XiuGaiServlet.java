package CourseManagement;

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

import com.fanzhuanketang.po.Course;

import Database.DatabaseConnection;
public class XiuGaiServlet extends HttpServlet{
	/*
	public void wrong1(){ 
		String msg="修改失败！";
		int type=JOptionPane.YES_NO_CANCEL_OPTION;
		String title="信息提示";
		JOptionPane.showMessageDialog(null,msg,title,type);
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
		String CourseID=request.getParameter("CourseID");
		try{
			Connection con=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			DatabaseConnection db=new DatabaseConnection();
			con=db.getConnection();
			String sql1="select * from Course where ID='"+CourseID+"'";
			pst=con.prepareStatement(sql1);
			rs=pst.executeQuery();
			
			
			HttpSession session=request.getSession();
				ArrayList list2=null;
				list2=new ArrayList();
				while(rs.next()){
					Course s=new Course();
					s.setID(rs.getString("ID"));
					s.setTitle(rs.getString("Title"));
					s.setCourseDate(rs.getString("CourseDate"));
					list2.add(s);
					session.setAttribute("list2", list2);
				}
				
				ArrayList list3=null;
				Course dd=new Course();
				list3=new ArrayList();
				dd.setID(CourseID);
				list3.add(dd);
				session.setAttribute("list3", list3);
				
			rs.close();
			pst.close();
			response.sendRedirect("/fanzhuanketang/CourseManagement/Update/UpdateMC.jsp");
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}	
	
}

