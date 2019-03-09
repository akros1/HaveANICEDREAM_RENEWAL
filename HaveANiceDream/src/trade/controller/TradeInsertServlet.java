package trade.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import point.service.PointService;
import point.service.PointServiceImpl;
import product.dto.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceimpl;
import text.TextDTO;
import trade.dto.TradeDTO;
import trade.service.TradeService;
import trade.service.TradeServiceImpl;
import user.dto.MemberDTO;

@WebServlet(name = "trade/insert", urlPatterns = { "/trade/insert.do" })
public class TradeInsertServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		ProductService proservice = new ProductServiceimpl();
		HttpSession ses = request.getSession(false);
		String thisProduct = request.getParameter("productNo");

		String viewpath = "";

		// String msg =""; //파라미터에서 받아와서 뿌릴 msg + 로 조합;

		if (ses != null) {
			TradeService tradeservice = new TradeServiceImpl();
			ProductDTO productdto = new ProductDTO();
			MemberDTO user = (MemberDTO) ses.getAttribute("user");
			String userId = user.getUserId();
			productdto = proservice.productSelect(Integer.parseInt(thisProduct));
			// DB에 텍스트 넣을 부분...

			long time = System.currentTimeMillis(); // 현재시간
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
			String date = dateFormat.format(new Date(time));
			String msg = "[HaveANiceDream] 거래번호 [" + productdto.getProductNo() + "]";
			msg = msg + " 물품이 정상적으로 거래신청되었습니다. 거래금액 [ " + productdto.getProductPrice() + " ] ";
			// 구매자
			TextDTO text = new TextDTO(userId, date, msg, user.getUserTel());
			// 판매자
			TextDTO text1 = new TextDTO(productdto.getUserId(), date, msg, productdto.getUserTel());
			TradeDTO tradedto = new TradeDTO(null, null, null, userId, productdto.getUserId(),
					productdto.getProductNo(), "거래대기");
			int rowNum = tradeservice.tradeInsert(tradedto, text, text1);

			PointService pointservice = new PointServiceImpl();
			pointservice.pointTradeDec(tradedto.getUserIdBuy(), productdto.getProductPrice());

			request.setAttribute("viewpath", viewpath);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);

		} else {
			response.sendRedirect("/HaveANiceDream/user/login.html");
		}

	}

}
