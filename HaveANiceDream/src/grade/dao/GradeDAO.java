package grade.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import grade.dto.GradeDTO;



public interface GradeDAO {
	int gradeInsert(GradeDTO gradewrite, Connection connection) throws SQLException;
	ArrayList<GradeDTO> gradeList1(Connection connection) throws SQLException;
	ArrayList<GradeDTO> gradeSelectType(String userid,String gradeType,Connection connection) throws SQLException;
}
