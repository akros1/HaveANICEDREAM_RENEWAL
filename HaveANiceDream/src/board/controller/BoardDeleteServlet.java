package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceImpl;


@WebServlet(name = "board/delete", urlPatterns = { "/board/delete.do" })
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		
		BoardService service = new BoardServiceImpl();
		int rowNum = service.boardDelete(Integer.parseInt(boardNo));
		
		response.sendRedirect("/HaveANiceDream/board/list.do");
	}

}
