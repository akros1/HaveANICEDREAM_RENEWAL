package user.query;

/*Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
USER_ID                                   NOT NULL VARCHAR2(20)
USER_PW                                            VARCHAR2(20)
USER_EMAIL                                         VARCHAR2(200)
USER_NAME                                          VARCHAR2(20)
USER_ZIPCODE                                       VARCHAR2(5)
USER_ADDR                                          VARCHAR2(200)
USER_ADDR_DETAIL                                   VARCHAR2(20)
USER_TEL                                           VARCHAR2(20)
USER_SIGDATE                                       DATE
USER_LOG_TYPE                                      VARCHAR2(20)
USER_LAST_LOGIN_TIME                               DATE
USER_IMAGE                                         VARCHAR2(20)
POINT_TOTAL                                        NUMBER
USER_TYPE                                          VARCHAR2(20)
*/
public class UserQuery {
	public static final String USER_INSERT = "insert into member values(?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?)";
	public static final String USER_LIST = "select * from member";
	public static final String USER_SERCH_NAME = USER_LIST + " where USER_NAME like ?";
	public static final String USER_SERCH_ID = USER_LIST + " where USER_ID like ?";
	public static final String USER_SELECT = "select * from member where USER_ID = ?";
	public static final String USER_LOGIN = "select * from member where USER_ID = ? and USER_PW = ?";
	public static final String USER_DELETE = "update member set USER_TYPE = '탈퇴회원' where USER_ID = ?"; 
	public static final String USER_TYPE_UPDATE = "update member set USER_TYPE = ? where USER_ID = ?"; 
	public static final String USER_POINT_UPDATE = "update member set POINT_TOTAL = ? where USER_ID = ?"; 
	public static final String USER_PASS_UPDATE = "update member set USER_PW = ? where USER_ID = ? and USER_PW = ?";
	public static final String USER_GET_POINT = "select POINT_TOTAL from member where USER_ID = ?";
	public static final String USER_LOGINTIME_UPDATE = "update member set USER_LAST_LOGIN_TIME = sysdate where USER_ID = ?";
	public static final String USER_UPDATE = "UPDATE member "
			+ "SET "
			     + "USER_PW = ?, "
			     + "USER_NAME = ?, "
			     + "USER_EMAIL = ?, "
			     + "USER_ZIPCODE = ?, "
			     + "USER_ADDR = ?, "
			     + "USER_ADDR_DETAIL = ?, "
			     + "USER_TEL = ?, "
			     + "USER_IMAGE = ? "
			+ "WHERE USER_ID = ?";
	public static final String USER_FIND_ID = "select substr(user_id,1,length(user_id)-3)||lpad('*',3,'*') from member where USER_EMAIL = ?";
	public static final String USER_FIND_PASS = "update member set USER_PW = ? where USER_ID = ? and USER_EMAIL = ?";
}
