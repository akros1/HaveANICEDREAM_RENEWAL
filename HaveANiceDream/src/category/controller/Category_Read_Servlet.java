package category.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import category.service.CategoryServiceimpl;
import category.dto.CategoryDTO;
import category.dto.CategoryDetailDTO;
import category.service.CategoryService;


@WebServlet(name = "category/read", urlPatterns = { "/category/read.do" })
public class Category_Read_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //카테고리(대분류)읽어오는 부분. 
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		CategoryService service = new CategoryServiceimpl();		
		ArrayList<CategoryDTO> category_list  = service.categoryList(null);
		String viewpath = "../product/enroll_Sell.jsp";

		request.setAttribute("viewpath", viewpath);
		request.setAttribute("category_list", category_list);
	 
	 
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
