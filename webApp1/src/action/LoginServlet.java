package action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoFactory.DBOperate;
/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// doGet(request, response);
		// System.out.println("登录成功!!!");
		String stunam = "", stupsd = "";
		stunam = request.getParameter("stunam").trim();
		stupsd = request.getParameter("stupsd").trim();
		
		HttpSession session = request.getSession();
		session.setAttribute("stunam", stunam);
		
		// response.sendRedirect("LoginSuc.html");
		// response.getWriter().append("stuid").append(stuid).append(",psd").append(psd);
		// response.sendRedirect("LoginSuc.html");
		
	String	endrs=DBOperate.Loginpart(stunam, stupsd);
		if (endrs.equals("1")) {
			 System.out.println("登录成功!!!");
			response.sendRedirect("LoginSuc.html");
		} else {
			 System.out.println("登录失败!!!");
			response.sendRedirect("LoginFai.html");
		}
	}
}
