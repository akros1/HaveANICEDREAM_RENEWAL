package point.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import point.dto.PointDTO;
import point.service.PointService;
import point.service.PointServiceImpl;
import user.dto.MemberDTO;

@WebServlet(name = "point/list", urlPatterns = { "/point/list.do" })
public class PointListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// String userId = "leesuj1"; // session에서 가져오기
		HttpSession session = request.getSession(false);
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		String viewpath = null;
		if (user != null) {
			String userId = user.getUserId();

			PointService service = new PointServiceImpl();
			ArrayList<PointDTO> pointlist = service.pointList(userId);
			
			request.setAttribute("pointlist", pointlist);
			
			viewpath = "../point/point_detail.jsp";
		} else {
			viewpath = "temp_main_con.jsp";
		}

		request.setAttribute("viewpath", viewpath);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
	}

}
