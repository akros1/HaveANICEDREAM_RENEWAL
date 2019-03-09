package blame.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import blame.dto.BlameDTO;
import blame.service.BlameService;
import blame.service.BlameServiceimpl;

@WebServlet(name = "blame/select", urlPatterns = { "/blame/select.do" })
public class BlameSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int blameNo = Integer.parseInt(request.getParameter("blameNo"));
		//System.out.println(blameNo);
		BlameService service = new BlameServiceimpl();
		BlameDTO dto = service.select(blameNo);
		
		JSONObject json = new JSONObject();
		json.put("blameNo", dto.getBlameNo());
		json.put("blameTitle", dto.getBlameTitle());
		json.put("blameContent", dto.getBlameContent());
		json.put("blamefile", dto.getAttachedFile());
		json.put("blameDate", dto.getBlameDate().toString());
		
		  PrintWriter pw = response.getWriter();
	         pw.println(json.toJSONString());
	         
	}

}
