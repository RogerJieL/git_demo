package jdbc;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class DBUtils {
	private static String drive = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/student";
	private static String name = "root";
	private static String psd = "123";

	// 1.获取连接
	public static Connection getcon() {
		Connection connection = null;
		try {
			Class.forName(drive);
			connection = (Connection) DriverManager.getConnection(url, name, psd);
		} catch (ClassNotFoundException e) {
			// System.out.println("失败1");
			e.printStackTrace();
		} catch (SQLException e) {
			// System.out.println("失败2");
			e.printStackTrace();
		}
		return connection;
	}

	// 2.1关闭连接1有结果集rs
	public static void close1(Connection connection, PreparedStatement ppst, ResultSet rs) {
		try {
			if (ppst != null) {
				ppst.close();
			}
			if (rs != null) {
				rs.close();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 2.1关闭连接2无结果集rs
	public static void close2(Connection connection, PreparedStatement ppst) {
		try {
			if (ppst != null) {
				ppst.close();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3.1执行查询（select）语句获得结果集
	public static ResultSet executeQuery(PreparedStatement ppst) {
		ResultSet resultSet = null;
		try {
			resultSet = ppst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	// 3.2执行非查询语句获得结果集
	public static int executeupdate(PreparedStatement ppst) {
		int i=0;
		try {
		 i = ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	// 4.通过存储过程进行处理
		public static int executeProduse(Connection con, String str, Object[] obj) {
			try {
				str = "{call " + str + " }";
				System.out.println(str);
				CallableStatement sp = con.prepareCall(str);
				// 为sql赋值
				for (int i = 0; i <= obj.length - 1; i++) {
					sp.setObject(i + 1, obj[i]);
				}
				sp.execute();
				return 1;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("查询失败");
				return 0;
			}
		}
		// 5. 获取数据库操作
		public static PreparedStatement getPreparedStatement(Connection con, String sql, Object[] obj) {
			PreparedStatement pst = null;
			if (con != null) {
				try {
					pst = con.prepareStatement(sql);
					// 为sql赋值
					for (int i = 0; i < obj.length; i++) {
						pst.setObject(i + 1, obj[i]);
						System.out.println(obj[i]);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return pst;
		}
	
}
