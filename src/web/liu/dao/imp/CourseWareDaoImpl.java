package web.liu.dao.imp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import web.liu.dao.CourseWareDao;
import web.liu.vo.AllFile;
import web.liu.vo.CourseWare;

public class CourseWareDaoImpl implements CourseWareDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public CourseWareDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List findByName(CourseWare courseWare) throws Exception {
		
		List<CourseWare> list = new ArrayList<CourseWare>();
		String teacherId = courseWare.getTeacherID();
		try {
			String sql = "select * from Courseware where TeacherID = ? ";
			this.pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, teacherId);// 自动添加单引号
																// （包装后的参数）
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				CourseWare cou = new CourseWare();
				cou.setFileTitle(rs.getString(2));
				cou.setFileWareType(rs.getString(4));
				cou.setFilePath(rs.getString(6));
				cou.setTeacherID(rs.getString(7));
				cou.setFileExtName(rs.getString(10));
//				af.setFilePath(rs.getString(3));
//				af.setFileExtName(rs.getString(4));
//				af.setUpUserName(rs.getString(6));
				list.add(cou);
			}
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return list;
	}

	@Override
	public void insertFile(CourseWare courseWare) throws Exception {
		try {
			String sql = "insert into Courseware values(?,?,?,?,?,?,?,?,?)";
			this.pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, courseWare.getFileTitle());
			pstmt.setString(2, courseWare.getFileDescribe());
			pstmt.setString(3, courseWare.getFileWareType());
			pstmt.setString(4, courseWare.getLearnPointID() == null || courseWare.getLearnPointID().isEmpty() ? null : courseWare.getLearnPointID());
			pstmt.setString(5, courseWare.getFilePath());
			pstmt.setString(6, courseWare.getTeacherID());
			pstmt.setString(7, courseWare.getCourseID());
			pstmt.setTimestamp(8, Timestamp.valueOf(courseWare.getCreateTime()));
			pstmt.setString(9, courseWare.getFileExtName());
			System.out.println(courseWare.getFileTitle() + "\n"
					+ courseWare.getFileDescribe() + "\n"
					+ courseWare.getFileWareType() + "\n"
					+ courseWare.getLearnPointID() + "\n"
					+ courseWare.getFilePath() + "\n"
					+ courseWare.getTeacherID() + "\n"
					+ courseWare.getCourseID() + "\n"
					+ courseWare.getCreateTime() + "\n"
					+ courseWare.getFileExtName() + "\n"
			);
			int num = this.pstmt.executeUpdate();
			if(num > 0){
				System.out.println(sql);
				System.out.println("上传成功");
			}

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("上传失败");
		}

	}

	@Override
	public List findPath(CourseWare courseWare) throws Exception {
		
		List<CourseWare> list = new ArrayList<CourseWare>();
		try {
			String sql = "select DISTINCT Filename,FileExtName from Courseware where FileExtName like ? order by Filename";
			System.out.println(sql);
			this.pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + courseWare.getFileExtName() + "%");// 自动添加单引号
			ResultSet rs = this.pstmt.executeQuery();		
			while(rs.next()){
				CourseWare cou = new CourseWare();
				cou.setFilePath(rs.getString(1));
				cou.setFileExtName(rs.getString(2));
				list.add(cou);
			}
			System.out.println("查询成功");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("查询失败");
		}
		return list;
	}

	@Override
	public List findUserName() throws Exception {
		
		List<CourseWare> list = new ArrayList<CourseWare>();
		try {
			String sql = "select DISTINCT TeacherID from Courseware";
			System.out.println(sql);
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();		
			while(rs.next()){
				CourseWare cou = new CourseWare();
				cou.setTeacherID(rs.getString(1));
				list.add(cou);
			}
			System.out.println("查询上传者成功");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("查询上传者失败");
		}
		return list;
	}

}
