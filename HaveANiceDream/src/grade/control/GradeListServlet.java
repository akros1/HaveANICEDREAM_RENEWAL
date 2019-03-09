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


@WebServlet(name = "grade/list", urlPatterns = { "/grade/list.do" })
public class GradeListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		HttpSession ses = request.getSession(false);
		String id=request.getParameter("id");
		System.out.println(id);
		
		
		if(ses!=null){

			ArrayList<GradeDTO> gradeSellTypelist = new ArrayList<GradeDTO>();
			ArrayList<GradeDTO> gradeBuyTypelist = new ArrayList<GradeDTO>();
			GradeService gradeservice = new GradeServiceImpl();
			gradeSellTypelist = gradeservice.gradeSelectType(id, "구매평가");
			gradeBuyTypelist = gradeservice.gradeSelectType(id, "판매평가");
			System.out.println(gradeSellTypelist);
			System.out.println(gradeBuyTypelist);
			request.setAttribute("gradeBuyTypelist", gradeBuyTypelist);
			request.setAttribute("gradeSellTypelist", gradeSellTypelist);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/user/user_profile.jsp");
			rd.forward(request, response);
		}
		
	}

}
