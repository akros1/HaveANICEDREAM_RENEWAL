package manager_blame.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import blame.dto.BlameDTO;

import static fw.DBUtil.*;

import manager_blame.dao.Manager_BlameDAO;
import manager_blame.dao.Manager_BlameDAOimpl;
import manager_blame.dto.Manager_BlameDTO;

public class Manager_BlameServiceimpl implements Manager_BlameService {

	public int insert(Manager_BlameDTO dto){
		Connection con = null;
		int result = 0;
		Manager_BlameDAO dao = new Manager_BlameDAOimpl();
		try {
			con = getConnect();
			result = dao.insert(dto, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(con);
		}
		return result;
	}

	public ArrayList<String> select(int answerNo){
		ArrayList<String> result = null;
		Connection con = null;
		Manager_BlameDAO dao = new Manager_BlameDAOimpl();
		try {
			con = getConnect();
			result = dao.select(answerNo, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(con);
		}
		return result;
	}
	

}
