package note.service;

import java.util.ArrayList;

import note.dto.NoteDTO;
import user.dto.MemberDTO;

public interface NoteService {
	int noteInsert(NoteDTO note);

	int noteUpdateState(int noteNo);

	NoteDTO noteSelect(int noteNo);

	ArrayList<NoteDTO> noteSendList(String noteSender);

	ArrayList<NoteDTO> noteReceiveList(String noteReceiver);

	int noteDelete(int noteNo);

	int getNewNoteNum(String noteReceiver);

	ArrayList<NoteDTO> noteList(String noteSender, String noteReceiver);
	
	ArrayList<MemberDTO> noteToList(String noteReceiver);

}
