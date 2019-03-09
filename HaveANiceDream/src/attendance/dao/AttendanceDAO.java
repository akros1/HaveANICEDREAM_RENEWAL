package attendance.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import attendance.dto.AttendanceDTO;

public interface AttendanceDAO {
	int insert(AttendanceDTO dto,Connection con)throws SQLException;
	ArrayList<Date> list(String userid,Connection con)throws SQLException;
}
