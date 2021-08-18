package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
	String connectDB="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=CourseOnline";//数据源注意IP地址和端口号，数据库名字！！！databaseName=CourseOnline;";
    private static final String DBUSER="sa";
    private static final String DBPASSWORD="123";

    private Connection connection;

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DatabaseConnection() throws SQLException {
        this.connection = DriverManager.getConnection(connectDB, DBUSER, DBPASSWORD);
    }

    public Connection getConnection()  {
        return this.connection;
    }

    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
