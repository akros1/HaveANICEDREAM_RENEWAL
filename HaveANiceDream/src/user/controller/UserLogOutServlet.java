package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dto.MemberDTO;
import user.service.UserServiceImpl;

@WebServlet(name = "user/logout", urlPatterns = { "/user/logout.do" })
public class UserLogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null){
			MemberDTO user = (MemberDTO) session.getAttribute("user");
			new UserServiceImpl().userUpdateLoginTime(user.getUserId());

			String flag = ""; 
			
			if ((boolean) session.getAttribute("attFlag")) {
				flag = "T";
			} else {
				flag = "F";
			}
			
			Cookie cookie = new Cookie("attFlag", flag);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			
			session.invalidate();
		}
		
		response.sendRedirect("/HaveANiceDream/main/index.html");
	}

}
