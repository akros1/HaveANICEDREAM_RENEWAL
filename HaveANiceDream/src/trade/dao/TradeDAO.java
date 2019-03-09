package trade.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import board.dto.BoardDTO;
import trade.dto.TradeDTO;
import user.dto.MemberDTO;

public interface TradeDAO {
	int tradeInsert(TradeDTO tradelist, Connection connection) throws SQLException;
	ArrayList<TradeDTO> tradeSelect(String userId, Connection connection) throws SQLException;
	TradeDTO tradenoSelect(int tradeNo, Connection connection) throws SQLException;
	int tradeStateUpdate(String tradeState ,int tradeNo, Connection connection) throws SQLException;
	int tradeDelete(int tradeNo, Connection connection) throws SQLException;
	int tradeEndDateUpdate(int tradeNo, Connection connection) throws SQLException;
}
