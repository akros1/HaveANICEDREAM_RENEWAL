package trade.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import product.dto.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceimpl;
import trade.dto.TradeDTO;
import trade.service.TradeService;
import trade.service.TradeServiceImpl;
import user.dto.MemberDTO;
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "trade/detail", urlPatterns = { "/trade/detail.do" })
public class TradedetailListServlet extends HttpServlet {
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
		productdto=proservice.productSelect(tradedto.getProductNo());
		
		UserService userservice = new UserServiceImpl();
		MemberDTO buyuserdto = null;
		MemberDTO selluserdto = null;
		buyuserdto =userservice.userSelect(tradedto.getUserIdBuy());
		selluserdto =userservice.userSelect(tradedto.getUserIdSell());
		
		String CategoryName= productdto.getCategoryName()+">"+productdto.getCategoryDetailName();


		
		String tradetype = "";
		if(productdto.getTradeType().equals("delivery_trade")){
		tradetype="택배거래";
	    }else if(productdto.getTradeType().equals("trade")){

	    tradetype="직거래";

	    tradetype="직거래";

	    }
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("productImg", productdto.getImageSrc());

		jsonObject.put("CategoryName", CategoryName);

		jsonObject.put("ProductTitle", productdto.getProductTitle());

		jsonObject.put("ProductPrice", productdto.getProductPrice()+ "");

		jsonObject.put("ProductDate", productdto.getProductDate().toString());

		jsonObject.put("ProductName", productdto.getProductName());

		jsonObject.put("ProductNo",productdto.getProductNo()+ "");

		jsonObject.put("TradeType", tradetype);

		jsonObject.put("sellUserId", selluserdto.getUserId());

		jsonObject.put("sellUserTel",selluserdto.getUserTel());

		jsonObject.put("sellUserEmail", selluserdto.getUserEmail());

		jsonObject.put("buyUserId",buyuserdto.getUserId());

		jsonObject.put("buyUserTel", buyuserdto.getUserTel());

		jsonObject.put("buyUserEmail", buyuserdto.getUserEmail());
		
		PrintWriter printWriter = response.getWriter();
		System.out.println(jsonObject);
		printWriter.println(jsonObject.toJSONString());
	}
}
