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

import category.dto.CategoryDTO;
import category.service.CategoryService;
import category.service.CategoryServiceimpl;
//카테고리 대분류 비동기통신으로 검색하는부분 (물품등록할때 사용)
@WebServlet(name = "/category/SearchAJAX", urlPatterns = { "/category/SearchAJAX.do" })
public class Category_SEARCH_AJAX_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String categoryName = request.getParameter("categoryName");
		CategoryService service = new CategoryServiceimpl();
		ArrayList<CategoryDTO> category_listAjax = service.categoryList(categoryName);
		// json파싱.
		JSONObject root_category = new JSONObject();//root생성
		JSONArray list = new JSONArray();//JSONArray 생성 (dto를 담게 될 배열)
		int size = category_listAjax.size();
		for (int i = 0; i < size; i++) {
			CategoryDTO dto = category_listAjax.get(i);
			JSONObject category = new JSONObject();//dto에대한 정보들을 담을 Obj
			category.put("categoryNo", dto.getCategoryNo());
			category.put("categoryName", dto.getCategoryName());

			list.add(category);//Obj(카테고리 넘버,이름)을 배열에 담음

		}

		root_category.put("category", list);//그러한 배열을을 카테고리라는이름으로 루트에 저장.
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("cache-control", "no-cache,no-store");
		pw.print(root_category.toJSONString());//제이슨형태로 변환해서 넘김 넘긴정보는 .ajax 메소드를 통해 받음.
	}
}
