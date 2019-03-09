package trade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.dto.BoardDTO;
import board.query.BoardQuery;
import fw.DBUtil;
import trade.dto.TradeDTO;
import trade.query.TradeQuery;
import user.query.UserQuery;


public class TradeDAOImpl implements TradeDAO {

	@Override
	public int tradeInsert(TradeDTO tradelist, Connection connection) throws SQLException {
		int rowNum = 0;
		PreparedStatement preparedStatement = null;

		preparedStatement = connection.prepareStatement(TradeQuery.TRADE_INSERT);
		preparedStatement.setDate(1, tradelist.getTradeEndDate());
		preparedStatement.setString(2, tradelist.getUserIdBuy());
		preparedStatement.setString(3, tradelist.getUserIdSell());
		preparedStatement.setInt(4, tradelist.getProductNo());
		preparedStatement.setString(5, tradelist.getTradeState());

		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public ArrayList<TradeDTO> tradeSelect(String userId, Connection connection) throws SQLException {
		ArrayList<TradeDTO> tradelist = new ArrayList<TradeDTO>();
		TradeDTO dto = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		ptmt = connection.prepareStatement(TradeQuery.TRADE_SELECT);

		ptmt.setString(1, userId);
		ptmt.setString(2, userId);
		
		rs = ptmt.executeQuery();
		
		
		while (rs.next()){
			dto = new TradeDTO(rs.getInt(1), rs.getDate(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
			tradelist.add(dto);
			
		}
		DBUtil.close(rs);
		DBUtil.close(ptmt);
		
		return tradelist;
	}

	@Override
	public TradeDTO tradenoSelect(int tradeNo, Connection connection) throws SQLException {
		TradeDTO dto = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		ptmt = connection.prepareStatement(TradeQuery.TRADE_SELECTTRNO);
		
		ptmt.setInt(1, tradeNo);
		
		rs = ptmt.executeQuery();
		
		if(rs.next()){
			dto = new TradeDTO(rs.getInt(1), rs.getDate(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
			
		}
		DBUtil.close(rs);
		DBUtil.close(ptmt);
		
		return dto;
	}

	@Override
	public int tradeStateUpdate(String tradeState ,int tradeNo, Connection connection) throws SQLException {
		int result = 0;
		
		PreparedStatement ptmt = connection.prepareStatement(TradeQuery.TRADE_STATE_UPDATE);
		
		ptmt.setString(1, tradeState);
		ptmt.setInt(2, tradeNo);


		result = ptmt.executeUpdate();

		DBUtil.close(ptmt);
		
		return result;
	}

	@Override
	public int tradeDelete(int tradeNo, Connection connection) throws SQLException {
		int result = 0;
		
		PreparedStatement ptmt = connection.prepareStatement(TradeQuery.TRADE_DELETE);

		ptmt.setInt(1, tradeNo);


		result = ptmt.executeUpdate();

		DBUtil.close(ptmt);
		
		return result;
	}

	@Override
	public int tradeEndDateUpdate(int tradeNo, Connection connection) throws SQLException {
		int result = 0;
		
		PreparedStatement ptmt = connection.prepareStatement(TradeQuery.TRADE_END_UPDATE);

		ptmt.setInt(1, tradeNo);


		result = ptmt.executeUpdate();

		DBUtil.close(ptmt);
		
		return result;
	}
}