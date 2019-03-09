package manager_blame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import blame.dto.BlameDTO;
import blame.query.BlameQuery;
import fw.DBUtil;
import manager_blame.dto.Manager_BlameDTO;
import manager_blame.query.Manager_BlameQuery;

public class Manager_BlameDAOimpl implements Manager_BlameDAO {

	public int insert(Manager_BlameDTO dto, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = null;
		ptmt = con.prepareStatement(Manager_BlameQuery.ANSWER_INSERT);
		
		ptmt.setInt(1, dto.getBlameNo());
		ptmt.setString(2, dto.getUserId());
		ptmt.setString(3, dto.getAnswerTitle());
		ptmt.setString(4, dto.getAnswerContent());
		
		result = ptmt.executeUpdate();
		
		return result;
	}

	public ArrayList<String> select(int answerNo, Connection con) throws SQLException {
		ArrayList<String> dto = null;
		PreparedStatement ptmt=null;
		ResultSet rs = null;
		ptmt = con.prepareStatement(Manager_BlameQuery.ANSWER_SELECT);
		ptmt.setInt(1, answerNo);
		
		rs = ptmt.executeQuery();
		if(rs.next()){
			dto = new ArrayList<String>();
			dto.add(rs.getInt(1)+"");
			dto.add(rs.getDate(2).toString());
			dto.add(rs.getString(3));
			dto.add(rs.getString(4));
			dto.add(rs.getString(5));
			dto.add(rs.getString(6));
			dto.add(rs.getDate(7).toString());
			
		}
		DBUtil.close(rs);
		DBUtil.close(ptmt);
		return dto;
	}


	

}
