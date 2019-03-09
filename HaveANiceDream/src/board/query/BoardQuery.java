package board.query;

/*Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
USER_ID                                   NOT NULL VARCHAR2(20)
USER_PW                                            VARCHAR2(20)
USER_EMAIL                                         VARCHAR2(20)
USER_NAME                                          VARCHAR2(20)
USER_ZIPCODE                                       VARCHAR2(5)
USER_ADDR                                          VARCHAR2(90)
USER_TEL                                           VARCHAR2(20)
USER_SIGDATE                                       DATE
USER_LOG_TYPE                                      VARCHAR2(20)
USER_LAST_LOGIN_TIME                               DATE
POINT_TOTAL                                        NUMBER
USER_TYPE                                          VARCHAR2(20)
*/
public class BoardQuery {
	public static final String BOARD_INSERT = "insert into board values(board_seq.nextval,?,sysdate,?,?,?,?,?,?,?,?,?,?)";
	public static final String BOARD_LIST = "select * from board";
	public static final String BOARD_READ = "select * from board where BOARD_NO = ?";
	public static final String BOARD_DELETE = "delete from board where BOARD_NO = ?";
	public static final String USER_TYPE_UPDATE = "update member set USER_TYPE = ? where USER_ID = ?"; 
	public static final String USER_POINT_UPDATE = "update member set POINT_TOTAL = ? where USER_ID = ?"; 
	public static final String USER_GET_POINT = "select POINT_TOTAL from member where USER_ID = ?";
	public static final String USER_LOGINTIME_UPDATE = "update member set USER_LAST_LOGIN_TIME = sysdate where USER_ID = ?";
	public static final String USER_UPDATE = "UPDATE member "
			+ "SET "
			     + "USER_PW = ?, "
			     + "USER_NAME = ?, "
			     + "USER_EMAIL = ?, "
			     + "USER_ZIPCODE = ?, "
			     + "USER_ADDR = ?, "
			     + "USER_TEL = ? "
			+ "WHERE USER_ID = ?";
}