package blame.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import static fw.DBUtil.*;

import blame.dao.BlameDAO;
import blame.dao.BlameDAOimpl;
import blame.dto.BlameDTO;
import fw.DBUtil;

public class BlameServiceimpl implements BlameService {


	public int insert(BlameDTO dto) {
		Connection con = null;
		int result = 0;
		BlameDAO dao = new BlameDAOimpl();
		try{
			con = getConnect();
			result = dao.insert(dto, con);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		
		return result;
		 
	}

	public ArrayList<BlameDTO> list() {
		ArrayList<BlameDTO> result = null;
		Connection con =null;
		BlameDAO dao = new BlameDAOimpl();
		try{
			con = getConnect();
			result = dao.list(con);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return result;
	}


	public int update(int blameNo) {
		int result = 0;
		Connection con = null;
		BlameDAO dao = new BlameDAOimpl();
		try{
			con = getConnect();
			result = dao.update(blameNo,con);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return result;
	}

	public BlameDTO select(int blameNo) {
		BlameDTO result = null;
		Connection con = null;
		BlameDAO dao = new BlameDAOimpl();
		try{
			con = getConnect();
			result = dao.select(blameNo, con);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return result;
	}

	@Override
	public ArrayList<BlameDTO> user_list(String userIdBlamere) {
		ArrayList<BlameDTO> result = null;
		Connection con =null;
		BlameDAO dao = new BlameDAOimpl();
		
		try{
			con = getConnect();
			result = dao.user_list(userIdBlamere, con);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return result;
	}

	
}
