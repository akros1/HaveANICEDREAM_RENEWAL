package note.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import note.dao.NoteDAO;
import note.dao.NoteDAOImpl;
import note.dto.NoteDTO;
import user.dto.MemberDTO;

public class NoteServiceImpl implements NoteService {

	@Override
	public int noteInsert(NoteDTO note) {
		Connection connection = null;
		int res = 0;
		
		try {
			connection = DBUtil.getConnect();
			NoteDAO dao = new NoteDAOImpl();
			res = dao.noteInsert(note, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return res;
	}

	@Override
	public int noteUpdateState(int noteNo) {
		Connection connection = null;
		int res = 0;
		
		try {
			connection = DBUtil.getConnect();
			NoteDAO dao = new NoteDAOImpl();
			res = dao.noteUpdateState(noteNo, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return res;
	}

	@Override
	public NoteDTO noteSelect(int noteNo) {
		NoteDTO note = null;
		Connection connection = null;
		
		try {
			connection = DBUtil.getConnect();
			NoteDAO dao = new NoteDAOImpl();
			note = dao.noteSelect(noteNo, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return note;
	}

	@Override
	public ArrayList<NoteDTO> noteSendList(String noteSender) {
		ArrayList<NoteDTO> list = null;
		Connection connection = null;
		
		try {
			connection = DBUtil.getConnect();
			NoteDAO dao = new NoteDAOImpl();
			list = dao.noteSendList(noteSender, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return list;
	}

	@Override
	public ArrayList<NoteDTO> noteReceiveList(String noteReceiver) {
		ArrayList<NoteDTO> list = null;
		Connection connection = null;
		
		try {
			connection = DBUtil.getConnect();
			NoteDAO dao = new NoteDAOImpl();
			list = dao.noteReceiveList(noteReceiver, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return list;
	}

	@Override
	public int noteDelete(int noteNo) {
		Connection connection = null;
		int res = 0;
		
		try {
			connection = DBUtil.getConnect();
			NoteDAO dao = new NoteDAOImpl();
			res = dao.noteDelete(noteNo, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return res;
	}

	@Override
	public int getNewNoteNum(String noteReceiver) {
		Connection connection = null;
		int res = 0;
		
		try {
			connection = DBUtil.getConnect();
			NoteDAO dao = new NoteDAOImpl();
			res = dao.getNewNoteNum(noteReceiver, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return res;
	}

	@Override
	public ArrayList<NoteDTO> noteList(String noteSender, String noteReceiver) {
		Connection connection = null;
		ArrayList<NoteDTO> list = null;
		
		try {
			connection = DBUtil.getConnect();
			NoteDAO dao = new NoteDAOImpl();
			list = dao.noteList(noteSender, noteReceiver, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return list;
	}

	@Override
	public ArrayList<MemberDTO> noteToList(String noteReceiver) {
		Connection connection = null;
		ArrayList<MemberDTO> list = null;
		
		try {
			connection = DBUtil.getConnect();
			NoteDAO dao = new NoteDAOImpl();
			list = dao.noteToList(noteReceiver, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return list;
	}

}
