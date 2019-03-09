package attendance.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attendance.service.AttendanceService;
import attendance.service.AttendanceServiceimpl;
import user.dto.MemberDTO;

@WebServlet(name = "attendance/list", urlPatterns = { "/attendance/list.do" })
public class AttendanceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");

		HttpSession session = req.getSession(false);
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		String userid = dto.getUserId();
		
		AttendanceService service = new AttendanceServiceimpl();
		ArrayList<Date> list = service.list(userid);
		ArrayList<String> day = new ArrayList<String>();

		if (list!= null) {
			SimpleDateFormat format = new SimpleDateFormat("d");
			for (int i = 0; i < list.size(); i++) {
				day.add(format.format(list.get(i)));
			}
		} 
		
		String viewpath = "";
		viewpath = "../attendance/project_calender.jsp";
		req.setAttribute("attdate", day);
		req.setAttribute("viewpath", viewpath);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(req, res);
	}

}
