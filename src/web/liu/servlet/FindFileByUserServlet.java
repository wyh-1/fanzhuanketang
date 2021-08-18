package web.liu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.liu.factory.DAOFactory;
import web.liu.util.PUBConstant;
import web.liu.vo.AllFile;
import web.liu.vo.CourseWare;


public class FindFileByUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome to the FindFileByUserServlet");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String dataBasePath = "0";
		// 得到要上传者的名字
		List<CourseWare> list = new ArrayList<CourseWare>();
		List<CourseWare> nameList = new ArrayList<CourseWare>();

		String teacherID = request.getParameter("userName"); // 23239283-92489-阿凡达.avi
//		AllFile allFile = new AllFile();
//		allFile.setUpUserName(upUserName);
		CourseWare cou = new CourseWare();
		cou.setTeacherID(teacherID);
		try {
//			list = DAOFactory.getIAllFileDAOInstance().findByName(allFile);
//			nameList = DAOFactory.getIAllFileDAOInstance().findUserName();
			
			list = DAOFactory.getCourseWareDaoInstance().findByName(cou);
			nameList = DAOFactory.getCourseWareDaoInstance().findUserName();

            // 存储要下载的文件名
            Map<String, String> dataBaseMap = new HashMap<String, String>(); // 课程

			for (CourseWare af : list) {
				dataBasePath = af.getFilePath();
                // File既可以代表一个文件也可以代表一个目录
                if (!dataBasePath.equals("0")) {
                    String filename = af.getFileTitle();
                    String realName = filename.substring(
                            filename.indexOf("_") + 1);
                    dataBaseMap.put(filename, realName);
                }
			}

            request.setAttribute("dataBasePath", dataBasePath);
            request.setAttribute("dataBaseMap", dataBaseMap);
			request.setAttribute("teacherID", teacherID);
			request.setAttribute("nameList", nameList);

			// // 将Map集合发送到listfile.jsp页面进行显示
			// request.setAttribute("fileNameMap", fileNameMap);
			request.getRequestDispatcher("/upload/findByUser.jsp").forward(request,
					response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
