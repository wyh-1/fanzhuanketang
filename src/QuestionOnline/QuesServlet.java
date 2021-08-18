package QuestionOnline;

import java.io.IOException;


import java.util.ArrayList;
import java.util.Date;

import 

javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


import javax.servlet.http.HttpServlet;
import 

javax.servlet.http.HttpServletRequest;
import 

javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fanzhuanketang.po.Ques;

import Database.DAOFactory;

/**
 * Servlet implementation class QuesServlet
 */
public class QuesServlet extends HttpServlet {
	private static 

final long serialVersionUID = 1L;
       
    /**
     * @see 

HttpServlet#HttpServlet()
     */
    public QuesServlet() {
        super();
     

   // TODO Auto-generated constructor stub
    }

	/**
	 * @see 

HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	

 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		Integer usertype = (Integer)session.getAttribute("usertype");
		if (usertype == null || !usertype.equals(0)) {
			response.sendRedirect("/fanzhuanketang/LoginRegister/stuLogin.jsp");
		} else {
            request.setCharacterEncoding("utf-8");
            String path = "/fanzhuanketang/QuestionOnline/QuesList.jsp";
            Ques ques = new Ques();
            String typ = request.getParameter("type");
            ques.setType(typ);
            ques.setTitle(request.getParameter("title"));
            ques.setText(request.getParameter("content"));
            Date date = new Date();
            //		try {
            //			new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("getTime()"));} catch (ParseException e1) {
            //e1.printStackTrace();
            //		}
            ques.setStudentID(userid);
            ques.setTime(new java.sql.Date(date.getTime()));
            ArrayList<String> info = new ArrayList<String>();    // 收集错误
            try {
                if (DAOFactory.getQuesDaoInstance().saveQues(ques)) {
                    info.add("问题信息添加成功");
                } else {
                    info.add("添加失败，请重新添加 ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("info", info);
            request.getRequestDispatcher(path).forward(request, response);
            response.sendRedirect(path);
        }
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);
	}

}
