package reply.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dto.BoardDTO;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import grade.dto.GradeDTO;
import grade.service.GradeService;
import grade.service.GradeServiceImpl;
import product.dto.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceimpl;
import reply.dto.ReplyDTO;
import reply.service.ReplyService;
import reply.service.ReplyServiceImpl;
import trade.dto.TradeDTO;
import trade.service.TradeService;
import trade.service.TradeServiceImpl;
import user.dto.MemberDTO;

@WebServlet(name = "reply/insert", urlPatterns = { "/reply/insert.do" })
public class ReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession ses = request.getSession(false);

		String boardNo = request.getParameter("boardNo");
		String replyContent = request.getParameter("replyContent");
		String viewpath = "";

		if (ses != null) {
			MemberDTO user = (MemberDTO) ses.getAttribute("user");
			String sesuserId = user.getUserId();
			ReplyService service = new ReplyServiceImpl();
			ReplyDTO replywrite = new ReplyDTO(null, Integer.parseInt(boardNo), replyContent, sesuserId, null);
			int res = service.replyInsert(replywrite);

		} else {

			response.sendRedirect("/HaveANiceDream/user/login.html");

		}

	}

}