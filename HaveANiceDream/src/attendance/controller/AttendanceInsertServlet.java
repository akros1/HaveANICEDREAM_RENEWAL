package attendance.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attendance.dto.AttendanceDTO;
import attendance.service.AttendanceService;
import attendance.service.AttendanceServiceimpl;
import point.dto.PointDTO;
import point.service.PointService;
import point.service.PointServiceImpl;
import user.dto.MemberDTO;

@WebServlet(name = "attendance/insert", urlPatterns = { "/attendance/insert.do" })
public class AttendanceInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession(false);
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		String userId = dto.getUserId();
		int attpoint = 100;

		AttendanceDTO attendance = new AttendanceDTO(userId, attpoint);
		AttendanceService service = new AttendanceServiceimpl();
		int result = service.insert(attendance);

		PointService point = new PointServiceImpl();
		point.pointInsert(new PointDTO(0, userId, null, "출석", attpoint));
		session.setAttribute("attFlag", true);
		response.sendRedirect("/HaveANiceDream/attendance/list.do");

	}

}
