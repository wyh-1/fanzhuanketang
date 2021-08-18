package web.liu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	public static Connection getConnection() {
		// 得到数据连接
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=CourseOnline";// 数据源注意IP地址和端口号，数据库名字！！！
		Connection con = null;
		try {
			Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
			System.out.println("加载引擎成功");
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		System.out.println("数据库驱动成功");
		try {
			String user = "sa";// 你自己创建的用户名字和密码！！！！！！！！！！！！
			String password = "abcd@1234";
			con = DriverManager.getConnection(connectDB, user, password);// 连接数据库对象
			System.out.println("连接数据库成功");
			// 创建表
			// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			System.exit(0);
		}
		return con;
	}

	public static void closeConn(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
