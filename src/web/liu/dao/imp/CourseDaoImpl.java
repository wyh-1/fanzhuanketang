package web.liu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.liu.dao.CourseDao;
import web.liu.vo.Course;
import web.liu.vo.LearnPoint;

public class CourseDaoImpl implements CourseDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public CourseDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List findTitle() throws Exception {
		List<Course> list = new ArrayList<Course>();
		try {
			String sql = "select * from Course";
			System.out.println(sql);
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();		
			while(rs.next()){
				Course course = new Course();
				course.setCourseId(rs.getString(1));
				course.setCourseTitle(rs.getString(2));
				course.setCourseTime(rs.getString(3));
				list.add(course);
			}
			System.out.println("查询课程名成功");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("查询课程名失败");
		}
		return list;
	}

}
