package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	private static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url="jdbc:sqlserver://localhost:1433; DatabaseName=CourseOnline";
	private static final String username="sa";
	private static final String password="123";
	private static Connection conn = null;
	public static Connection getConnection() throws Exception{
		try{
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("数据库连接成功！");
		}catch(Exception e){
			throw e;
		}
		return conn;
	}
	@SuppressWarnings("static-access")
	public void close()throws Exception{
		if(this.conn!=null)
		{
			try{
				this.conn.close();
			}catch (Exception e){
				throw e;
			}
		}
	}
	//按照知识点查询数据库中的课件信息
	public static ResultSet select_Study(String study) throws SQLException{
		PreparedStatement pstmt=null;
		String  keWord=study;
		ResultSet rs=null;
		pstmt= conn.prepareStatement("{call PointselectCourse(?)}");
		pstmt.setString(1,keWord);
		rs=pstmt.executeQuery();
		return rs;
	}
	//按照教材查询数据库中的课件信息
	public static ResultSet select_Book(String Book) throws SQLException{
		PreparedStatement pstmt=null;
		String  keWord=Book;
		ResultSet rs=null;
		pstmt= conn.prepareStatement("{call BookselectCourse(?)}");
		pstmt.setString(1,keWord);
		rs=pstmt.executeQuery();
		return rs;
	}
	//插入知识点与教材一一对应
	public static void insert_study(String id,String book,String LearnPoint) throws SQLException{
		PreparedStatement pstmt=null;
		String sql="INSERT INTO LearnPoint(ID,Book,LearnPoint)"+" VALUES(?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, book);
		pstmt.setString(3, LearnPoint);
		pstmt.executeUpdate();
		pstmt.close();
	}
	//显示知识点表所有信息
	public static ResultSet dispAll() throws SQLException{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT * FROM LearnPoint";
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		return rs;
	}
	//删除知识点
	public static void delByNum(String id) throws SQLException{
		PreparedStatement pstmt=null;
		String sql="DELETE FROM LearnPoint WHERE ID=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
	}
}