package user.block.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.block.service.BlockService;
import user.block.service.BlockServiceImpl;

@WebServlet(name = "user/block/delete", urlPatterns = { "/user/block/delete.do" })
public class BlockDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userId = (String) request.getParameter("userId");
		String pageType = (String) request.getParameter("pageType");

		BlockService service = new BlockServiceImpl();
		service.blockDelete(userId);

		if (pageType.equals("userlist")) {
			response.sendRedirect("/HaveANiceDream/user/list.do");
		} else {
			response.sendRedirect("/HaveANiceDream/user/block/list.do");
		}
	}

}
