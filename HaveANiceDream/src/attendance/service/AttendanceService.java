package attendance.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import attendance.dto.AttendanceDTO;

public interface AttendanceService {
	int insert(AttendanceDTO dto);
	ArrayList<Date> list(String userid);
}
