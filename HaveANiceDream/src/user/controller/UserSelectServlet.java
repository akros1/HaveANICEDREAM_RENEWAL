package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import user.dto.MemberDTO;
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "user/select", urlPatterns = { "/user/select.do" })
public class UserSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userId = request.getParameter("userId");

		UserService service = new UserServiceImpl();
		MemberDTO dto = service.userSelect(userId);

		String state = request.getParameter("state");

		if (state.equals("SHOWMYPAGE")) {
			HttpSession session = request.getSession(false);

			String viewpath = "../user/user_detail.jsp";

			request.setAttribute("viewpath", viewpath);
			session.setAttribute("user", dto);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);

		} else if (state.equals("USERLIST")) {
			JSONObject jsonObject = new JSONObject();
			if (dto != null) {
				jsonObject.put("result", "T");

				jsonObject.put("userId", dto.getUserId());

				jsonObject.put("userEmail", dto.getUserEmail());

				jsonObject.put("userName", dto.getUserName());

				jsonObject.put("userZipcode", dto.getUserZipcode());

				jsonObject.put("userAddr", dto.getUserAddr());

				jsonObject.put("userAddrDetail", dto.getUserAddrDetail());

				jsonObject.put("userTel", dto.getUserTel());

				jsonObject.put("userSigdate", dto.getUserSigdate().toString());

				jsonObject.put("userLogType", dto.getUserLogType());

				jsonObject.put("userLastLoginTime", dto.getUserLastLoginTime().toString());

				jsonObject.put("userImage", dto.getUserImage());

				jsonObject.put("pointTotal", dto.getPointTotal() + "");

				jsonObject.put("userType", dto.getUserType());

			} else {
				jsonObject.put("result", "F");
			}

			PrintWriter printWriter = response.getWriter();
			printWriter.println(jsonObject.toJSONString());

		}
	}

}
