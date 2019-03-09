package trade.query;

public class TradeQuery {
	public static final String TRADE_INSERT = "insert into trade values(trade_seq.nextval,sysdate,?,?,?,?,?)";
	public static final String TRADE_SELECT = "select * from trade where USER_ID_BUY=? or USER_ID_SELL=?";
	public static final String TRADE_SELECTTRNO = "select * from trade where TRADE_NO=?";
	public static final String TRADE_STATE_UPDATE = "update trade set TRADE_STATE = ? where TRADE_NO = ?"; 
	public static final String TRADE_END_UPDATE = "update trade set TRADE_END_DATE = sysdate where TRADE_NO = ?"; 
	public static final String TRADE_DELETE = "delete from trade where trade_no = ?"; 

}