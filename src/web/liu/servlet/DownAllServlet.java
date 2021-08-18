package web.liu.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import web.liu.util.PUBConstant;


public class DownAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 得到要下载的文件名
		System.out.println("this is my DownLoadServlet!");
		request.setCharacterEncoding("UTF-8");
		String fileName = request.getParameter("filename"); // 23239283-92489-阿凡达.avi
		String allPath = PUBConstant.saveFilePath;
		File FilePath = new File("");
		String backPath = "";
		
		
//		fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
		// 上传的文件都是保存在upload目录下的子目录当中
//		String fileSaveRootPath = "D:/uploadFile/upload";
		// 通过文件名找出文件的所在目录
		String path = findFileSavePathByFileName(new File(allPath),fileName, allPath,FilePath,backPath);
		// 得到要下载的文件
		File file = new File(path + "\\" + fileName);
		// 如果文件不存在
		if (!file.exists()) {
			request.setAttribute("message", PUBConstant.FileErrorThreeMessage);
			request.getRequestDispatcher("/upload/message.jsp").forward(request,
					response);
			return;
		}
		// 处理文件名
		String realname = fileName.substring(fileName.indexOf("_") + 1);
		// 设置响应头，控制浏览器下载该文件
		response.setHeader("content-disposition", "attachment;filename="
				+ URLEncoder.encode(realname, "UTF-8"));
		// 读取要下载的文件，保存到文件输入流
		FileInputStream in = new FileInputStream(path + "\\" + fileName);
		// 创建输出流
		OutputStream out = response.getOutputStream();
		// 创建缓冲区
		byte buffer[] = new byte[1024];
		int len = 0;
		// 循环将输入流中的内容读取到缓冲区当中
		while ((len = in.read(buffer)) > 0) {
			// 输出缓冲区的内容到浏览器，实现文件下载
			out.write(buffer, 0, len);
		}
		// 关闭文件输入流
		in.close();
		// 关闭输出流
		out.close();
	}

	/**
	 * @Method: findFileSavePathByFileName
	 * @Description: 通过文件名和存储上传文件根目录找出要下载的文件的所在路径
	 * @Anthor:
	 * @param filename
	 *            要下载的文件名
	 * @param saveRootPath
	 *            上传文件保存的根目录
	 *  @param path
	 *  @param FilePath
	 * @return 要下载的文件的存储目录
	 */
	public String findFileSavePathByFileName(File file,String filename,
			String saveRootPath,File path,String FilePath) {
		if (!file.isFile()) {
			// 列出该目录下的所有文件和目录
			File files[] = file.listFiles();
			// 遍历files[]数组
			if (files != null) {
				for (File f : files) {
					// 递归
					path = f;
					FilePath = findFileSavePathByFileName(f, filename,saveRootPath,path,FilePath);
					System.out.println(FilePath);
				}
			}
			
		}else {

			String realName = file.getName();
			boolean boo = filename.equals(realName);
			if(boo){
				System.out.println(path);
				String ss = path.toString();
				FilePath = StringUtils.substringBeforeLast(ss,"\\");
				return FilePath;
			}
		}
		return FilePath;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
