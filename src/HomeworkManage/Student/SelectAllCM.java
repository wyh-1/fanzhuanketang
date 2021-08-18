package HomeworkManage.Student;

import Database.DatabaseConnection;
import Database.HomeworkDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fanzhuanketang.po.Homework;
import com.fanzhuanketang.po.HwAnsComment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SelectAllCM extends HttpServlet{
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
            String HomeworkID = request.getParameter("HomeworkID");
            DatabaseConnection db = null;
            try{
                db=new DatabaseConnection();
                Connection con=db.getConnection();
                PreparedStatement pst=con.prepareStatement("select HomeworkAnswerPeerResponse.StudentID, HomeworkAnswerPeerResponse.CreateTime, HomeworkAnswerPeerResponse.Comment from HomeworkAnswerPeerResponse, HomeworkAnswer, Homework where HomeworkAnswer.ID = AnswerID and Homework.ID = HomeworkAnswer.HomeworkID and Homework.ID=?");
                pst.setString(1, HomeworkID);
                ResultSet resultSet = pst.executeQuery();
                ArrayList<HwAnsComment> HwAnsComments = new ArrayList<>();
                while (resultSet.next()) {
                    HwAnsComments.add(new HwAnsComment(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
                }
                session.setAttribute("alCM", HwAnsComments);
                response.sendRedirect("/fanzhuanketang/HomeworkManage/Student/selectAllCM.jsp");
            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (db != null) db.close();
            }
        }
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		doGet(request,response);
	}
}
