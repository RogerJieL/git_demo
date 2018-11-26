package DaoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import jdbc.DBUtils;
import jdbc.SmallUtils;

public class DBOperate {
	// 登陆
	public static String Loginpart(String stunam, String psd) {
		Connection connection = DBUtils.getcon();
		String sql = "select count(*) from stu where stunam=? and stupsd=?";
		String endrs = null;
		PreparedStatement ppst = null;
		ResultSet resultSet = null;
		try {
			ppst = (PreparedStatement) connection.prepareStatement(sql);
			ppst.setString(1, stunam);
			ppst.setString(2, psd);
			resultSet = DBUtils.executeQuery(ppst);
			while (resultSet.next()) {
				int result = resultSet.getInt(1);
				endrs = SmallUtils.getServletValue(result);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close1(connection, ppst, resultSet);
		}
		return endrs;
	}

	// 注册
	public static String RegistPart(String stunam1, String stupsd1) {
		PreparedStatement ppst = null;
		String endrs = null;
		int i = 0;
		String sql = "insert into stu(stuid,stunam, stupsd) values(null,?,?)";
		Connection connection = DBUtils.getcon();
		try {
			ppst = (PreparedStatement) connection.prepareStatement(sql);
			ppst.setString(1, stunam1);
			ppst.setString(2, stupsd1);
			i = DBUtils.executeupdate(ppst);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close2(connection, ppst);
		}
		endrs = SmallUtils.getServletValue(i);
		return endrs;
	}
}
