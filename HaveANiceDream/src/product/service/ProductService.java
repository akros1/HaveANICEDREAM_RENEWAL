package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import product.dto.ProductDTO;

public interface ProductService {
	   int countProduct();
	int insertProduct(ProductDTO product, ArrayList<String> imageSrc);
	ArrayList<ProductDTO>  product_List(String title ,int categoryNo,int  categoryDetailNo,String UserId,int startCount, int endCount);
	ProductDTO productSelect(int productNo);
	ArrayList<String> productSelect_Image(int productNo);
	int updateProduct(ProductDTO product, String imageSrc);
	int productStateUpdate(int productState,int productNo);
}
