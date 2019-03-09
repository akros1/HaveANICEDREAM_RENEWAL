package trade.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "trade/stateupdate", urlPatterns = { "/trade/stateupdate.do" })
public class TradeStateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession ses = request.getSession(false);

		String tradeNo = request.getParameter("tradeNo");
		String productNo = request.getParameter("productNo");

		TradeService tradeservice = new TradeServiceImpl();
		TradeDTO tradedto = null;
		tradedto = tradeservice.tradenoSelect(Integer.parseInt(tradeNo));

		ProductService proservice = new ProductServiceimpl();
		ProductDTO productdto = null;
		productdto = proservice.productSelect(Integer.parseInt(productNo));

		int tradeStateUpdateResult = 0;
		int productStateUpdateResult = 0;
		int tradeEndResult = 0;
		if (tradedto.getTradeState().equals("거래대기")) {
			tradeStateUpdateResult = tradeservice.tradeStateUpdate("거래중", Integer.parseInt(tradeNo));
			int productState = 2;// 거래중을 표시
			productStateUpdateResult = proservice.productStateUpdate(productState, Integer.parseInt(productNo));
		} else if (tradedto.getTradeState().equals("거래중")) {

			long time = System.currentTimeMillis(); // 현재시간
			MemberDTO memdto = new MemberDTO();
			UserService userservice = new UserServiceImpl();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
			String date = dateFormat.format(new Date(time));
			String msg = "[HaveANiceDream] 거래번호 [" + tradedto.getProductNo() + "]";
			msg = msg + " 물품이 거래완료되었습니다. 이용해주셔서감사합니다.";
			// 구매자
			memdto = userservice.userSelect(tradedto.getUserIdBuy());
			TextDTO text = new TextDTO(tradedto.getUserIdBuy(), tradedto.getTradeNo(), date, msg, memdto.getUserTel());
			// 판매자
			TextDTO text1 = new TextDTO(tradedto.getUserIdSell(), tradedto.getTradeNo(), date, msg,
					productdto.getUserTel());
			tradeStateUpdateResult = tradeservice.tradeDelete("거래완료", tradedto.getTradeNo(), text, text1);
			tradeEndResult = tradeservice.tradeEndDateUpdate(Integer.parseInt(tradeNo));
			int productState = 1;// 거래완료를 표시
			productStateUpdateResult = proservice.productStateUpdate(productState, Integer.parseInt(productNo));
			PointService pointservice = new PointServiceImpl();
			pointservice.pointTradeInc(tradedto.getUserIdSell(), productdto.getProductPrice());

		}

		response.sendRedirect("/HaveANiceDream/trade/list.do");
	}

}
