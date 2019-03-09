package note.query;

public class NoteQuery {
	public static final String NOTE_INSERT = "INSERT INTO Note VALUES (Note_SEQ.NEXTVAL, ?, ?, sysdate, ?, 'N')";
	public static final String NOTE_UPDATE_STATE = "UPDATE Note SET note_state = 'Y' WHERE note_no = ?";
	public static final String NOTE_DELETE = "DELETE FROM Note WHERE note_no = ?";

	public static final String NOTE_READ = "SELECT * FROM Note WHERE note_no = ?";
	public static final String NOTE_LIST_SEND = "SELECT * FROM Note WHERE note_sender = ?";
	public static final String NOTE_LIST_RECEIVE = "SELECT * FROM Note WHERE note_receiver = ?";
	public static final String NOTE_NEW_NOTE_COUNT = "SELECT count(*) FROM Note WHERE note_state = 'N' and note_receiver = ?";
	
	public static final String NOTE_TALK_LIST = "SELECT * FROM Note WHERE (note_sender = ? and note_receiver=?) or (note_sender = ? and note_receiver=?)";
	public static final String NOTE_TO_LIST = "SELECT u.user_id, u.user_pw, u.user_email, u.user_name, u.user_zipcode, u.user_addr, u.user_addr_detail, "
			+ "u.user_tel, u.user_sigdate, u.user_log_type, u.user_last_login_time, u.user_image, u.point_total, u.user_type "
			+ "FROM member u , (SELECT DISTINCT note_sender col FROM Note WHERE note_receiver = ? union SELECT DISTINCT note_receiver col FROM Note WHERE note_sender = ?) s "
			+ "where u.user_id = s.col";
}
