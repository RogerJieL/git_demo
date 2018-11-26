package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoFactory.ChooseCourse;

/**
 * Servlet implementation class AddCourseServlet
 */


public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		int couid =  Integer.parseInt(request.getParameter("couid"));
		HttpSession session = request.getSession();
		ChooseCourse chooseCourse = new ChooseCourse();
		int stuid = chooseCourse.findIdByName(session.getAttribute("stunam").toString());
		chooseCourse.addCourse(stuid, couid);
		out.print("<script language='javascript'>alert('选择课程成功');window.location.href='stuChooseClass.jsp';</script>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
