package text.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.sun.corba.se.impl.orb.ParserTable.TestAcceptor1;

import fw.DBUtil;
import text.TextDTO;
import text.dao.TextDAO;
import text.dao.TextDAOImpl;
import trade.dao.TradeDAO;
import trade.dao.TradeDAOImpl;
import trade.dto.TradeDTO;

public class TextServiceImpl implements TextService {

	@Override
	public int insertText(TextDTO text) {
		Connection connection = null;
		int result=0;
		TextDAO dao = new TextDAOImpl();
		
		try {
			connection = DBUtil.getConnect();
		    result = dao.insertText(text, connection);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			DBUtil.close(connection);
		}
		
		return result;
	}

}
