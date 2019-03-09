package attendance.dao;

import static fw.DBUtil.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import attendance.dto.AttendanceDTO;
import attendance.query.AttendanceQuery;
import fw.DBUtil;

public class AttendanceDAOimpl implements AttendanceDAO {

	
	public int insert(AttendanceDTO dto, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(AttendanceQuery.ATTENDANCEQUERY_INSERT);
		
		ptmt.setString(1, dto.getUserId());
		ptmt.setInt(2, dto.getAttPoint());
		
		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public ArrayList<Date> list(String userid, Connection con) throws SQLException {
		
		ArrayList<Date> list = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;
		ptmt = con.prepareStatement(AttendanceQuery.ATTENDANCEQUERY_LIST);
		ptmt.setString(1, userid);
		resultSet = ptmt.executeQuery();
		
		while(resultSet.next()){
			if(list==null){
				list = new ArrayList<Date>();
			}
			
			list.add(resultSet.getDate(1));
		}
		
		DBUtil.close(ptmt);
		DBUtil.close(resultSet);
		return list;
	}

}
