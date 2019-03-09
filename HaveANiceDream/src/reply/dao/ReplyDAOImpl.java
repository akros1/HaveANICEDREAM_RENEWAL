package reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.dto.BoardDTO;
import board.query.BoardQuery;
import fw.DBUtil;
import reply.dto.ReplyDTO;
import reply.query.ReplyQuery;
import user.query.UserQuery;


public class ReplyDAOImpl implements ReplyDAO {

	@Override
	public int replyInsert(ReplyDTO replywrite, Connection connection) throws SQLException {
		int rowNum = 0;
		PreparedStatement preparedStatement = null;

		preparedStatement = connection.prepareStatement(ReplyQuery.REPLY_INSERT);
		//insert into reply values(reply_seq.nextval,?,?,?,sysdate)

		preparedStatement.setInt(1, replywrite.getBorderNo());
		preparedStatement.setString(2, replywrite.getReplyContent());
		preparedStatement.setString(3, replywrite.getUserId());


		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public ArrayList<ReplyDTO> replyList(int boardNo, Connection connection) throws SQLException {
		ArrayList<ReplyDTO> replyList = new ArrayList<ReplyDTO>();
		ReplyDTO dto = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		ptmt = connection.prepareStatement(ReplyQuery.REPLY_LIST);
		
		ptmt.setInt(1, boardNo);
		rs = ptmt.executeQuery();
		
		while (rs.next()){
			dto = new ReplyDTO(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5));
			replyList.add(dto);
			
		}
		DBUtil.close(rs);
		DBUtil.close(ptmt);
		
		return replyList;
	}




}