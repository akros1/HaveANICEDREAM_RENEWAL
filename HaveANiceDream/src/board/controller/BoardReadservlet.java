package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import board.dto.BoardDTO;
import board.service.BoardService;
import board.service.BoardServiceImpl;

/**
 * Servlet implementation class BoardReadservlet
 */
@WebServlet(name = "board/read", urlPatterns = { "/board/read.do" })
public class BoardReadservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		
		

		String viewpath = request.getParameter("url");
		String boardNo = request.getParameter("boardNo");
		BoardService service = new BoardServiceImpl();
		BoardDTO dto = service.boardRead(Integer.parseInt(boardNo));
		
		
		
		request.setAttribute("boardRead", dto);
		request.setAttribute("viewpath", viewpath);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
	}

}
