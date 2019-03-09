package product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import category.dto.CategoryDTO;
import category.service.CategoryService;
import category.service.CategoryServiceimpl;
import product.dto.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceimpl;

/**
 * Servlet implementation class Product_List_Servlet
 */
@WebServlet(name = "product_list", urlPatterns = { "/product_list.do" })
public class Product_List_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		 ProductService service= new ProductServiceimpl();
		 CategoryService service1 = new CategoryServiceimpl();
		 String state = request.getParameter("state");
		// System.out.println(state);
		 int categoryNo =0;
		 int categoryDetailNo =0;

		 String title=request.getParameter("title");
		 System.out.println(title);
		 ArrayList<ProductDTO>  productlist = null;
		 ArrayList<CategoryDTO>  category_list = null;
		 String viewpath="";
		 int startCount =1;
		 int endCount =10;
		 String paging =null;
		 paging = request.getParameter("paging");
		// System.out.println("paging"+paging);
		 if(paging!=null){
			 int countPage = 10;
			 int page= Integer.parseInt(paging);
			  startCount = (page - 1) * countPage + 1;  // 21 이 되겠죠
			  endCount = page * countPage;  // 30 이 될 겁니다.
			
			 }
		 if(state.equals("ALL")){
		  productlist = service.product_List(title,categoryNo,categoryDetailNo,null,startCount,endCount);
		//  System.out.println(productlist);
		 // System.out.println(startCount);
		//  System.out.println(endCount);

		  viewpath  = "../product/product_list.jsp";
		 }else if(state.equals("MAIN")){
			 if(title==null){
				 title="";
			 }
			 productlist = service.product_List(title,0,0,null,startCount,endCount);
				
			  viewpath  = "../product/product_list.jsp";
		 }
			 //numberFOrma 예외처리해주어야합니다.
		 else if(state.equals("SEARCH")){
				 if(request.getParameter("categoryNo").equals("선택해주세요")){
					// System.out.println("아무것도 조건없이 검색만했을떄");
					 if(title.equals(null)){
						 title="";
					 }
					 productlist = service.product_List(title,0,0,null,startCount,endCount);
						
					  viewpath  = "../product/product_list.jsp";
				 }else if(request.getParameter("categoryDetailNohidden").equals("선택해주세요")){//첫번쨰거만 입력하고 두번째꺼 안입력햇을ㄸ때
				//		System.out.println("대분류만");
					 categoryNo =Integer.parseInt(request.getParameter("categoryNohidden"));
					 productlist = service.product_List(title,categoryNo,0,null,startCount,endCount);
					// String test= request.getParameter("categoryDetailNo");
					// String test1= request.getParameter("categoryDetailNohidden");
					// System.out.println("서블릿 셀렉트태그로부터 넘어오는값 디테일넘버"+test);
					// System.out.println("서블릿 히든으로부터 넘어오는값"+test1);
					 viewpath  = "../product/product_list.jsp";
				 }else{//정상입력
					// String test= request.getParameter("categoryDetailNo");
					// String test1= request.getParameter("categoryDetailNohidden");
					// System.out.println("서블릿 셀렉트태그로부터 넘어오는값"+test);
					// System.out.println("서블릿 히든으로부터 넘어오는값"+test1);
						System.out.println("대소분류");
					 categoryNo =Integer.parseInt(request.getParameter("categoryNohidden"));
					 categoryDetailNo = Integer.parseInt(request.getParameter("categoryDetailNo"));
					 productlist = service.product_List(title,categoryNo,categoryDetailNo,null,startCount,endCount);
					 viewpath  = "../product/product_list.jsp";
				 }
				// productlist = service.product_List(null,categoryNo,categoryDetailNo,null,startCount,endCount);
			 }
		 int totalCount =service.countProduct();
		  category_list = service1.categoryList(null);
	
			request.setAttribute("viewpath", viewpath);
			request.setAttribute("productlist", productlist);
			request.setAttribute("totalCount", totalCount);
		// System.out.println(productlist.size());
		 request.setAttribute("category_list", category_list);
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
			requestDispatcher.forward(request, response);
		
	}

}
