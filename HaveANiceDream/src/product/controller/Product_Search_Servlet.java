package product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import category.dto.CategoryDTO;
import category.service.CategoryService;
import category.service.CategoryServiceimpl;
import product.dto.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceimpl;
import user.dto.MemberDTO;

/**
 * Servlet implementation class Product_Search_Servlet
 */
@WebServlet(name = "product_search", urlPatterns = { "/product_search.do" })
public class Product_Search_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int productNo = Integer.parseInt(request.getParameter("productNo"));

		ProductService service = new ProductServiceimpl();
		ProductDTO product = service.productSelect(productNo);
		System.out.println(product);
		ArrayList<String> fileName = service.productSelect_Image(productNo);
		CategoryService service1 = new CategoryServiceimpl();
		ArrayList<CategoryDTO> category_list = service1.categoryList(null);
		String state = request.getParameter("state");
		HttpSession ses = request.getSession(false);
		MemberDTO user = null;
		String viewpath = "";
		// 프로덕트넘버의 값으로

		user = (MemberDTO) ses.getAttribute("user");
		if (ses != null & user != null) {
			String enrollId = product.getUserId();
			if (state.equals("SEARCH")) {
				request.setAttribute("category_list", category_list);
			} else if (user.getUserId().equals(enrollId) & state.equals("BUY")) {
				request.setAttribute("productNo", productNo);
				request.setAttribute("category_list", category_list);
				request.setAttribute("product", product);
				viewpath = "../product/product_edit.jsp";
			} else if (state.equals("BUY")) {
				// System.out.println("서블릿"+product);
				viewpath = "../Trade/trade_popup.jsp";// 팝업이 아닌 경로를 변경... 거기서 다시
				request.setAttribute("productNo", productNo);
				request.setAttribute("category_list", category_list);
				request.setAttribute("product", product);
			}

			request.setAttribute("viewpath", viewpath);

			request.setAttribute("file1", fileName);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("/HaveANiceDream/user/login.html");
		}

		// else로그인화면
		// System.out.println(product);
		// 세팅...

	}

}
