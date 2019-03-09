package category.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import category.dto.CategoryDTO;
import category.dto.CategoryDetailDTO;
import category.query.*;
import fw.DBUtil;

public class CategoryDAOimpl implements CategoryDAO {

	@Override
	public ArrayList<CategoryDTO> categoryList(String categoryName,  Connection connection) throws SQLException {
		ArrayList<CategoryDTO> category_list  = new ArrayList<CategoryDTO>();
		ResultSet resultSet = null;
		PreparedStatement ptmt = null;
		if(categoryName!=null){
			ptmt = connection.prepareStatement(CategoryQuery.CATEGORYLIST_SEARCH_NAME);
			ptmt.setString(1, categoryName+"%");
		}else{
		ptmt = connection.prepareStatement(CategoryQuery.CATEGORYLIST_SEARCH);
		}
		resultSet = ptmt.executeQuery();
		while (resultSet.next()) {
			CategoryDTO  dto = new CategoryDTO(resultSet.getInt(1), resultSet.getString(2));				
			category_list.add(dto);
		}
		 DBUtil.close(ptmt);
		return category_list;
	}

	@Override
	public ArrayList<CategoryDetailDTO> categoryDetailList(int categoryNo, String categoryDetailName,Connection connection) throws SQLException {
		ArrayList<CategoryDetailDTO> category_detail_list  = new ArrayList<CategoryDetailDTO>();
		ResultSet resultSet = null;
		PreparedStatement ptmt = null;
		if(categoryNo!=0){
			ptmt = connection.prepareStatement(CategoryQuery.CATEGORYDETAILLIST_SEARCH_BYCNO);
			 ptmt.setInt(1, categoryNo);
		}else if(categoryDetailName!=null){
			ptmt = connection.prepareStatement(CategoryQuery.CATEGORYDETAILLIST_SEARCH_NAME);
			 ptmt.setString(1,"%"+ categoryDetailName+"%");
		}
		resultSet = ptmt.executeQuery();
		while (resultSet.next()) {
			CategoryDetailDTO  dto = new CategoryDetailDTO(resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3));				
			category_detail_list.add(dto);
		}
		 DBUtil.close(ptmt);
		return category_detail_list;
	}


	
	
}
