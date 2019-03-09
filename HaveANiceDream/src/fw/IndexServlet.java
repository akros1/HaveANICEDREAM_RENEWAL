package fw;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.dto.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceimpl;

@WebServlet(name = "index", urlPatterns = { "/index.html" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		
		ArrayList<ProductDTO>  productlist = null;
		ProductService service = new ProductServiceimpl();
		productlist = service.product_List(null,0,0,null,1,6);
		
		String viewpath = "temp_main_con.jsp";
		
	//
		
		request.setAttribute("productlist", productlist);
		request.setAttribute("viewpath", viewpath);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
	}

}
