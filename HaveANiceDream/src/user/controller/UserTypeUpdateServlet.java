package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "user/updatetype", urlPatterns = { "/user/updatetype.do" })
public class UserTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userId = request.getParameter("userId");
		String userType = request.getParameter("userType");

		UserService service = new UserServiceImpl();
		service.userUpdateType(userId, userType);

		response.sendRedirect("/HaveANiceDream/user/list.do");

		//response.getWriter().println("UserTypeUpdateServlet");

	}

}
