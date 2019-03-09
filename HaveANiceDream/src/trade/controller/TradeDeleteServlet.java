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


@WebServlet(name = "trade/delete", urlPatterns = { "/trade/delete.do" })
public class TradeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession ses = request.getSession(false);
		
		String tradeNo = request.getParameter("tradeNo");
		String productPrice = request.getParameter("productPrice");
		TradeService tradeservice = new TradeServiceImpl();
		ProductService proservice = new ProductServiceimpl();
		
		TradeDTO tradedto = null;
		tradedto = tradeservice.tradenoSelect(Integer.parseInt(tradeNo));
		ProductDTO productdto = new ProductDTO();
		
		productdto = proservice.productSelect(tradedto.getProductNo());
		
		MemberDTO memdto= new MemberDTO();
		
		UserService userservice = new UserServiceImpl();
		
		 long time = System.currentTimeMillis(); //현재시간
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		 String date = dateFormat.format(new Date(time));
		 String msg = "[HaveANiceDream] 거래번호 [" +tradedto.getProductNo()+"]";
		msg= msg+" 물품이 정상적으로 취소되었습니다. ";
		 //구매자
		memdto = userservice.userSelect(tradedto.getUserIdBuy());
		 TextDTO text = new TextDTO(tradedto.getUserIdBuy(),tradedto.getTradeNo() ,date, msg, memdto.getUserTel());
		 //판매자
		 TextDTO text1 = new TextDTO(tradedto.getUserIdSell(), tradedto.getTradeNo(),date, msg, productdto.getUserTel()); 

			int result = 0;
			result = tradeservice.tradeDelete("거래취소", tradedto.getTradeNo(),text,text1);
		
		
		
		PointService pointservice = new PointServiceImpl();
		pointservice.pointTradeInc(tradedto.getUserIdBuy(), Integer.parseInt(productPrice));
		
		response.sendRedirect("/HaveANiceDream/trade/list.do");
	}

}
