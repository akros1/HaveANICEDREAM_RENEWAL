package grade.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import grade.dao.GradeDAO;
import grade.dao.GradeDAOImpl;
import grade.dto.GradeDTO;


public class GradeServiceImpl implements GradeService {

	@Override
	public int gradeInsert(GradeDTO gradewrite) {
		Connection connection = null;
		int rowNum = 0;

		try {
			connection = DBUtil.getConnect();

			GradeDAO dao = new GradeDAOImpl();
			rowNum = dao.gradeInsert(gradewrite, connection);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			DBUtil.close(connection);
		}

		return rowNum;
	}

	@Override
	public ArrayList<GradeDTO> gradeList1() {
		Connection connection = null;
		ArrayList<GradeDTO> gradelist = null;
		
		try {
			connection = DBUtil.getConnect();
			GradeDAO dao = new GradeDAOImpl();
			gradelist = dao.gradeList1(connection);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			DBUtil.close(connection);
		}
		
		return gradelist;

	}

	@Override
	public ArrayList<GradeDTO> gradeSelectType(String userid, String gradeType) {
		Connection connection = null;
		ArrayList<GradeDTO> gradeSelectList = null;
		
		try {
			connection = DBUtil.getConnect();
			GradeDAO dao = new GradeDAOImpl();
			gradeSelectList = dao.gradeSelectType(userid, gradeType, connection);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			DBUtil.close(connection);
		}
		
		return gradeSelectList;
	}

}
