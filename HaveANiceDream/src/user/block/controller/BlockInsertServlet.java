package user.block.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.block.dto.BlockDTO;
import user.block.service.BlockService;
import user.block.service.BlockServiceImpl;

@WebServlet(name = "user/block/insert", urlPatterns = { "/user/block/insert.do" })
public class BlockInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userId = (String) request.getParameter("userId");
		
		BlockService service = new BlockServiceImpl();
		service.blockInsert(new BlockDTO(userId, "관리자차단", null));
		
		response.sendRedirect("/HaveANiceDream/user/list.do");
	}

}
