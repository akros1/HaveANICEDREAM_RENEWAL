package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardService;
import board.service.BoardServiceImpl;

@WebServlet(name = "board/replywrite", urlPatterns = { "/board/replywrite.do" })
public class BoardReplyWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");

		String viewpath = request.getParameter("url");
		String parentBoardNo = request.getParameter("parentBoardNo");
		String state = request.getParameter("state");

		
		if (parentBoardNo!=null) {
			BoardService service = new BoardServiceImpl();
			BoardDTO parentBoardDTO = service.boardRead(Integer.parseInt(parentBoardNo));
			request.setAttribute("parentBoardNo", parentBoardNo);
			request.setAttribute("parentBoardDTO", parentBoardDTO);
		}
		request.setAttribute("viewpath", viewpath);
		request.setAttribute("state", state);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
	}



}
