<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "DaoFactory.ChooseCourse" %>
<%@ page import = "entity.Course" %>
<%@ page  import =  "java.util.List" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课页面</title>
</head>
<body>
	<%
			ChooseCourse chooseCourse = new ChooseCourse();
		    List<Course> courseList = chooseCourse.selectAllCourse();
		    request.setAttribute("courseList",courseList);
		%>
		<table border="1">
			<tr>
				<td>课程ID</td>
				<td>课程名称</td>
				<td>选课</td>
			</tr>
			<c:forEach var="course" items="${courseList}">
				<tr>
					<td>${course.couid}</td>
					<td>${course.counam}</td>
					<td><input type="button" id="addCourse"  onclick="window.location.href='/AddCourseServlet?couid=${course.couid}'"  value="增加课程"></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>