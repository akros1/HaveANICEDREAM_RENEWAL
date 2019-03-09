package attendance.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import static fw.DBUtil.*;
import attendance.dao.AttendanceDAO;
import attendance.dao.AttendanceDAOimpl;
import attendance.dto.AttendanceDTO;
import fw.DBUtil;

public class AttendanceServiceimpl implements AttendanceService {

	public int insert(AttendanceDTO dto){
		Connection con = null;
		int result = 0;
		AttendanceDAO dao = new AttendanceDAOimpl();
		try {
			con = getConnect();
			result = dao.insert(dto, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(con);
		}
		return result;
	}

	@Override
	public ArrayList<Date> list(String userid) {
		ArrayList<Date> result =  null;
		Connection con =null;
		AttendanceDAO dao = new AttendanceDAOimpl();
		try {
			con = getConnect();
			result = dao.list(userid, con);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBUtil.close(con);
			
		}
		return result;
	}

}
