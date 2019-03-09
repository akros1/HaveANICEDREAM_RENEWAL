package board.service;

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
import user.dao.UserDAO;
import user.dao.UserDAOImpl;
import user.dto.MemberDTO;

public class BoardServiceImpl implements BoardService {

	@Override
	public int boardInsert(BoardDTO boardwrite) {
		Connection connection = null;
		int rowNum = 0;

		try {
			connection = DBUtil.getConnect();

			BoardDAO dao = new BoardDAOImpl();
			rowNum = dao.boardInsert(boardwrite, connection);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			DBUtil.close(connection);
		}

		return rowNum;
	}

	@Override
	public ArrayList<BoardDTO> boardList() {
		Connection connection = null;
		ArrayList<BoardDTO> boardlist = null;
		
		try {
			connection = DBUtil.getConnect();
			BoardDAO dao = new BoardDAOImpl();
			boardlist = dao.boardList(connection);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			DBUtil.close(connection);
		}
		
		return boardlist;
	}

	@Override
	public BoardDTO boardRead(int boardNo) {
		Connection connection = null;
		BoardDTO dto = null;
		
		try {
			connection = DBUtil.getConnect();
			BoardDAO dao = new BoardDAOImpl();
			dto = dao.boardRead(boardNo, connection);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			DBUtil.close(connection);
		}
		
		return dto;
	}

	@Override
	public int boardDelete(int boardNo) {
		Connection connection = null;
		BoardDAO dao = new BoardDAOImpl();
		int rowNum = 0;

		try {
			connection = DBUtil.getConnect();
			rowNum = dao.boardDelete(boardNo, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}

		return rowNum;
	}


}
