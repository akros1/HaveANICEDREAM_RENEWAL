package trade.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;
import board.dto.BoardDTO;
import fw.DBUtil;
import point.dao.PointDAO;
import point.dao.PointDAOImpl;
import point.dto.PointDTO;
import product.dao.productDAO;
import product.dao.productDAOimpl;
import product.dto.ProductDTO;
import sms.SMSSendMethod;
import text.TextDTO;
import text.dao.TextDAO;
import text.dao.TextDAOImpl;
import trade.dao.TradeDAOImpl;
import trade.dao.TradeDAO;
import trade.dto.TradeDTO;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;
import user.dto.MemberDTO;

public class TradeServiceImpl implements TradeService {

	@Override
	public int tradeInsert(TradeDTO tradelist,TextDTO text,TextDTO text1 ) {
		Connection connection = null;
		int rowNum = 0;
		int result=0;
		boolean state=false;
		try {
			connection = DBUtil.getConnect();
                 connection.setAutoCommit(false);
			TradeDAO dao = new TradeDAOImpl();
			TextDAO textdao = new TextDAOImpl();
			productDAO productdao = new productDAOimpl();
			rowNum = dao.tradeInsert(tradelist, connection);
			result = textdao.insertText(text, connection); //구매자
			result = textdao.insertText(text1, connection);//판매자
			result = productdao.productStateUpdate(2, tradelist.getProductNo(), connection);//상태값변경
			state=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
				try {
					if(state){
					connection.commit();
					SMSSendMethod test = new SMSSendMethod();//문자전송
					//에러 0004는 문자길이 초과로 인한 오류로 발생시 해당내용 수정 90자까지 되는걸로 알고있음( 단문전송만 가능) 
					test.SMSSend(text.getUserTel()+","+text1.getUserTel(), text.getTextContent());	
						
					}else{
						connection.rollback();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			DBUtil.close(connection);
		}

		return rowNum;
	}

	@Override
	public ArrayList<TradeDTO> tradeSelect(String userId) {
		Connection connection = null;
		ArrayList<TradeDTO> tradeList = null;
		
		
		try {
			connection = DBUtil.getConnect();
			TradeDAO dao = new TradeDAOImpl();
			tradeList = dao.tradeSelect(userId, connection);
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			DBUtil.close(connection);
		}
		
		
		return tradeList;
	}

	@Override
	public TradeDTO tradenoSelect(int tradeNo) {
		Connection connection = null;
		TradeDTO dto = null;
		
		try {
			connection = DBUtil.getConnect();
			TradeDAO dao = new TradeDAOImpl();
			dto = dao.tradenoSelect(tradeNo, connection);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			DBUtil.close(connection);
		}
		
		return dto;
	}

	@Override
	public int tradeStateUpdate(String tradeState, int tradeNo) {
		Connection connection = null;
		int result = 0;
		
		try {
			connection = DBUtil.getConnect();
			TradeDAO dao = new TradeDAOImpl();
			result = dao.tradeStateUpdate(tradeState, tradeNo, connection);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			DBUtil.close(connection);
		}
		
		return result;
	}

	@Override
	public int tradeDelete(String tradeState,int tradeNo,TextDTO text,TextDTO text1) {
		Connection connection = null;
		int result = 0;
		boolean state=false;
		try {
			connection = DBUtil.getConnect();
			connection.setAutoCommit(false);
			TextDAO textdao = new TextDAOImpl();
			TradeDAO dao = new TradeDAOImpl();
			result = dao.tradeStateUpdate(tradeState, tradeNo, connection);
			result = textdao.stateText(text, connection); //구매자
			result = textdao.stateText(text1, connection);//판매자
			state=true;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			
			
			try {
				if(state){
				connection.commit();
				SMSSendMethod test = new SMSSendMethod();//문자전송
				//에러 0004는 문자길이 초과로 인한 오류로 발생시 해당내용 수정 90자까지 되는걸로 알고있음( 단문전송만 가능) 
				test.SMSSend(text.getUserTel()+","+text1.getUserTel(), text.getTextContent());	
					
				}else{
					connection.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
			DBUtil.close(connection);
		}
		
		return result;
	}

	@Override
	public int tradeEndDateUpdate(int tradeNo) {
		Connection connection = null;
		int result = 0;
		
		try {
			connection = DBUtil.getConnect();
			TradeDAO dao = new TradeDAOImpl();
			result = dao.tradeEndDateUpdate(tradeNo, connection);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			DBUtil.close(connection);
		}
		
		return result;
	}


}
