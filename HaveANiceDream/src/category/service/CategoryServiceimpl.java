package category.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import category.dao.CategoryDAO;
import category.dao.CategoryDAOimpl;
import category.dto.CategoryDTO;
import category.dto.CategoryDetailDTO;
import fw.DBUtil;

public class CategoryServiceimpl implements CategoryService {

	@Override
	public ArrayList<CategoryDTO> categoryList(String categoryName) {
		ArrayList<CategoryDTO> category_list = new ArrayList<CategoryDTO>();
		Connection connection = null;
		CategoryDAO dao = new CategoryDAOimpl();
		int result = 0;
		
		try {
			connection = DBUtil.getConnect();
			category_list=dao.categoryList( categoryName,connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return category_list;
	}

	@Override
	public ArrayList<CategoryDetailDTO> categoryDetailList(int categoryNo, String categoryDetailName) {
		ArrayList<CategoryDetailDTO> category_list = new ArrayList<CategoryDetailDTO>();
		Connection connection = null;
		CategoryDAO dao = new CategoryDAOimpl();
		int result = 0;
		
		try {
			connection = DBUtil.getConnect();
			category_list=dao.categoryDetailList(categoryNo, categoryDetailName,connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return category_list;
	}



}
