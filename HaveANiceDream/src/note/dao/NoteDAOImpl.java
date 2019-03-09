package note.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import note.dto.NoteDTO;
import note.query.NoteQuery;
import user.dto.MemberDTO;

public class NoteDAOImpl implements NoteDAO {

	@Override
	public int noteInsert(NoteDTO note, Connection connection) throws SQLException {
		int res = 0;
		PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.NOTE_INSERT);
		// "INSERT INTO Note VALUES (Note_SEQ.NEXTVAL, ?, ?, sysdate, ?, 'N')";
		preparedStatement.setString(1, note.getNoteSender());
		preparedStatement.setString(2, note.getNoteReceiver());
		preparedStatement.setString(3, note.getNoteContent());

		res = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return res;
	}

	@Override
	public int noteUpdateState(int noteNo, Connection connection) throws SQLException {
		int res = 0;
		PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.NOTE_UPDATE_STATE);

		preparedStatement.setInt(1, noteNo);

		res = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return res;
	}

	@Override
	public NoteDTO noteSelect(int noteNo, Connection connection) throws SQLException {
		NoteDTO dto = null;
		PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.NOTE_READ);

		preparedStatement.setInt(1, noteNo);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			dto = new NoteDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4),
					resultSet.getString(5), resultSet.getString(6));
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);

		return dto;
	}

	@Override
	public ArrayList<NoteDTO> noteSendList(String noteSender, Connection connection) throws SQLException {
		ArrayList<NoteDTO> notelist = null;
		NoteDTO dto = null;
		PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.NOTE_LIST_SEND);

		preparedStatement.setString(1, noteSender);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			if (notelist == null) {
				notelist = new ArrayList<NoteDTO>();
			}
			dto = new NoteDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4),
					resultSet.getString(5), resultSet.getString(6));

			notelist.add(dto);
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);

		return notelist;
	}

	@Override
	public ArrayList<NoteDTO> noteReceiveList(String noteReceiver, Connection connection) throws SQLException {
		ArrayList<NoteDTO> notelist = null;
		NoteDTO dto = null;
		PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.NOTE_LIST_RECEIVE);

		preparedStatement.setString(1, noteReceiver);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			if (notelist == null) {
				notelist = new ArrayList<NoteDTO>();
			}
			dto = new NoteDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4),
					resultSet.getString(5), resultSet.getString(6));

			notelist.add(dto);
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);

		return notelist;
	}

	@Override
	public int noteDelete(int noteNo, Connection connection) throws SQLException {
		int res = 0;
		PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.NOTE_DELETE);

		preparedStatement.setInt(1, noteNo);

		res = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return res;
	}

	@Override
	public int getNewNoteNum(String noteReceiver, Connection connection) throws SQLException {
		int result = 0;

		PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.NOTE_NEW_NOTE_COUNT);

		preparedStatement.setString(1, noteReceiver);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			result = resultSet.getInt(1);
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);

		return result;
	}

	@Override
	public ArrayList<NoteDTO> noteList(String noteSender, String noteReceiver, Connection connection)
			throws SQLException {
		ArrayList<NoteDTO> list = null;
		PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.NOTE_TALK_LIST);
		// "SELECT * FROM Note WHERE (note_sender = ? and note_receiver=?) or
		// (note_sender = ? and note_receiver=?)";

		preparedStatement.setString(1, noteSender);
		preparedStatement.setString(2, noteReceiver);
		preparedStatement.setString(3, noteReceiver);
		preparedStatement.setString(4, noteSender);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			if (list == null) {
				list = new ArrayList<NoteDTO>();
			}
			NoteDTO dto = new NoteDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getDate(4), resultSet.getString(5), resultSet.getString(6));

			list.add(dto);
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);

		return list;
	}

	@Override
	public ArrayList<MemberDTO> noteToList(String noteReceiver, Connection connection) throws SQLException {
		ArrayList<MemberDTO> list = null;
		
		PreparedStatement preparedStatement = connection.prepareStatement(NoteQuery.NOTE_TO_LIST);
		
		preparedStatement.setString(1, noteReceiver);
		preparedStatement.setString(2, noteReceiver);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			if (list == null) {
				list = new ArrayList<MemberDTO>();
			}

			MemberDTO dto = new MemberDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
					resultSet.getString(8), resultSet.getDate(9), resultSet.getString(10), resultSet.getDate(11),
					resultSet.getString(12), resultSet.getInt(13), resultSet.getString(14));

			list.add(dto);
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);
		
		return list;
	}

}
