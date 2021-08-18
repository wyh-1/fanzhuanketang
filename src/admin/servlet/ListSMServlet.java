package admin.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.bean.Student_Monitor;
import admin.dao.StudentMonitorDAO;

public class ListSMServlet extends HttpServlet {
	public ListSMServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int pageNo = 1;
		StudentMonitorDAO userdao=new StudentMonitorDAO();
		List<Student_Monitor> lists=new ArrayList<Student_Monitor>();
		String pageno=request.getParameter("pageNos");
		String type=request.getParameter("type");
		if(pageno != null){
		pageNo=Integer.parseInt(pageno);
		}
		try {
			lists=userdao.ListMonitor(pageNo,type);
			int recordCount=userdao.getPage(type);
			request.setAttribute("recordCount", recordCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("type", type);
		request.setAttribute("listss", lists);
		request.setAttribute("pageNos", pageNo);
		request.getRequestDispatcher("/admin/Monitor.jsp").forward(request, response);
	}

}
