package note.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import note.dto.NoteDTO;
import user.dto.MemberDTO;

public interface NoteDAO {
	int noteInsert(NoteDTO note, Connection connection) throws SQLException;

	int noteUpdateState(int noteNo, Connection connection) throws SQLException;

	NoteDTO noteSelect(int noteNo, Connection connection) throws SQLException;

	ArrayList<NoteDTO> noteSendList(String noteSender, Connection connection) throws SQLException;

	ArrayList<NoteDTO> noteReceiveList(String noteReceiver, Connection connection) throws SQLException;

	int noteDelete(int noteNo, Connection connection) throws SQLException;

	int getNewNoteNum(String noteReceiver, Connection connection) throws SQLException;
	
	ArrayList<NoteDTO> noteList(String noteSender, String noteReceiver, Connection connection) throws SQLException;
	
	ArrayList<MemberDTO> noteToList(String noteReceiver, Connection connection) throws SQLException;

}
