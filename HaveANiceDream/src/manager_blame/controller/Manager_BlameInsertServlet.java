package manager_blame.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blame.dto.BlameDTO;
import blame.service.BlameService;
import blame.service.BlameServiceimpl;
import manager_blame.dto.Manager_BlameDTO;
import manager_blame.service.Manager_BlameService;
import manager_blame.service.Manager_BlameServiceimpl;
import user.dto.MemberDTO;


@WebServlet(name = "manager_blame/insert", urlPatterns = {"/manager_blame/insert.do"})
public class Manager_BlameInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession(false);
		MemberDTO user = (MemberDTO) session.getAttribute("userId");
		//System.out.println(request.getParameter("blameNo"));
		int blameno = Integer.parseInt(request.getParameter("blameNo"));
		//System.out.println(user);
		String userid = request.getParameter("userId");
		String answertitle = request.getParameter("answerTitle");
		String answercontent = request.getParameter("answerContent");
		
		Manager_BlameDTO dto = new Manager_BlameDTO(blameno,userid,answertitle, answercontent);
		Manager_BlameService service = new Manager_BlameServiceimpl();
		int result = service.insert(dto);
		
		BlameService blame = new BlameServiceimpl();
		blame.update(blameno);
		
		
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
	}

	}


