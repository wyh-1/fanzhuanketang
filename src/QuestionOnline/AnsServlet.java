package QuestionOnline;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fanzhuanketang.po.Ans;

import Database.DAOFactory;


/**
 * Servlet implementation class AnsServlet
 */
public class AnsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String userid = (String)session.getAttribute("userid");
        Integer usertype = (Integer)session.getAttribute("usertype");
        if (usertype == null || !usertype.equals(1)) {
            response.sendRedirect("/fanzhuanketang/LoginRegister/teaLogin.jsp");
        } else {
            request.setCharacterEncoding("utf-8");
            String path = "/fanzhuanketang/QuestionOnline/AnsList.jsp?QuesID=" + request.getParameter("QuestionID");
            Ans ans = new Ans();
            ans.setQuesID(Integer.parseInt(request.getParameter("QuestionID")));
            ans.setText(request.getParameter("content"));
            //try {
            //new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("getTime()"));
            //} catch (ParseException e1) {
            // TODO Auto-generated catch block
            //e1.printStackTrace();
            //}

            ans.setTeacherID(userid);
            ans.setTime(new java.sql.Date(new Date().getTime()));
            ArrayList<String> info = new ArrayList<String>();    // 收集错误

            try {
                if (DAOFactory.getAnsDaoInstance().saveAns(ans)) {
                    info.add("已回复");
                } else {
                    info.add("回复失败，请重新回复 ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("info", info);
            request.getRequestDispatcher(path).forward(request, response);
            response.sendRedirect(path);
            //response.getWriter().append("Served at: ").append(request.getContextPath());
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
