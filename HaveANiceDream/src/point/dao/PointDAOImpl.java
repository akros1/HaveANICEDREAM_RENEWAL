package point.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import point.dto.PointDTO;
import point.query.PointQuery;
/*Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
POINT_NO                                  NOT NULL NUMBER
USER_ID                                            VARCHAR2(20)
POINT_DATE                                         DATE
POINT_TYPE                                         VARCHAR2(20)
POINT                                              NUMBER*/


public class PointDAOImpl implements PointDAO {

	@Override
	public int pointInsert(PointDTO point, Connection connection) throws SQLException {
		int rowNum = 0;
		PreparedStatement preparedStatement = connection.prepareStatement(PointQuery.POINT_INSERT);
		
		preparedStatement.setString(1, point.getUserId());
		preparedStatement.setString(2, point.getPointType());
		preparedStatement.setInt(3, point.getPoint());
		
		rowNum = preparedStatement.executeUpdate();
		
		DBUtil.close(preparedStatement);
		
		return rowNum;
	}

	@Override
	public ArrayList<PointDTO> pointList(String userId, Connection connection) throws SQLException {
		ArrayList<PointDTO> list = null;
		PointDTO dto = null;
		ResultSet resultSet = null;
		
		PreparedStatement preparedStatement = connection.prepareStatement(PointQuery.POINT_LIST);
		
		preparedStatement.setString(1, userId);
		
		resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			if (list == null){
				list = new ArrayList<PointDTO>();
			}
			
			dto = new PointDTO(
					resultSet.getInt(1), 
					resultSet.getString(2), 
					resultSet.getDate(3), 
					resultSet.getString(4), 
					resultSet.getInt(5));
			
			list.add(dto);
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);
		
		return list;
	}

}
