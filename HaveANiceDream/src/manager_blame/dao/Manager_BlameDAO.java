package manager_blame.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import blame.dto.BlameDTO;
import manager_blame.dto.Manager_BlameDTO;


public interface Manager_BlameDAO {
	int insert(Manager_BlameDTO dto,Connection con) throws SQLException;
	ArrayList<String> select(int answerNo,Connection con) throws SQLException;
	
}
