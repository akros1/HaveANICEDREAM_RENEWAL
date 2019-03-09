package user.block.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.block.dto.BlockDTO;
import user.block.service.BlockService;
import user.block.service.BlockServiceImpl;

@WebServlet(name = "user/block/list", urlPatterns = { "/user/block/list.do" })
public class BlockListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BlockService service = new BlockServiceImpl();
		ArrayList<BlockDTO> blocklist = service.blockList();

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String viewpath = "../user/blacklist_page.jsp";	

		request.setAttribute("viewpath", viewpath);
		request.setAttribute("blocklist", blocklist);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
