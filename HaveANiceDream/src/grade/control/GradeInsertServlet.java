package grade.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import sms.SMSSendMethod;
import text.TextDTO;
import trade.dto.TradeDTO;
import trade.service.TradeService;
import trade.service.TradeServiceImpl;
import user.dto.MemberDTO;


@WebServlet(name = "grade/insert", urlPatterns = { "/grade/insert.do" })
public class GradeInsertServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		HttpSession ses = request.getSession(false);
		String productNo=request.getParameter("productNo");
		String tradeNo=request.getParameter("tradeNo");
		String state=request.getParameter("state");
		String gradeContent = request.getParameter("gradeContent");
		String grade = request.getParameter("group");
		
		TradeService tradeservice = new TradeServiceImpl();
		TradeDTO tradedto = null;
		tradedto = tradeservice.tradenoSelect(Integer.parseInt(tradeNo));
		
		
		int tradeStateUpdateResult = 0;

		int result = 0;
		String viewpath="";	
		String gradeType="";
		if(ses!=null){
			MemberDTO user = (MemberDTO) ses.getAttribute("user");
			String userId= user.getUserId();
			
			if(state.equals("1")){
				gradeType= "판매평가";
				GradeDTO gradewrite = new GradeDTO(null, tradedto.getUserIdSell(), Integer.parseInt(tradeNo), grade, gradeType, gradeContent, null,tradedto.getUserIdBuy());
				GradeService gradeservice = new GradeServiceImpl();
				result = gradeservice.gradeInsert(gradewrite);
				
				tradeStateUpdateResult = tradeservice.tradeStateUpdate("댓글완료1", Integer.parseInt(tradeNo));
			}else if(state.equals("2")){
				gradeType= "구매평가";
				GradeDTO gradewrite = new GradeDTO(null, tradedto.getUserIdBuy(), Integer.parseInt(tradeNo), grade, gradeType, gradeContent, null,tradedto.getUserIdSell());
				GradeService gradeservice = new GradeServiceImpl();
				result = gradeservice.gradeInsert(gradewrite);
				
				tradeStateUpdateResult = tradeservice.tradeStateUpdate("댓글완료2", Integer.parseInt(tradeNo));
			}else if(state.equals("3")){
				gradeType= "판매평가";
				GradeDTO gradewrite = new GradeDTO(null, tradedto.getUserIdSell(), Integer.parseInt(tradeNo), grade, gradeType, gradeContent, null,tradedto.getUserIdBuy());
				GradeService gradeservice = new GradeServiceImpl();
				result = gradeservice.gradeInsert(gradewrite);
				
				tradeStateUpdateResult = tradeservice.tradeStateUpdate("댓글완료3", Integer.parseInt(tradeNo));
			}else if(state.equals("4")){
				gradeType= "구매평가";
				GradeDTO gradewrite = new GradeDTO(null, tradedto.getUserIdBuy(), Integer.parseInt(tradeNo), grade, gradeType, gradeContent, null,tradedto.getUserIdSell());
				GradeService gradeservice = new GradeServiceImpl();
				result = gradeservice.gradeInsert(gradewrite);
				
				tradeStateUpdateResult = tradeservice.tradeStateUpdate("댓글완료4", Integer.parseInt(tradeNo));
			}
			 
			

		}
		
	}

}
