package category.service;


import java.sql.Connection;
import java.util.ArrayList;

import category.dto.CategoryDTO;
import category.dto.CategoryDetailDTO;

public interface CategoryService {
	ArrayList<CategoryDTO>  categoryList(String categoryName);
	ArrayList<CategoryDetailDTO>  categoryDetailList(int categoryNo,String categoryDetailName );
}
