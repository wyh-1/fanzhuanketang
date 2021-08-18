package HomeworkManage.Teacher;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ADD {
	public  Connection getConnection() throws ClassNotFoundException, SQLException
	{
	String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
	String connectDB="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=CourseOnline";//数据源注意IP地址和端口号，数据库名字！！！
	String user="sa";//你自己创建的用户名字和密码！！！！！！！！！！！！
	String password="abcd@1234";
		Class.forName(JDriver);
		Connection con=(Connection) DriverManager.getConnection(connectDB,user,password);
		System.out.println("连接数据库成功");
		return con;
	}
	 public void addInfo(String Title,String Overtime,String Type,String Text,String CreateTime,String TeacherID,String CourseID) throws ClassNotFoundException, SQLException{
	 		Connection con=getConnection();
	 		String sql="insert into Homework(Title,Overtime,Type,Text,CreateTime,TeacherID,CourseID)"+"values('"+Title+"','"+Overtime+"','"+Type+"','"+Text+"','"+CreateTime+"','"+TeacherID+"','"+CourseID+"')";
	 		PreparedStatement pstmt=con.prepareStatement(sql);
	 		pstmt.executeUpdate();
	 		pstmt.close();

    }
    public ResultSet select(String TeacherID) throws ClassNotFoundException, SQLException{
        Connection con=getConnection();
        String sql="select ID,Title,Overtime,Type,Text,CreateTime,TeacherID,CourseID from Homework where TeacherID="+TeacherID;
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        return rs;
    }
    /*
    public ResultSet select1(String TeacherID) throws ClassNotFoundException, SQLException{
        Connection con=getConnection();
        String sql="select StudentID,StudentName,CreateTime,HomeworkID,Type,Title,Text from HomeworkAnswer where STeacherID="+TeacherID;
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        return rs;
    }
    */
	public ResultSet select2(String HomeworkID) throws ClassNotFoundException, SQLException{
		Connection con=getConnection();
		String sql="select HomeworkAnswer.ID,HomeworkAnswer.HomeworkID,HomeworkAnswer.StudentID,Student.Name,HomeworkAnswer.CreateTime,Homework.Type,Homework.Title,HomeworkAnswer.Text from HomeworkAnswer, Student, Homework where Homework.ID = HomeworkAnswer.HomeworkID and HomeworkAnswer.StudentID = Student.ID and HomeworkAnswer.HomeworkID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(HomeworkID));
		ResultSet rs=pstmt.executeQuery();
		return rs;
	}
/*
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		ADD a=new ADD();
//		a.addInfo( "9","是", "2017-12-31", "是", "是","2017-12-24","1","1");
	ResultSet rs=a.select("1");
	while(rs.next()){
	
	System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
	}
	}
	*/
}
