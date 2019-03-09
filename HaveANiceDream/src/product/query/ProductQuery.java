package product.query;

public class ProductQuery {
	//카테고리 시퀀스로 구분해서  핸드폰인지 유야용품인지 구분하는작업이 필요함
	//동시에 디테일도 같이 추가 (int형식)
	//사진이미지 저장되는것까지 한번에 확인할수도록.
	

	public static final String PRODUCT_INSERT = "insert into product values(product_seq.nextval,?,?,?,?,?,?,?,sysdate,?,?,?,?)";
	
	//상품리스트검색(전체) 페이징처리구현
	public static final String PRODUCT_COUNT="select count(*) from product";
	public static final String PRODUCTLIST_PAGING="select * "
			+ "from (select rowNum rnum,p.product_no,p.user_id,p.category_no,p.product_name, p.product_price,p.product_content,p.product_grade,p.product_title,p.product_date,p.product_state,p.product_exf_date,p.trade_type,p.category_detail_no,c.category_name,i.image_src, m.user_name,m.user_tel,m.user_email "
			       + "from product p,category c,product_image i,member m, (select min(image_no) imgno "
			                                                             + "from product_image  "
			                                                             + "group by product_no) t "
			       + "where p.category_no = c.category_no and p.product_no = i.product_no and m.user_id = p.user_id and p.product_state=3 and t.imgno=i.image_no ) "
			+ "where rnum between ? and ?";
	
	//메인에 띄워지는 6개 화면에 대한 글..
	public static final String PRODUCTLIST_PAGING_RECENT="select * "
			+ "from (select rank() over (order by p.PRODUCT_DATE desc) rk,p.product_no,p.user_id,p.category_no,p.product_name, p.product_price,p.product_content,p.product_grade,p.product_title,p.product_date,p.product_state,p.product_exf_date,p.trade_type,p.category_detail_no,c.category_name,i.image_src, m.user_name,m.user_tel,m.user_email "
		       + "from product p,category c,product_image i,member m, (select min(image_no) imgno "
		                                                             + "from product_image  "
		                                                             + "group by product_no) t "
		       + "where p.category_no = c.category_no and p.product_no = i.product_no and m.user_id = p.user_id and p.product_state=3 and t.imgno=i.image_no order by p.PRODUCT_DATE desc ) "
		+ "where rk between ? and ?";
	
	
	
	
	
	public static final String PRODUCTLIST_TITLE="select * "
			+ "from (select rowNum rnum,p.product_no,p.user_id,p.category_no,p.product_name, p.product_price,p.product_content,p.product_grade,p.product_title,p.product_date,p.product_state,p.product_exf_date,p.trade_type,p.category_detail_no,c.category_name,i.image_src, m.user_name,m.user_tel,m.user_email "
		       + "from product p,category c,product_image i,member m, (select min(image_no) imgno "
		                                                             + "from product_image  "
		                                                             + "group by product_no) t "
		       + "where p.category_no = c.category_no and p.product_no = i.product_no and m.user_id = p.user_id and p.product_state=3 and t.imgno=i.image_no and p.product_title like ? ) "
		+ "where rnum between ? and ?";
	//해당회원아이디로 검색된 상품들을 확인할때 쓰는용도 상태값을 절대 안줌.. 멤버아이디에 해당하는거는 다 보여줘야 하니까
	public static final String PRODUCT_LIST_BY_UESR="select * "
			+ "from (select rowNum rnum,p.product_no,p.user_id,p.category_no,p.product_name, p.product_price,p.product_content,p.product_grade,p.product_title,p.product_date,p.product_state,p.product_exf_date,p.trade_type,p.category_detail_no,c.category_name,i.image_src, m.user_name,m.user_tel,m.user_email "
		       + "from product p,category c,product_image i,member m, (select min(image_no) imgno "
		                                                             + "from product_image  "
		                                                             + "group by product_no) t "
		       + "where p.category_no = c.category_no and p.product_no = i.product_no and m.user_id = p.user_id and  m.user_id = ? and t.imgno=i.image_no ) "
		+ "where rnum between ? and ?";
			
	//상품상세보기,거래신청(거래번호)
	public static final String PRODUCT_SELECT_PNO=
			"select p.product_no,p.user_id,p.category_no,p.product_name,p.product_price,p.product_content,p.product_grade, "+
			"p.product_title,p.product_date,p.product_state,p.product_exf_date,p.trade_type,p.category_detail_no, " +
			"c.category_name,i.image_src, m.user_name,m.user_tel,m.user_email,cd.category_detail_name from product p, category c,product_image i, " +
			"member m,category_detail cd where p.category_no = c.category_no and p.product_no "+ 
			"= i.product_no and m.user_id = p.user_id and cd.category_no = c.category_no and  p.category_detail_no = cd.category_detail_no  and  p.product_No= ?";			
					
//대분류로 검색했을때  
	public static final String PRODUCTLIST_SEARCH_CATEGORY="select * "
			+ "from (select rowNum rnum,p.product_no,p.user_id,p.category_no,p.product_name, p.product_price,p.product_content,p.product_grade,p.product_title,p.product_date,p.product_state,p.product_exf_date,p.trade_type,p.category_detail_no,c.category_name,i.image_src, m.user_name,m.user_tel,m.user_email "
		       + "from product p,category c,product_image i,member m, (select min(image_no) imgno "
		                                                             + "from product_image  "
		                                                             + "group by product_no) t "
		       + "where p.category_no = c.category_no and p.product_no = i.product_no and m.user_id = p.user_id and p.product_state=3 and p.product_title like ? and p.category_no = ? and p.category_detail_no = ? and t.imgno=i.image_no ) "
		+ "where rnum between ? and ?";
//대분류,소분류로 검색했을떄	    
	public static final String PRODUCTLIST_SEARCH_CATEGORY_DETAIL="select * "
			+ "from (select rowNum rnum,p.product_no,p.user_id,p.category_no,p.product_name, p.product_price,p.product_content,p.product_grade,p.product_title,p.product_date,p.product_state,p.product_exf_date,p.trade_type,p.category_detail_no,c.category_name,i.image_src, m.user_name,m.user_tel,m.user_email "
		       + "from product p,category c,product_image i,member m, (select min(image_no) imgno "
		                                                             + "from product_image  "
		                                                             + "group by product_no) t "
		       + "where p.category_no = c.category_no and p.product_no = i.product_no and m.user_id = p.user_id and p.product_state=3 and t.imgno=i.image_no and p.product_title like ? and   p.category_no = ? ) "
		+ "where rnum between ? and ?";
	//이미지 삽입
	public static final String PRODUCT_IMG_INSERT = "insert into product_image values(PRODUCT_IMAGE_SEQ.nextval,product_seq.currval,?)";
	//이미지업데이트
	public static final String PRODUCT_IMG_UPDATE = "update product_image set image_src =? where product_no = ?";
	//이미지검색(상품번호)
	public static final String PRODUCT_IMG_SELECTPNO= "select IMAGE_SRC from product_image where  product_No= ?";
	//상품 상태변경 (거래관련)
	public static final String PRODUCT_STATE_UPDATE = "update product set PRODUCT_STATE = ? where PRODUCT_NO = ?"; 


	
	
}
