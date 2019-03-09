package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import product.dto.ProductDTO;
import product.query.ProductQuery;
import trade.query.TradeQuery;
import user.dto.MemberDTO;

public class productDAOimpl implements productDAO {
	//이미지 인서트
	@Override
	public int insertProduct_Image(ArrayList<String> imageSrc, Connection connection) throws SQLException {
		  int result=0;
		  PreparedStatement ptmt=null;
		  for (int i = 0; i < imageSrc.size(); i++) {
			  if(imageSrc.get(i)!=null){
			  ptmt = connection.prepareStatement(ProductQuery.PRODUCT_IMG_INSERT);
				     ptmt.setString(1, imageSrc.get(i));
				     result=ptmt.executeUpdate();
			  }else{
				  
			  }
		}
		 
		     DBUtil.close(ptmt);
		  return result;
	}
	//이미지 업데이트
	@Override
	public ArrayList<String> productSelect_Image(int productNo, Connection connection) throws SQLException {
		ProductDTO product = null;
		ResultSet resultSet = null;
		PreparedStatement ptmt = null;
		ArrayList<String> imageList= new ArrayList<String>();
		ptmt = connection.prepareStatement(ProductQuery.PRODUCT_IMG_SELECTPNO);
		ptmt.setInt(1, productNo);
		resultSet = ptmt.executeQuery();
		while(resultSet.next()){
			String imageSrc= resultSet.getString(1);
			imageList.add(imageSrc);
		}
		
		 DBUtil.close(ptmt);
		return imageList;
	}
	
	//다만 카테고리디테일네임 (페이징)생성자 똑같이 19개
	@Override
	public ProductDTO productSelect(int productNo, Connection connection) throws SQLException {
		ProductDTO product = null;
		ResultSet resultSet = null;
		PreparedStatement ptmt = null;
		if(productNo!=0){
		ptmt = connection.prepareStatement(ProductQuery.PRODUCT_SELECT_PNO);
		ptmt.setInt(1, productNo);
		}
		resultSet = ptmt.executeQuery();
		if(resultSet.next()){
		product = new ProductDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
					resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),
						resultSet.getDate(9), resultSet.getInt(10), resultSet.getInt(11), resultSet.getString(12),resultSet.getInt(13)
						,resultSet.getString(14),resultSet.getString(15),resultSet.getString(16),resultSet.getString(17),resultSet.getString(18),resultSet.getString(19) );
		}
		
		 DBUtil.close(ptmt);
		return product;
	}
	
	//다만 rowNum (페이징)생성자 똑같이 19개
	@Override
	public ArrayList<ProductDTO> product_List(String title,int categoryNo,int  categoryDetailNo,String userId ,int startCount, int endCount,Connection connection) throws SQLException {
		ArrayList<ProductDTO> product_list = new ArrayList<ProductDTO>();
		ResultSet resultSet = null;
		PreparedStatement ptmt = null;
		
		if(categoryNo!=0 & categoryDetailNo==0 & userId==null){  //대분류로만 검색
				ptmt = connection.prepareStatement(ProductQuery.PRODUCTLIST_SEARCH_CATEGORY_DETAIL);
				ptmt.setString(1, "%"+title+"%");
				ptmt.setInt(2, categoryNo);
				ptmt.setInt(3,startCount );
				ptmt.setInt(4,endCount );
				System.out.println("대분류");
		}else if(categoryNo!=0 & userId==null ){ //대,소분류를 통한 검색
			ptmt = connection.prepareStatement(ProductQuery.PRODUCTLIST_SEARCH_CATEGORY);
			ptmt.setString(1, "%"+title+"%");
			ptmt.setInt(2, categoryNo);
			ptmt.setInt(3, categoryDetailNo);
			ptmt.setInt(4,startCount );
			ptmt.setInt(5,endCount );
		}else if(title!=null&categoryNo==0 & categoryDetailNo==0  & userId==null){  //전체리스트 검색
			ptmt = connection.prepareStatement(ProductQuery.PRODUCTLIST_TITLE);
			ptmt.setString(1, "%"+title+"%");
			ptmt.setInt(2,startCount );
			ptmt.setInt(3,endCount );
			System.out.println();
		}else if(title==null&categoryNo==0 & categoryDetailNo==0  & userId==null & endCount==6){  //전체리스트 검색
			ptmt = connection.prepareStatement(ProductQuery.PRODUCTLIST_PAGING_RECENT);
			ptmt.setInt(1,startCount );
			ptmt.setInt(2,endCount );
			
		}
		else if(title==null&categoryNo==0 & categoryDetailNo==0  & userId==null){  //전체리스트 검색
			ptmt = connection.prepareStatement(ProductQuery.PRODUCTLIST_PAGING);
			ptmt.setInt(1,startCount );
			ptmt.setInt(2,endCount );
		}else if(userId!=null){//???? 
			ptmt = connection.prepareStatement(ProductQuery.PRODUCT_LIST_BY_UESR);
			ptmt.setString(1, userId);
			ptmt.setInt(2,startCount );
			ptmt.setInt(3,endCount );
			
			
		}
		resultSet = ptmt.executeQuery();
		while (resultSet.next()) {
			if (product_list == null) {
				product_list = new ArrayList<ProductDTO>();
			}
			ProductDTO  dto = new ProductDTO(
					resultSet.getInt(1),
					resultSet.getInt(2),
					resultSet.getString(3),
					resultSet.getInt(4),
					resultSet.getString(5),
					resultSet.getInt(6),
					resultSet.getString(7),
					resultSet.getString(8),
					resultSet.getString(9),
					resultSet.getDate(10),
					resultSet.getInt(11),
					resultSet.getInt(12),
					resultSet.getString(13),
					resultSet.getInt(14),
					resultSet.getString(15),
					resultSet.getString(16),
					resultSet.getString(17),
					resultSet.getString(18),
					resultSet.getString(19)
					);
			product_list.add(dto);
		}
	//	System.out.println(product_list);
		 DBUtil.close(ptmt);
		return product_list;
	}
	
	
	@Override
	public int insertProduct(ProductDTO product, Connection connection ) throws SQLException {
		
		int result = 0;
		PreparedStatement ptmt = null;

		ptmt = connection.prepareStatement(ProductQuery.PRODUCT_INSERT);
		//"insert into product values(product_seq.nextval,?,?,?,?,?,?,?,sysdate,?,3,?)";
		
		ptmt.setString(1, product.getUserId());
		ptmt.setInt(2, product.getCategoryNo());
		ptmt.setString(3, product.getProductName());
		ptmt.setInt(4, product.getProductPrice());
		ptmt.setString(5, product.getProductContent());
		ptmt.setString(6, product.getProduct_Grade());
		ptmt.setString(7, product.getProductTitle());
		ptmt.setInt(8, product.getProductState());
		ptmt.setInt(9, 3);
		ptmt.setString(10, product.getTradeType());
		ptmt.setInt(11, product.getCategoryDetailNo());
		
		result = ptmt.executeUpdate();
		
	  // System.out.println(result);
        
		

		DBUtil.close(ptmt);

		return result;
	}

	@Override
	public int updateProduct(ProductDTO product, Connection connection) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = null;
          //업데이트문으로 수정해야함 ^^
		ptmt = connection.prepareStatement("Update product set USER_ID= ? , "
				+ " CATEGORY_NO = ? ,"
				+ "PRODUCT_NAME = ?,"
				+ "PRODUCT_PRICE = ?,"
				+ " PRODUCT_CONTENT = ?,"
				+ "PRODUCT_GRADE = ?,"
				+ "PRODUCT_TITLE = ?,"
				
				+ " PRODUCT_STATE= ?,"
				
				+ "TRADE_TYPE = ? ,"
				+ "category_Detail_No = ?"
				+ " where product_no = ?"  ); 
		
		ptmt.setString(1, product.getUserId());
		ptmt.setInt(2, product.getCategoryNo());
		ptmt.setString(3, product.getProductName());
		ptmt.setInt(4, product.getProductPrice());
		ptmt.setString(5, product.getProductContent());
		ptmt.setString(6, product.getProduct_Grade());
		ptmt.setString(7, product.getProductTitle());
		ptmt.setInt(8, product.getProductState());
		ptmt.setString(9, product.getTradeType());
		ptmt.setInt(10, product.getCategoryDetailNo());
		ptmt.setInt(11, product.getProductNo());
		
		result = ptmt.executeUpdate();
		 return result;
	}
  //상품업데이트
	@Override
	public int updateProduct_Image(String imageSrc, int productNo, Connection connection) throws SQLException {
		  int result=0;
		  PreparedStatement ptmt=null;
		  ptmt = connection.prepareStatement(ProductQuery.PRODUCT_IMG_UPDATE);
		//  System.out.println(imageSrc);
		  ptmt.setString(1, imageSrc);
		  ptmt.setInt(2, productNo);  
		  
		    
		     result=ptmt.executeUpdate();
		     
		     DBUtil.close(ptmt);
		  return result;
	}

	@Override
	public int productStateUpdate(int productState, int productNo,Connection connection) throws SQLException{
		
		int result = 0;
		
		PreparedStatement ptmt = connection.prepareStatement(ProductQuery.PRODUCT_STATE_UPDATE);
		//update product set PRODUCT_STATE = ? where PRODUCT_NO = ?
		
		ptmt.setInt(1, productState);
		ptmt.setInt(2, productNo);


		result = ptmt.executeUpdate();

		DBUtil.close(ptmt);
		return result;
	}

	@Override
	public int countProduct(Connection connection) throws SQLException{
			int result = 0;
			ResultSet resultSet = null;
		PreparedStatement ptmt = connection.prepareStatement(ProductQuery.PRODUCT_COUNT);
		
	
		resultSet=ptmt.executeQuery();
		if(resultSet.next()){
		result=	resultSet.getInt(1);
		}
		DBUtil.close(ptmt);
		System.out.println(result);
		return result;
	}


   
}
