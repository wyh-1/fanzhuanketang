package HomeworkManage.Student;

import Database.DatabaseConnection;
import Database.HomeworkDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentAnswerCM extends HttpServlet{
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
		String AnswerID = request.getParameter("AnswerID");
		String Text = request.getParameter("content");
        DatabaseConnection db = null;
		try{
			db=new DatabaseConnection();
			Connection con=db.getConnection();
			PreparedStatement pst=con.prepareStatement("insert into HomeworkAnswerPeerResponse values(?,?,?,?)");
			pst.setString(1, AnswerID);
            pst.setString(2, (String) session.getAttribute("userid"));
			pst.setTimestamp(3, Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())));
			pst.setString(4, request.getParameter("content"));
            if (pst.executeUpdate()>0) {
                response.sendRedirect("/fanzhuanketang/HomeworkManage/Student/1.jsp");
            } else {
                response.sendRedirect("/fanzhuanketang/HomeworkManage/Student/StudentAnswer.jsp");
            }
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
            if (db != null) db.close();
        }
	}
}
protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
			doGet(request,response);
		}
}
			

