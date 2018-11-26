package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url ="jdbc:mysql://localhost:3306/ll?charactorEncoding=utf-8";
		String user = "root";
		String password = "000000";
	
		Connection conn = null;
		try {
			conn =DriverManager.getConnection(url,user,password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
