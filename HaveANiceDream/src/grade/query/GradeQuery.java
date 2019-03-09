package grade.query;

public class GradeQuery {
	public static final String GRADE_INSERT = "insert into grade values(grade_seq.nextval,?,?,?,?,?,sysdate,?)";
	public static final String GRADE_LIST = "select * from grade";
	public static final String GRADE_SELECT_TYPE = "select * from grade where user_id=? and grade_type=?";
	public static final String TRADE_SELECTTRNO = "select * from trade where TRADE_NO=?";
	public static final String TRADE_STATE_UPDATE = "update trade set TRADE_STATE = ? where TRADE_NO = ?"; 
	public static final String TRADE_DELETE = "delete from trade where trade_no = ?"; 

}