package category.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import category.dto.CategoryDTO;
import category.dto.CategoryDetailDTO;


public interface CategoryDAO {
     
       ArrayList<CategoryDTO>  categoryList(String categoryName,Connection connection) throws SQLException;
       ArrayList<CategoryDetailDTO>  categoryDetailList(int categoryNo, String categoryDetailName,Connection connection) throws SQLException;
}
