package board.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dto.BoardDTO;
import board.service.BoardService;
import board.service.BoardServiceImpl;

@WebServlet(name = "boarder/insert", urlPatterns = { "/board/insert.do" })
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String saveFolder = "/uploadresources/board";
		String encType = "utf-8";
		int size = 5 * 1024 * 1024;// (5mb)
		String realPath = "";
		
		ServletContext context = getServletContext();
		realPath = context.getRealPath(saveFolder);

		MultipartRequest multipartRequest = new MultipartRequest(request, realPath, size, encType, new DefaultFileRenamePolicy());

		String userId = multipartRequest.getParameter("userId");
		String boardTitle = multipartRequest.getParameter("boardTitle");
		String boardContent = multipartRequest.getParameter("boardContent");
		String boardType1 = multipartRequest.getParameter("boardType1");
		System.out.println(boardType1);
		String boardType2 = multipartRequest.getParameter("boardType2");
		String parentBoardNo = request.getParameter("parentBoardNo");
		

		String fileName = null;

		@SuppressWarnings("unchecked")
		Enumeration<String> files = multipartRequest.getFileNames();
		if (files.hasMoreElements()) {
			String file = files.nextElement();
			fileName = multipartRequest.getFilesystemName(file);
			if (fileName == null){
				fileName = "board-no-img.png";
			}
		}
		BoardDTO boardwrite = null;
		if(parentBoardNo==null){
			boardwrite = new BoardDTO(userId, boardTitle, boardContent, "답변대기", 0, 0, 0, 0, fileName, boardType1, boardType2);
		}else{
			boardwrite = new BoardDTO(userId,"RE : "+boardTitle, boardContent, "답변완료", 0, Integer.parseInt(parentBoardNo), 0, 0, fileName, boardType1, boardType2);
		}
		

		
		BoardService service = new BoardServiceImpl();
		int res = service.boardInsert(boardwrite);

		if (res > 0) {
			
			response.sendRedirect("/HaveANiceDream/board/list.do");
			
		} else {

			String viewpath = "../board/board_write.jsp";

			request.setAttribute("viewpath", viewpath);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		}
	} 

}