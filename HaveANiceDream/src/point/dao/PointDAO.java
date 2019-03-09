package point.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import point.dto.PointDTO;


public interface PointDAO {
	int pointInsert(PointDTO point, Connection connection) throws SQLException;
	ArrayList<PointDTO> pointList(String userId, Connection connection) throws SQLException;

}
