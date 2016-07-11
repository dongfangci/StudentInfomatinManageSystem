package jdbc4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn;
	
	private static final String URL = "jdbc:mysql://localhost:3306/test_db";
	private static final String USER = "root";
	private static final String PASSWORD = "3563551";
	
	private DBUtil(){}
	
	static{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		conn = DriverManager.getConnection(URL,USER,PASSWORD);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static Connection getConnection(){
		return conn;
	}
}
