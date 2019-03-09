package grade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.dto.BoardDTO;
import board.query.BoardQuery;
import fw.DBUtil;
import grade.dto.GradeDTO;
import grade.query.GradeQuery;
import trade.dto.TradeDTO;
import trade.query.TradeQuery;
import user.query.UserQuery;


public class GradeDAOImpl implements GradeDAO {

	@Override
	public int gradeInsert(GradeDTO gradewrite, Connection connection) throws SQLException {
		int rowNum = 0;
		PreparedStatement preparedStatement = null;

		preparedStatement = connection.prepareStatement(GradeQuery.GRADE_INSERT);
		preparedStatement.setString(1, gradewrite.getUserId());
		preparedStatement.setInt(2, gradewrite.getTradeNo());
		preparedStatement.setString(3, gradewrite.getGrade());
		preparedStatement.setString(4, gradewrite.getGradeType());
		preparedStatement.setString(5, gradewrite.getGradeContent());
		preparedStatement.setString(6, gradewrite.getGradeUserId());
		//grade_seq.nextval,?,?,?,?,?,sysdate
		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public ArrayList<GradeDTO> gradeList1(Connection connection) throws SQLException {
		ArrayList<GradeDTO> gradelist = new ArrayList<GradeDTO>();
		GradeDTO dto = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		ptmt = connection.prepareStatement(GradeQuery.GRADE_LIST);
		
		rs = ptmt.executeQuery();
		
		while (rs.next()){
			dto = new GradeDTO(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7),rs.getString(8));
			
			gradelist.add(dto);
			
		}
		DBUtil.close(rs);
		DBUtil.close(ptmt);
		
		return gradelist;
	}

	@Override
	public ArrayList<GradeDTO> gradeSelectType(String userid, String gradeType, Connection connection)
			throws SQLException {
		ArrayList<GradeDTO> gradelist = new ArrayList<GradeDTO>();
		GradeDTO dto = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		ptmt = connection.prepareStatement(GradeQuery.GRADE_SELECT_TYPE);
		
		ptmt.setString(1, userid);
		ptmt.setString(2, gradeType);
		
		rs = ptmt.executeQuery();
		
		while (rs.next()){
			dto = new GradeDTO(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7),rs.getString(8));
			
			gradelist.add(dto);
			
		}
		DBUtil.close(rs);
		DBUtil.close(ptmt);
		
		return gradelist;
	}

}