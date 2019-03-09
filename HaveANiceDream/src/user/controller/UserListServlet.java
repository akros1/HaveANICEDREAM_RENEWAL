package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dto.MemberDTO;
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "user/list", urlPatterns = { "/user/list.do" })
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		ArrayList<MemberDTO> userlist = null;

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		int searchType = 0;

		String searchCondi = request.getParameter("searchCondi");

		if (searchCondi == null || searchCondi.equals("")) {
			searchCondi = null;
		} else {
			searchType = Integer.parseInt(request.getParameter("searchType"));
		}
		
		userlist = service.userList(searchType, searchCondi);

		String viewpath = "../user/user_list.jsp";

		request.setAttribute("viewpath", viewpath);
		request.setAttribute("userlist", userlist);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);

	}

}
