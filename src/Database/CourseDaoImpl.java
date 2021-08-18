package Database;

import java.util.List;

import com.fanzhuanketang.dao.CourseDao;
import com.fanzhuanketang.po.Course;

import java.util.ArrayList;

import java.sql.*;

public class CourseDaoImpl implements CourseDao {

	@Override
	public boolean insertCourse(Course s) {
	    DatabaseConnection databaseConnection;
        try {
            databaseConnection = new DatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        Connection con = null;
		PreparedStatement pst=null;
		boolean b=false;
		try{
			con=databaseConnection.getConnection();
			System.out.println("3");
			pst=con.prepareStatement("insert into Course values(?,?,?)");
			System.out.println("4！");
			pst.setString(1, s.getID());
			pst.setString(2, s.getTitle());
			pst.setString(3, s.getCourseDate());
			int i=pst.executeUpdate();
			if(i>0){
				b=true;
			}else b= false;
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
            databaseConnection.close();
        }
		return b;
	}
	

	@Override
	public List<Course> selectAllCourseByUserID(int identity, String idNum) {
        List<Course> list=new ArrayList<Course>();
        DatabaseConnection databaseConnection;
        try {
            databaseConnection = new DatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try{
			con=databaseConnection.getConnection();
			System.out.println("1");
            if (identity == 1) {
                //教师登录的话获取一下教师的ID 把2001改成获取的值就好
                pst = con.prepareStatement("select * from Course,TeacherCourse"
                        + " where TeacherCourse.TeacherID=? and TeacherCourse.CourseID=Course.ID");
            } else if (identity == 0) {
                //学生登陆的话改成，其余同理
                pst=con.prepareStatement("select * from Course,StudentCourse"
                    + " where StudentCourse.StudentID=? and StudentCourse.CourseID=Course.ID");
            } else {
                return list;
            }
            pst.setString(1, idNum);
            rs=pst.executeQuery();
			while(rs.next()){
                Course s=new Course();
                s.setID(rs.getString("ID"));
                s.setTitle(rs.getString("Title"));
                s.setCourseDate(rs.getDate("CourseDate").toString());
                list.add(s);
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            databaseConnection.close();
        }
		return list;
	}

    @Override
    public List<Course> selectAllCourseByID(String id) {
        List<Course> list=new ArrayList<Course>();
        DatabaseConnection databaseConnection;
        try {
            databaseConnection = new DatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            con=databaseConnection.getConnection();
            pst=con.prepareStatement("select * from Course where ID=?");
            pst.setString(1, id);
            rs=pst.executeQuery();

            while(rs.next()){
                Course s=new Course();
                s.setID(rs.getString("ID"));
                s.setTitle(rs.getString("Title"));
                s.setCourseDate(rs.getString("CourseDate"));
                list.add(s);
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnection.close();
        }
        return list;
    }

    @Override
    public List<Course> selectAllCourse() {
        List<Course> list=new ArrayList<Course>();
        DatabaseConnection databaseConnection;
        try {
            databaseConnection = new DatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            con=databaseConnection.getConnection();
            pst=con.prepareStatement("select * from Course");
            rs=pst.executeQuery();

            while(rs.next()){
                Course s=new Course();
                s.setID(rs.getString("ID"));
                s.setTitle(rs.getString("Title"));
                s.setCourseDate(rs.getString("CourseDate"));
                list.add(s);
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnection.close();
        }
        return list;
    }

    @Override
	public boolean UpdateCourse(Course s) {
        DatabaseConnection databaseConnection;
        try {
            databaseConnection = new DatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
		Connection con=null;
		PreparedStatement pst=null;
		boolean b=false;
		try{
			con=databaseConnection.getConnection();
			System.out.println("5");
			pst=con.prepareStatement("Update Course set Title=?,CourseDate=? where ID=?");
			System.out.println("5！");
			pst.setString(1, s.getTitle());
			pst.setString(2, s.getCourseDate());
			pst.setString(3, s.getID());
			int i=pst.executeUpdate();
			if(i>0){
				b=true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
            databaseConnection.close();
        }
		return b;
	}

	public boolean deleteCourse(String ID){  //删除
        DatabaseConnection databaseConnection;
        try {
            databaseConnection = new DatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
		Connection con=null;
		PreparedStatement pst=null;
		boolean b=false;
        
        try {
        	String sql = "delete from Course where ID = ?";  //删除的SQL语句，根据ID删除
    		con=databaseConnection.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, ID);
            int count = pst.executeUpdate();
            return count>0?true:false;  //是否删除的判断
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.close();
        }
        return false;
    }
}
