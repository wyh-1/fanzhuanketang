package web.liu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.liu.factory.DAOFactory;
import web.liu.util.PUBConstant;
import web.liu.vo.AllFile;
import web.liu.vo.Course;
import web.liu.vo.CourseWare;

/**
 * @ClassName: ListFileServlet
 * @Description: 列出Web系统中所有下载文件
 * @author: 孤傲苍狼
 * @date: 2015-1-4 下午9:54:40
 *
 */
public class ListFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("This is ListFileServlet!");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			String courseName = request.getParameter("courseName");
			String dataBasePath = "0";
			CourseWare courseWare = new CourseWare();
			courseWare.setFileExtName(courseName);
			List<Course> courseList = new ArrayList<Course>();
			List<CourseWare> list = new ArrayList<CourseWare>();
			list = DAOFactory.getCourseWareDaoInstance().findPath(courseWare);
			courseList = DAOFactory.getCourseDaoInstance().findTitle();
			
			for (CourseWare af : list) {
				for(Course cou : courseList){
					if (af.getFileExtName().equals(cou.getCourseCode())) {
						dataBasePath = af.getFilePath();
						courseName = cou.getCourseTitle();
					}
				}
			}

			// 存储要下载的文件名
			Map<String, String> dataBaseMap = new HashMap<String, String>(); // 课程


			// File既可以代表一个文件也可以代表一个目录
			if (!dataBasePath.equals("0")) {

				listfile(new File(dataBasePath), dataBaseMap);
				request.setAttribute("dataBaseMap", dataBaseMap);
			}

			request.setAttribute("dataBasePath", dataBasePath);
			request.setAttribute("courseName", courseName);
			request.setAttribute("courseList", courseList);

			request.getRequestDispatcher("/upload/findByCourse.jsp").forward(request,
					response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @Method: listfile
	 * @Description: 递归遍历指定目录下的所有文件
	 * @Anthor:孤傲苍狼
	 * @param file
	 *            即代表一个文件，也代表一个文件目录
	 * @param map
	 *            存储文件名的Map集合
	 */
	public void listfile(File file, Map<String, String> map) {
		// 如果file代表的不是一个文件，而是一个目录
		if (!file.isFile()) {
			// 列出该目录下的所有文件和目录
			File files[] = file.listFiles();
			// 遍历files[]数组
			if (files != null) {
				for (File f : files) {
					// 递归
					listfile(f, map);
				}
			}
		} else {
			/**
			 * 处理文件名，上传后的文件是以uuid_文件名的形式去重新命名的，去除文件名的uuid_部分
			 * file.getName().indexOf
			 * ("_")检索字符串中第一次出现"_"字符的位置，如果文件名类似于：9349249849-88343-8344_阿_凡_达.avi
			 * 那么file.getName().substring(file.getName().indexOf("_")+1)
			 * 处理之后就可以得到阿_凡_达.avi部分
			 */
			String realName = file.getName().substring(
					file.getName().indexOf("_") + 1);
			// file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
			map.put(file.getName(), realName);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
