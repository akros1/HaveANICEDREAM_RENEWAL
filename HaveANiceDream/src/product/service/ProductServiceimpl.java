package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import product.dao.productDAO;
import product.dao.productDAOimpl;
import product.dto.ProductDTO;
import trade.dao.TradeDAO;
import trade.dao.TradeDAOImpl;

public class ProductServiceimpl implements ProductService {
	@Override
	public int insertProduct(ProductDTO product,ArrayList<String> imageSrc) {
		Connection connection = null;
		productDAO dao = new productDAOimpl();
		
		int result = 0;
		boolean state=false;
		try {
			connection = DBUtil.getConnect();
			connection.setAutoCommit(false);
			result = dao.insertProduct(product, connection);
			dao.insertProduct_Image(imageSrc, connection);
			state=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
				try {
					if(state){
					connection.commit();
					DBUtil.close(connection);
					}else{
						connection.rollback();
						DBUtil.close(connection);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
			
		}
		
		return result;
	}

	@Override
	public ArrayList<ProductDTO> product_List(String title, int categoryNo,int  categoryDetailNo,String UserId ,int startCount, int endCount) {
		ArrayList<ProductDTO> product_list = new ArrayList<ProductDTO>();
		Connection connection = null;
		productDAO dao = new productDAOimpl();
		
		int result = 0;
		
		try {
			connection = DBUtil.getConnect();
			product_list = dao.product_List( title, categoryNo,categoryDetailNo, UserId,startCount,endCount,connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
	//	System.out.println("서비스단"+product_list);
		return product_list;
	}

	@Override
	public ProductDTO productSelect(int productNo) {
		ProductDTO product = new ProductDTO();
		Connection connection = null;
		productDAO dao = new productDAOimpl();
		
		
		try {
			connection = DBUtil.getConnect();
			product = dao.productSelect(productNo, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		return product;
	}

	@Override
	public ArrayList<String> productSelect_Image(int productNo) {
		ArrayList<String> imageList=new ArrayList<String>();
		Connection connection = null;
		productDAO dao = new productDAOimpl();
		
		
		try {
			connection = DBUtil.getConnect();
			imageList = dao.productSelect_Image(productNo, connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		return imageList;
	}

	@Override
	public int updateProduct(ProductDTO product, String imageSrc ) {
		int result = 0;
		Connection connection = null;
		productDAO dao = new productDAOimpl();
		boolean  state =false;
		try {
			connection = DBUtil.getConnect();
			//오토커밋해제..
			connection.setAutoCommit(false);
			result = dao.updateProduct(product, connection);
			dao.updateProduct_Image(imageSrc, product.getProductNo(), connection);
			state=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
				try {
					if(state){
					connection.commit();
					DBUtil.close(connection);
					}else{
						connection.rollback();
						DBUtil.close(connection);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		return 0;
	}

	@Override
	public int productStateUpdate(int productState, int productNo) {
		Connection connection = null;
		int result = 0;
		try {
			connection = DBUtil.getConnect();
			productDAO dao = new productDAOimpl();
			result = dao.productStateUpdate(productState, productNo, connection);
			
		} catch (SQLException e) {

			e.printStackTrace();
			
		} finally{
			DBUtil.close(connection);
		}
		
		return result;
	}

	@Override
	public int countProduct() {
		Connection connection = null;
		int result = 0;
		try {
			connection = DBUtil.getConnect();
			productDAO dao = new productDAOimpl();
			result = dao.countProduct(connection);
			
		} catch (SQLException e) {

			e.printStackTrace();
			
		} finally{
			DBUtil.close(connection);
		}
		
		return result;
	}

	



}
