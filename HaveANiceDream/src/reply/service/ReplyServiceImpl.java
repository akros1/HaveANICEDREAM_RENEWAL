package reply.service;

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
import reply.dao.ReplyDAO;
import reply.dao.ReplyDAOImpl;
import reply.dto.ReplyDTO;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;
import user.dto.MemberDTO;

public class ReplyServiceImpl implements ReplyService {

	@Override
	public int replyInsert(ReplyDTO replywrite) {
		Connection connection = null;
		int rowNum = 0;

		try {
			connection = DBUtil.getConnect();

			ReplyDAO dao = new ReplyDAOImpl();
			rowNum = dao.replyInsert(replywrite, connection);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			DBUtil.close(connection);
		}

		return rowNum;
	}


	@Override
	public ArrayList<ReplyDTO> replyList(int boardNo) {
		Connection connection = null;
		ArrayList<ReplyDTO> replyList = null;
		
		try {
			connection = DBUtil.getConnect();
			ReplyDAO dao = new ReplyDAOImpl();
			replyList = dao.replyList(boardNo, connection);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			DBUtil.close(connection);
		}
		
		return replyList;
	}




}
