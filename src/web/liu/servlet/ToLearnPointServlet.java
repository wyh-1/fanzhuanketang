package web.liu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.liu.factory.DAOFactory;
import web.liu.vo.Course;
import web.liu.vo.LearnPoint;

public class ToLearnPointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome to ToLearnPoint!");
		List<LearnPoint> idList = new ArrayList<LearnPoint>();
		List<Course> titleList = new ArrayList<Course>();
		try{
			idList = DAOFactory.getILeranPointDaoInstance().findLeranPoint();
			titleList = DAOFactory.getCourseDaoInstance().findTitle();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		request.setAttribute("idList", idList);
		request.setAttribute("titleList", titleList);
		
		
		request.getRequestDispatcher("/upload/upload.jsp")
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
