package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import service.UserService;
import service.UserServiceImpl;



@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		switch (type) {
		case "reg":
			reg(request,response);
			break;
		case "login":
			login(request,response);
			break;
		case "resetPwd":
			resetPwd(request,response);
			break;
		case "logout":
			logout(request,response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void reg(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String tel = request.getParameter("tel");
		
		
		if(pwd!=null ) {
			User user = new User();
			user.setUname(uname);
			user.setPwd(pwd);
			user.setTel(tel);
			UserService userService = new UserServiceImpl();
			String info = userService.reg(user);
			if("success".equals(info)) {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print("<body style=\"background-color:rgb(115, 250, 232);text-align:center;\">");
				response.getWriter().println("注册成功，请登录！");
				response.getWriter().print("</body>");
				response.setHeader("refresh", "1;URL=login.jsp");
			} else {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print("<body style=\"background-color:rgb(115, 250, 232);text-align:center;\">");
				response.getWriter().println("注册失败，请重新注册！");
				response.getWriter().print("</body>");
				response.setHeader("refresh", "1;URL=reg.jsp");
			}
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setUname(uname);
		user.setPwd(pwd);
		

	UserService userService = new UserServiceImpl();
		User u = userService.login(user);
		
		
		if(u!=null) {
			response.setContentType("text/html;charset=utf-8");
			response.setHeader("refresh", "1;URL=FuritServlet?type=showAll");
		} else {
			response.setContentType("text/html;charset=utf-8");
			out.print("<body style=\"background-color:rgb(115, 250, 232);text-align:center;\">");
			out.println("登录失败，请重新登录！");
			out.print("</body>");
			response.setHeader("refresh", "2;URL=login.jsp");
		}
		
	}

	private void resetPwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String tel = request.getParameter("tel");
		String pwd = request.getParameter("pwd");
		
	
		if(pwd!=null) {
			User user = new User();
			user.setTel(tel);
			user.setPwd(pwd);
			UserService userService = new UserServiceImpl();
			String info = userService.resetPwd(user);

			if(info.equals("success")) {
				response.setContentType("text/html;charset=utf-8");
				out.print("<body style=\"background-color:rgb(115, 250, 232);text-align:center;\">");
				out.println("密码修改成功，2秒后跳转到登录页面！");
				out.print("</body>");
				response.setHeader("refresh", "2;URL=login.jsp");
			} else {
				response.setContentType("text/html;charset=utf-8");
				out.print("<body style=\"background-color:rgb(115, 250, 232);text-align:center;\">");
				out.println("密码修改失败，请重试！");
				out.print("</body>");
				response.setHeader("refresh", "2;URL=pwdReset.jsp");
			}
		}
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) session.invalidate();
		response.sendRedirect("login.jsp");
	}
}
