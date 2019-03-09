package blame.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import blame.dto.BlameDTO;

public interface BlameDAO {
	int insert(BlameDTO dto,Connection con) throws SQLException;
	ArrayList<BlameDTO> list(Connection con) throws SQLException;
	ArrayList<BlameDTO> user_list(String userIdBlamere,Connection con)throws SQLException;
	int update(int blameNo,Connection con) throws SQLException;
	BlameDTO select(int blameNo,Connection con) throws SQLException;
	

}
