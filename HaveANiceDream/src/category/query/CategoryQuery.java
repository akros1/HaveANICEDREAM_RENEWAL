package category.query;

public class CategoryQuery {
	  //카테고리리스트검색 넘버(리스트검색시 사용)
      public static String  CATEGORYDETAILLIST_SEARCH_BYCNO ="select * from category_detail where category_no = ?";
      //카테고리디테일리스트검색(AJAX)(물품등록시 사용)
      public static String  CATEGORYDETAILLIST_SEARCH_NAME = "select * from category_detail where category_detail_name like ? ";
      
      //카테고리리스트 검색(리스트검색,등물품록시사용)
      public static String  CATEGORYLIST_SEARCH="select * from category";
      //카테고리리스트검색(AJAX)(리스트검색시사용)
      public static String  CATEGORYLIST_SEARCH_NAME="select * from category where category_Name like  ?";
}
