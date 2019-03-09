package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "user/delete", urlPatterns = { "/user/delete.do" })
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");

		UserService service = new UserServiceImpl();
		service.userDelete(userId);

		response.sendRedirect("/HaveANiceDream/user/list.do");
	}

}
