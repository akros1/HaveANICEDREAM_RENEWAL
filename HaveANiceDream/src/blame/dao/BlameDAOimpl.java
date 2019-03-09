package blame.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import fw.DBUtil;
import blame.dto.BlameDTO;
import blame.query.BlameQuery;

/*Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
BLAME_NO                                  NOT NULL NUMBER
BLAME_DATE                                         DATE
USER_ID_BLAMERE                                    VARCHAR2(20)
USER_ID_BLAMEE                                     VARCHAR2(20)
BLAME_TYPE                                         VARCHAR2(20)
PRODUCT_NO                                         NUMBER
ATTACHED_FILE                                      VARCHAR2(20)
BLAME_TITLE                                        VARCHAR2(20)
BLAME_CONTENT                                      VARCHAR2(20)*/


public class BlameDAOimpl implements BlameDAO {


	public int insert(BlameDTO dto, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = null;
		ptmt = con.prepareStatement(BlameQuery.BLAME_INSERT);
		
		ptmt.setString(3, dto.getUserIdBlamere());
		ptmt.setString(1, dto.getUserIdBlamee());
		ptmt.setString(2, dto.getBlameType());
		ptmt.setString(4, dto.getAttachedFile());
		ptmt.setString(5, dto.getBlameTitle());
		ptmt.setString(6, dto.getBlameContent());
		
		
		result = ptmt.executeUpdate();
		DBUtil.close(ptmt);
		return result;
	}


	public ArrayList<BlameDTO> list(Connection con) throws SQLException {
		ArrayList<BlameDTO> list = null;
		BlameDTO dto = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;
		ptmt = con.prepareStatement(BlameQuery.BLAME_LIST);
		
		resultSet = ptmt.executeQuery();
		
		while(resultSet.next()){
			if(list==null){
				list = new ArrayList<BlameDTO>();
			}
			dto = new BlameDTO(
					resultSet.getInt(1),
					resultSet.getDate(2),
					resultSet.getString(3),
					resultSet.getString(4),
					resultSet.getString(5),
					resultSet.getString(6),
					resultSet.getString(7),
					resultSet.getString(8),
					resultSet.getString(9)
					);
			list.add(dto);
		}
		DBUtil.close(ptmt);
		DBUtil.close(resultSet);
		return list;
	}


	

	public BlameDTO select(int blameNo, Connection con) throws SQLException {
		BlameDTO dto = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;
		ptmt = con.prepareStatement(BlameQuery.BLAME_SELECT);
		ptmt.setInt(1, blameNo);
		
		resultSet = ptmt.executeQuery();
		
		if(resultSet.next()){
			dto = new BlameDTO(
						resultSet.getInt(1),
						resultSet.getDate(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7),
						resultSet.getString(8),
						resultSet.getString(9)
					);
		}
		DBUtil.close(resultSet);
		DBUtil.close(ptmt);
		
		return dto;
	}


	
	public int update(int blameNo,Connection con)
			throws SQLException {
		int result = 0;
		
		PreparedStatement ptmt = con.prepareStatement(BlameQuery.BLAME_UPDATE);
		
		ptmt.setInt(1, blameNo);
		
		result = ptmt.executeUpdate();
		
		DBUtil.close(ptmt);
		return result;
	}


	@Override
	public ArrayList<BlameDTO> user_list(String userIdBlamere, Connection con) throws SQLException {
		ArrayList<BlameDTO> list = null;
		BlameDTO dto = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;
		ptmt = con.prepareStatement(BlameQuery.BLAME_LIST2);
		ptmt.setString(1, userIdBlamere);
		resultSet = ptmt.executeQuery();
		
		while(resultSet.next()){
			if(list==null){
				list = new ArrayList<BlameDTO>();
			}
			dto = new BlameDTO(
					
					resultSet.getInt(1),
					resultSet.getDate(2),
					resultSet.getString(3),
					resultSet.getString(4),
					resultSet.getString(5),
					resultSet.getString(6),
					resultSet.getString(7),
					resultSet.getString(8),
					resultSet.getString(9)
					);
			list.add(dto);
		}
		DBUtil.close(ptmt);
		DBUtil.close(resultSet);
		return list;
	}

	
}