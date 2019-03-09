package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "user/idcheck", urlPatterns = { "/user/idcheck.do" })
public class UserIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter printWriter = response.getWriter();

		String userId = request.getParameter("userId");

		UserService service = new UserServiceImpl();
		
		JSONObject jsonObject = new JSONObject();

		if (service.idCheck(userId)) {
			jsonObject.put("data", "T");
		} else {
			jsonObject.put("data", "F");
		}
		
		printWriter.println(jsonObject.toJSONString());

	}

}
