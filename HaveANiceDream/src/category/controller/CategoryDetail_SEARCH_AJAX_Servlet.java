package category.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import category.dto.CategoryDetailDTO;
import category.service.CategoryService;
import category.service.CategoryServiceimpl;

//category_detail에 대한 내용을 AJAX 통신을 사용하여 DB에 접근해서 받아옴
//이름을 통한 방식(ENROLL) No을 통한 방식(서블릿단
@WebServlet(name = "/category/DeatilSearchAJAX", urlPatterns = { "/category/DeatilSearchAJAX.do" })
public class CategoryDetail_SEARCH_AJAX_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String categoryName=request.getParameter("categoryName");  //카테고리이름을 받아옴
		int categoryNo=0;
		CategoryService service = new CategoryServiceimpl();
		ArrayList<CategoryDetailDTO> category_detail_listAjax =  null; 
		String state=request.getParameter("state");
		if(state.equals("ENROLL")){//물품등록할때
		 category_detail_listAjax=service.categoryDetailList(0,categoryName);//이름을 통한 전체검색(실제로 뿌려지는정보는 ajax에서  selectNum과 categoryNo로 비교함 당황하지마세요...
		}else if (state.equals("SEARCH")){//product_list.jsp화면에서 대분류를 선택했을때 실행되는 코드.
			 if(request.getParameter("categoryNo").equals("선택해주세요")){//문자열이어서 예외처리를 해주어야함...
				 categoryNo=1;
			 
			 }else{
			 categoryNo=Integer.parseInt(request.getParameter("categoryNo"));//
			 }
			category_detail_listAjax =service.categoryDetailList(categoryNo,null);//카테고리 No로 검색        2번째는 이름으로검색. 
				}
		JSONObject root_category_detail = new JSONObject();
		JSONArray list = new JSONArray();
		int size=0;
		if(category_detail_listAjax!=null){
		size=category_detail_listAjax.size();
		}
		for (int i = 0; i < size; i++) {
			CategoryDetailDTO dto =category_detail_listAjax.get(i);
			JSONObject category_detail = new JSONObject();
			category_detail.put("categoryDetailNo", dto.getCategoryDetailNo());
			category_detail.put("categoryDetailName", dto.getCategoryDetailName());
			category_detail.put("categoryNo", dto.getCategoryNo());

			list.add(category_detail);
			
		}
		
		root_category_detail.put("category_detail", list);
		 response.setContentType("application/json;charset=utf-8");
	     response.setHeader("cache-control", "no-cache,no-store");
	     pw.print(root_category_detail.toJSONString());
	}

}
