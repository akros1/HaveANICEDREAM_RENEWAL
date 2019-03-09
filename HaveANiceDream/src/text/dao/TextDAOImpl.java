package text.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import product.query.ProductQuery;
import text.TextDTO;

public class TextDAOImpl implements TextDAO {

	@Override
	public int insertText(TextDTO text, Connection connection ) throws SQLException {
		int result=0;
		
		PreparedStatement ptmt = null;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		 java.sql.Date date1 =null;
		try {
			date = sd.parse(text.getTextDate());
		date1= new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ptmt = connection.prepareStatement("insert into text values(text_seq.nextval,trade_seq.currval,?,?,?)");
		ptmt.setString(1, text.getUserId());
		ptmt.setDate(2,date1);
		ptmt.setString(3, text.getTextContent());
		result = ptmt.executeUpdate();
		
		return result;
	}
	
	@Override
	public int stateText(TextDTO text, Connection connection ) throws SQLException {
		int result=0;
		
		PreparedStatement ptmt = null;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		 java.sql.Date date1 =null;
		try {
			date = sd.parse(text.getTextDate());
		date1= new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ptmt = connection.prepareStatement("insert into text values(text_seq.nextval,?,?,?,?)");
		ptmt.setInt(1, text.getTradeNo());
		ptmt.setString(2, text.getUserId());
		
		ptmt.setDate(3,date1);
		ptmt.setString(4, text.getTextContent());
		result = ptmt.executeUpdate();
		
		return result;
	}

}
