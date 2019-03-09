package note.dto;

import java.sql.Date;

public class NoteDTO {

    private Integer noteNo;

    private String noteSender;

    private String noteReceiver;

    private Date noteDate;

    private String noteContent;

    private String noteState;
    
    public NoteDTO() {

    }

	public NoteDTO(Integer noteNo, String noteSender, String noteReceiver, Date noteDate, String noteContent,
			String noteState) {
		super();
		this.noteNo = noteNo;
		this.noteSender = noteSender;
		this.noteReceiver = noteReceiver;
		this.noteDate = noteDate;
		this.noteContent = noteContent;
		this.noteState = noteState;
	}

	public NoteDTO(String noteSender, String noteReceiver, String noteContent) {
		super();
		this.noteSender = noteSender;
		this.noteReceiver = noteReceiver;
		this.noteContent = noteContent;
	}

	public Integer getNoteNo() {
		return noteNo;
	}

	public void setNoteNo(Integer noteNo) {
		this.noteNo = noteNo;
	}

	public String getNoteSender() {
		return noteSender;
	}

	public void setNoteSender(String noteSender) {
		this.noteSender = noteSender;
	}

	public String getNoteReceiver() {
		return noteReceiver;
	}

	public void setNoteReceiver(String noteReceiver) {
		this.noteReceiver = noteReceiver;
	}

	public Date getNoteDate() {
		return noteDate;
	}

	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public String getNoteState() {
		return noteState;
	}

	public void setNoteState(String noteState) {
		this.noteState = noteState;
	}

	@Override
	public String toString() {
		return "NoteDTO [noteNo=" + noteNo + ", noteSender=" + noteSender + ", noteReceiver=" + noteReceiver
				+ ", noteDate=" + noteDate + ", noteContent=" + noteContent + ", noteState=" + noteState + "]";
	}
    
    
}