package blame.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blame.service.BlameService;
import blame.service.BlameServiceimpl;

@WebServlet(name = "blame/ajax", urlPatterns = {"/blame/blameajax.do"})
public class BlameNo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		
		int blameno = Integer.parseInt(request.getParameter("blameNo"));
		BlameService service = new BlameServiceimpl();
		if(service.select(blameno) != null){
			HttpSession session = request.getSession();
			printWriter.println("성공");
		}else{
			printWriter.println("실패");
		}
	}

}
