package DaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import entity.Course;
import jdbc.*;

public class ChooseCourse {
	
	public List<Course> selectAllCourse() {
        ResultSet resultSet;
        Connection connection =DBUtils.getcon() ;
        String sql = "select * from Course";
        List<Course> courseList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = DBUtils.executeQuery(preparedStatement);
            while (resultSet.next()) {
                Course course = new Course();
                course.setCouid(resultSet.getInt("couid"));
                course.setCounam(resultSet.getString("counam"));
                courseList.add(course);
            }
           DBUtils.close1(connection, preparedStatement, resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return courseList;
    }
	public int findIdByName(String stunam) {
		ResultSet resultSet;
		@SuppressWarnings("null")
		int stuid = (Integer) null;
		Connection connection =DBUtils.getcon() ;
		String sql = "select stuid from stu where stuam = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = DBUtils.executeQuery(preparedStatement);
			if(resultSet != null) {
				stuid = resultSet.getInt("stuid");
			}
			DBUtils.close1(connection, preparedStatement, resultSet);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return stuid;
	}
	
	public void addCourse(int stuid, int couid) {
		Connection connection =DBUtils.getcon() ;
		String sql = "insert into stuidcouidscore(couid,stuid) values(?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			DBUtils.executeupdate(preparedStatement);
	        DBUtils.close2(connection, preparedStatement);

		} catch (SQLException e) {
			e.printStackTrace();
	}
		
}
}
