package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dto.MemberDTO;
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "user/updatepass", urlPatterns = { "/user/updatepass.do" })
public class UserPassUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		
		HttpSession session = request.getSession();
		String userId = ((MemberDTO)session.getAttribute("user")).getUserId();
		
		UserService service = new UserServiceImpl();
		int res = service.userUpdatePass(userId, oldPass, newPass);
		
		response.sendRedirect("/HaveANiceDream/user/select.do?state=SHOWMYPAGE&userId="+userId);
	}

}
