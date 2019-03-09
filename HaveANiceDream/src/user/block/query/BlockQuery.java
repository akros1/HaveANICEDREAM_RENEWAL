package user.block.query;
/*Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
USER_ID                                   NOT NULL VARCHAR2(20)
BLOCK_REASON                                       VARCHAR2(20)
BLOCK_DATE                                         DATE*/
public class BlockQuery {
	public static final String BLOCK_INSERT = "insert into block values(?,?,sysdate)";
	public static final String BLOCK_DELETE = "delete from block where USER_ID = ?";
	public static final String BLOCK_LIST = "select * from block";
}
