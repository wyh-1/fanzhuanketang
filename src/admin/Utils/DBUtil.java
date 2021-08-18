package admin.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {

	private static  String DBDRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static  String DBURL="jdbc:sqlserver://localhost:1433;databaseName=CourseOnline;";
	private static  String DBUSER="sa";
	private static  String DBPASS="123";
	

	/*
	 * 静态代码块，类初始化时加载数据库驱动
	 */
	static {
		try {
			Class.forName(DBDRIVER).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 获取连接
	 */
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(DBURL, DBUSER, DBPASS);

	}

	/*
	 * 释放资源
	 */

	public static void releaseResources(ResultSet resultSet,
			PreparedStatement preparedStatement, Connection connection) {

		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resultSet = null;
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				preparedStatement = null;
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					connection = null;
				}
			}
		}

	}

}
