package point.query;
/*Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
POINT_NO                                  NOT NULL NUMBER
USER_ID                                            VARCHAR2(20)
POINT_DATE                                         DATE
POINT_TYPE                                         VARCHAR2(20)
POINT                                              NUMBER*/
public class PointQuery {
	public static final String POINT_INSERT = "insert into point values(POINT_SEQ.nextval,?,sysdate,?,?)";
	public static final String POINT_LIST = "select * from point where USER_ID=?";
	
}
