package product.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import product.dto.ProductDTO;

public interface productDAO {
   int countProduct(Connection connection) throws SQLException;
	int insertProduct(ProductDTO product, Connection connection) throws SQLException;
	ArrayList<ProductDTO>  product_List(String title,int categoryNo,int  categoryDetailNo,String userId ,int startCount, int endCount,Connection connection) throws SQLException;
	int insertProduct_Image(ArrayList<String> imageSrc,Connection connection)throws SQLException;
	int updateProduct_Image(String imageSrc,int productNo,Connection connection)throws SQLException;
	ProductDTO productSelect(int productNo  ,Connection connection) throws SQLException;
	int updateProduct(ProductDTO product, Connection connection) throws SQLException;
	ArrayList<String> productSelect_Image(int productNo, Connection connection) throws SQLException;
	int productStateUpdate(int productState,int productNo, Connection connection) throws SQLException;
}
