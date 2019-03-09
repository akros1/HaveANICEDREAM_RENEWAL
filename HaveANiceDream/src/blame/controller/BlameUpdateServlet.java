package blame.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blame.service.BlameService;
import blame.service.BlameServiceimpl;

@WebServlet(name = "blame/update", urlPatterns = { "/blame/update.do" })
public class BlameUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("test");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int blameno = Integer.parseInt(request.getParameter("blameNo"));
		//System.out.println(blameno);
		BlameService service = new BlameServiceimpl();
		service.update(blameno);
		
		response.sendRedirect("/HaveANiceDream/blame/list.do");
	}

}
