package web.liu.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConverPPTFileToImageUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import web.liu.factory.DAOFactory;
import web.liu.util.PUBConstant;
import web.liu.vo.Course;
import web.liu.vo.CourseWare;

//@WebServlet("/fanzhuanketang/UploadHandleServlet")
public class UploadHandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//取得教师或者学生的id
        request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
        String upUserId = (String)session.getAttribute("userid");
		Integer usertype = (Integer)session.getAttribute("usertype");
		if (usertype == null || !usertype.equals(1)) {
			response.sendRedirect("/fanzhuanketang/index");
		} else {
            String savePath = PUBConstant.saveFilePath;  //上传文件路径
            String tempPath = PUBConstant.tempFilePath;  //临时路径
            CourseWare courseWare = new CourseWare();

            courseWare.setTeacherID(upUserId);     //上传者Id


            File tmpFile = new File(tempPath);
            if (!tmpFile.exists()) {
                // 创建临时目录
                tmpFile.mkdir();
            }

            // 消息提示
            String message = "";
            try {
                // 使用Apache文件上传组件处理文件上传步骤：
                // 1、创建一个DiskFileItemFactory工厂
                DiskFileItemFactory factory = new DiskFileItemFactory();
                // 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
                factory.setSizeThreshold(1024 * 100);// 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
                // 设置上传时生成的临时文件的保存目录
                factory.setRepository(tmpFile);
                // 2、创建一个文件上传解析器
                ServletFileUpload upload = new ServletFileUpload(factory);
                // 监听文件上传进度
                upload.setProgressListener(new ProgressListener() {
                    public void update(long pBytesRead, long pContentLength,
                                       int arg2) {
                        System.out.println("文件大小为：" + pContentLength + ",当前已处理："
                                + pBytesRead);
                        /**
                         * 文件大小为：14608,当前已处理：4096 文件大小为：14608,当前已处理：7367
                         * 文件大小为：14608,当前已处理：11419 文件大小为：14608,当前已处理：14608
                         */
                    }
                });
                // 解决上传文件名的中文乱码
                upload.setHeaderEncoding("UTF-8");
                // 3、判断提交上来的数据是否是上传表单的数据
                if (!ServletFileUpload.isMultipartContent(request)) {
                    // 按照传统方式获取数据
                    return;
                }

                // 设置上传单个文件的大小的最大值，目前是设置为1024*1024*10字节，也就是10MB
                upload.setFileSizeMax(1024 * 1024 * 10);
                // 设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为20MB
                upload.setSizeMax(1024 * 1024 * 20);
                // 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
                List<FileItem> list = upload.parseRequest(request);

                int i = 1;
                for (FileItem item : list) {
                    // 如果fileitem中封装的是普通输入项的数据
                    if (item.isFormField()) {
                        String name = item.getFieldName();
                        // 解决普通输入项的数据的中文乱码问题
                        String value = item.getString("UTF-8");
                        // value = new String(value.getBytes("iso8859-1"),"UTF-8");
                        if (i == 1) {
                            courseWare.setCourseID(value);
                        } else if (i == 2) {
                            courseWare.setLearnPointID(value);
                        } else if (i == 3) {
                            courseWare.setFileDescribe(value);
                        }
                        i++;
                        System.out.println(name + "=" + value);
                    } else {// 如果fileitem中封装的是上传文件
                        // 得到上传的文件名称，
                        String filename = item.getName();
                        System.out.println(filename);
                        if (filename == null || filename.trim().equals("")) {
                            continue;
                        }
                        // 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
                        // c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                        // 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                        filename = filename
                                .substring(filename.lastIndexOf("\\") + 1);
                        // 得到上传文件的扩展名
                        String fileExtName = filename.substring(filename
                                .lastIndexOf(".") + 1);
                        fileExtName = fileExtName.toLowerCase();
                        // 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
                        System.out.println("上传的文件的扩展名是：" + fileExtName);
                        // 获取item中的上传文件的输入流
                        InputStream in = item.getInputStream();

                        List<Course> titleList = new ArrayList<Course>();
                        try {
                            titleList = DAOFactory.getCourseDaoInstance().findTitle();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        for (Course cou : titleList) {
                            if (cou.getCourseId().equals(courseWare.getCourseID())) {
                                savePath = savePath + "/fanzhuanketang/" + cou.getCourseCode();
                                courseWare.setFileExtName(cou.getCourseCode());
                            }
                        }

                        // 得到文件的保存目录
                        String realSavePath = makePath(filename, savePath);
                        // 得到文件保存的名称
                        String saveFilename = makeFileName(filename);
                        Date date = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        String upDate = sdf.format(date);
                        courseWare.setFileWareType(fileExtName);
                        courseWare.setFileTitle(saveFilename);
                        courseWare.setFilePath(realSavePath);
                        courseWare.setCreateTime(upDate);

                        DAOFactory.getCourseWareDaoInstance().insertFile(courseWare);
                        //					DAOFactory.getIAllFileDAOInstance().insertFile(allFile);
                        // 创建一个文件输出流
                        FileOutputStream out = new FileOutputStream(realSavePath
                                + "\\" + saveFilename);
                        System.out.println("保存路径：" + realSavePath + "\\" + saveFilename);
                        // 创建一个缓冲区
                        byte buffer[] = new byte[1024];
                        // 判断输入流中的数据是否已经读完的标识
                        int len = 0;
                        // 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                        while ((len = in.read(buffer)) > 0) {
                            // 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\"
                            // + filename)当中
                            out.write(buffer, 0, len);
                        }
                        // 关闭输入流
                        in.close();
                        // 关闭输出流
                        out.close();
                        // 删除处理文件上传时生成的临时文件
                        // item.delete();

                        do  {
                            if (fileExtName.equals("ppt") || fileExtName.equals("pptx")) {
                                //PPT调用示例
                                //Map<String,Object> map=ConverPPTFileToImageUtil.converPPTtoImage("D:\\QQ\\第1章ppt.ppt", "D:\\QQ\\pptimgs\\", "jpg");
                                //PPTX调用示例

                                String targetDir = this.getServletContext().getRealPath("/") + "ppt\\pptimgs\\" + saveFilename.substring(0, saveFilename.lastIndexOf(".")) + "\\";
                                if (!new File(targetDir).mkdirs()) break;

                                Map<String,Object> map;
                                if (fileExtName.equals("pptx")){
                                    map = ConverPPTFileToImageUtil.converPPTXtoImage(realSavePath
                                            + "\\" + saveFilename, targetDir, "jpg");
                                } else {
                                    map = ConverPPTFileToImageUtil.converPPTtoImage(realSavePath
                                            + "\\" + saveFilename, targetDir, "jpg");
                                }

                                boolean converReturnResult=(Boolean) map.get("converReturnResult");
                                System.out.println("converReturnResult:"+converReturnResult);
                                if(converReturnResult){//如果全部转换成功,则为true;如果有一张转换失败,则为fasle
                                    List<String> imgNames=(List<String>) map.get("imgNames");
                                    for (String imgName : imgNames) {
                                        System.out.println(imgName);
                                    }
                                }
                            }
                        } while (false);

                        message = PUBConstant.SuccessMessage;
                    }
                }
            } catch (FileUploadBase.FileSizeLimitExceededException e) {
                e.printStackTrace();
                request.setAttribute("message", PUBConstant.FileErrorOneMessage);
                request.getRequestDispatcher("/upload/message.jsp").forward(request,
                        response);
                return;
            } catch (FileUploadBase.SizeLimitExceededException e) {
                e.printStackTrace();
                request.setAttribute("message", PUBConstant.FileErrorTwoMessage);
                request.getRequestDispatcher("/upload/message.jsp").forward(request,
                        response);
                return;
            } catch (Exception e) {
                message = PUBConstant.FailMessage;
                e.printStackTrace();
            }
            request.setAttribute("message", message);
            request.getRequestDispatcher("/upload/message.jsp").forward(request, response);
        }
	}

	/**
	 * @Method: makeFileName
	 * @Description: 生成上传文件的文件名，文件名以：date+"_"+文件的原始名称
	 * @Anthor:
	 * @param filename
	 *            文件的原始名称
	 * @return date+"_"+文件的原始名称
	 */
	private String makeFileName(String filename) { // 2.jpg
		// 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String time = sdf.format(date);
		
//		return UUID.randomUUID().toString() + "_" + filename;
		return time+ "_" + filename;

	}

	/**
	 * 为防止一个目录下面出现太多文件，把撒谎那个穿的文件分类存储
	 * 
	 * @Method: makePath
	 * @Description:
	 * @Anthor:
	 *
	 * @param filename
	 *            文件名，要根据文件名生成存储目录
	 * @param savePath
	 *            文件存储路径
	 *         
	 * @return 新的存储目录
	 */
	private String makePath(String filename, String savePath) {
		//把文件后缀名变为小写
//		filename = StringUtils.substringBeforeLast(filename,".");
		String dir =savePath;
//
//		boolean dataBoo = PUBConstant.DataBaseCourse.contains(filename);
//		boolean secBoo = PUBConstant.XinXiGaiLunCourse.contains(filename);
//		boolean javaBoo = PUBConstant.JavaCourse.contains(filename);
//		boolean jspBoo = PUBConstant.JspCourse.contains(filename);
//		
//		if(dataBoo){
//			dir = savePath + "/fanzhuanketang/" + PUBConstant.databaseDir; // 数据库
//			allFile.setFileExtName(PUBConstant.databaseDir);
//		}
//		if(secBoo){
//			dir = savePath + "/fanzhuanketang/" + PUBConstant.securitybaseDir; // 信息概论
//			allFile.setFileExtName(PUBConstant.securitybaseDir);
//		}
//		if(javaBoo){
//			dir = savePath + "/fanzhuanketang/" + PUBConstant.javabaseDir; // java
//			allFile.setFileExtName(PUBConstant.javabaseDir);
//		}
//		if(jspBoo){
//			dir = savePath + "/fanzhuanketang/" + PUBConstant.jspbaseDir; // jsp
//			allFile.setFileExtName(PUBConstant.jspbaseDir);
//		}
		// File既可以代表文件也可以代表目录
		File file = new File(dir);
		// 如果目录不存在
		if (!file.exists()) {
			// 创建目录
			file.mkdirs();
		}
		return dir;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
