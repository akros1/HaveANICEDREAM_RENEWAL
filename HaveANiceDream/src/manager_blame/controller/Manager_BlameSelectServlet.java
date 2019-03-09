package manager_blame.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import manager_blame.dto.Manager_BlameDTO;
import manager_blame.service.Manager_BlameService;
import manager_blame.service.Manager_BlameServiceimpl;
@WebServlet(name = "manager_blame/select1", urlPatterns = { "/manager_blame/select1.do" })
public class Manager_BlameSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		//System.out.println("test");
		int blameno = Integer.parseInt(request.getParameter("blameNo"));
		
		Manager_BlameService service = new Manager_BlameServiceimpl();
		ArrayList<String> dto = service.select(blameno);
		//System.out.println(dto);
		
		JSONObject json = new JSONObject();

		json.put("blameNo", dto.get(0));
		json.put("blameDate", dto.get(1));
		json.put("blameTitle", dto.get(2));
		json.put("blameContent", dto.get(3));
		json.put("answerTitle", dto.get(4));
		json.put("answerContent", dto.get(5));
		json.put("answerDate", dto.get(6));
		
		  PrintWriter pw = response.getWriter();
	         pw.println(json.toJSONString());
	         
	}

}
