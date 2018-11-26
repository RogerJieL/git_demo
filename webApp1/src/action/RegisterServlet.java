package action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DaoFactory.DBOperate;
/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
//		处理乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String code = (String) request.getSession().getAttribute("checkCode");
		// 得倒插入的数据(用户名 密码 验证码)
		String stunam1 = request.getParameter("stunam1").trim();
		String stupsd1 = request.getParameter("stupsd1").trim();
		String endrs = DBOperate.RegistPart(stunam1, stupsd1);
		String codes=request.getParameter("checkCode").trim();

		boolean aBoolean=false;
		if (codes.equals(code)) {
				aBoolean=true;
		}
		
		if (endrs.equals("1")&&aBoolean) {
			System.out.println("注册成功，请选择重新登录");
			response.sendRedirect("Login.html");
		}
	else { 
			System.out.println("注册失败，请重新注册");
			response.sendRedirect("Register.html");
		}
	}
}
