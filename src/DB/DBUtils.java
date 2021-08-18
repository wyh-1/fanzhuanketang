package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=CourseOnline","sa","123");
			/*
			Class.forName("com.mysql.jdbc.Driver");
	   		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (conn == null) {
			throw new SQLException("Cannot get connection.");
		}
		return conn;
	}

	public static void close(Connection conn) {
		if (conn == null)
			return;
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Cannot close connection.");
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Cannot close statement.");
		}

	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("Cannot close resultset.");
		}
	}

}
