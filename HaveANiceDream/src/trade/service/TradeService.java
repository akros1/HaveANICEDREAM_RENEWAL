package trade.service;

import java.util.ArrayList;

import board.dto.BoardDTO;
import text.TextDTO;
import trade.dto.TradeDTO;


public interface TradeService {
	int tradeInsert(TradeDTO tradelist,TextDTO text,TextDTO text1 );
	ArrayList<TradeDTO> tradeSelect(String userId);
	TradeDTO tradenoSelect(int tradeNo);
	int tradeStateUpdate(String tradeState, int tradeNo);
	int tradeDelete(String tradeState, int tradeNo,TextDTO text,TextDTO text1);
	int tradeEndDateUpdate(int tradeNo);
}
