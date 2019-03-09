package trade.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import grade.dto.GradeDTO;
import grade.service.GradeService;
import grade.service.GradeServiceImpl;
import product.dto.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceimpl;
import trade.dto.TradeDTO;
import trade.service.TradeService;
import trade.service.TradeServiceImpl;
import user.dto.MemberDTO;

@WebServlet(name = "trade/list", urlPatterns = { "/trade/list.do" })
public class TradeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession ses = request.getSession(false);

		String viewpath = "";

		if (ses != null) {
			TradeService tradeservice = new TradeServiceImpl();
			TradeDTO tradedto = null;
			MemberDTO user = (MemberDTO) ses.getAttribute("user");
			String userId = user.getUserId();
			ArrayList<TradeDTO> tradelist = tradeservice.tradeSelect(userId);

			if (tradelist != null) {// 트레이드에 해당되는 물품번호를 가지고 product를 받아서 list에
									// 담는 작업!!!
				ArrayList<ProductDTO> productlist = new ArrayList<ProductDTO>();
				ProductDTO productdto = null;
				ProductService proservice = new ProductServiceimpl();
				for (int i = 0; i < tradelist.size(); i++) {
					tradedto = tradelist.get(i);
					productdto = proservice.productSelect(tradedto.getProductNo());

					productlist.add(productdto);

				}
				request.setAttribute("productlist", productlist);
				request.setAttribute("tradelist", tradelist);
			}

			ArrayList<GradeDTO> gradelist = new ArrayList<GradeDTO>();
			GradeService gradeservice = new GradeServiceImpl();
			gradelist = gradeservice.gradeList1();
			request.setAttribute("gradelist", gradelist);

			viewpath = "../Trade/trade_list.jsp";

			request.setAttribute("viewpath", viewpath);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);

		} else {

			response.sendRedirect("/HaveANiceDream/user/login.html");

		}

	}
}
