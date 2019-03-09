package board.dto;

import java.sql.Date;

public class BoardDTO {

    private Integer boardNo;
    //insert into board values(board_seq.nextval,?,sysdate,?,?,0,0,0,0,0,?,?,?)
    private String userId;

    private Date writeDate;

    private String boardTitle;

    private String boardContent;
    
    private String boardState;

    private Integer boardCount;

    private Integer boardParentNo;

    private Integer boardLevel;

    private Integer boardOrder;
    
    private String boardimageSrc;
    
    private String boardType1;
    
    private String boardType2;
    
    
    public BoardDTO(){
    	
    }
    

	public BoardDTO(String userId, String boardTitle, String boardContent, String boardState, Integer boardCount,
			Integer boardParentNo, Integer boardLevel, Integer boardOrder, String boardimageSrc, String boardType1,
			String boardType2) {
		super();
		this.userId = userId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardState = boardState;
		this.boardCount = boardCount;
		this.boardParentNo = boardParentNo;
		this.boardLevel = boardLevel;
		this.boardOrder = boardOrder;
		this.boardimageSrc = boardimageSrc;
		this.boardType1 = boardType1;
		this.boardType2 = boardType2;
	}


	public BoardDTO(String userId, String boardTitle, String boardContent, String boardimageSrc, String boardType1,
			String boardType2) {
		super();
		this.userId = userId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardimageSrc = boardimageSrc;
		this.boardType1 = boardType1;
		this.boardType2 = boardType2;
	}


	public BoardDTO(Integer boardNo, String userId, Date writeDate, String boardTitle, String boardContent,
			String boardState, Integer boardCount, Integer boardParentNo, Integer boardLevel, Integer boardOrder,
			String boardimageSrc, String boardType1, String boardType2) {
		super();
		this.boardNo = boardNo;
		this.userId = userId;
		this.writeDate = writeDate;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardState = boardState;
		this.boardCount = boardCount;
		this.boardParentNo = boardParentNo;
		this.boardLevel = boardLevel;
		this.boardOrder = boardOrder;
		this.boardimageSrc = boardimageSrc;
		this.boardType1 = boardType1;
		this.boardType2 = boardType2;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", userId=" + userId + ", writeDate=" + writeDate + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", boardState=" + boardState + ", boardCount="
				+ boardCount + ", boardParentNo=" + boardParentNo + ", boardLevel=" + boardLevel + ", boardOrder="
				+ boardOrder + ", boardimageSrc=" + boardimageSrc + ", boardType1=" + boardType1 + ", boardType2="
				+ boardType2 + "]";
	}

	public Integer getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardState() {
		return boardState;
	}

	public void setBoardState(String boardState) {
		this.boardState = boardState;
	}

	public Integer getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(Integer boardCount) {
		this.boardCount = boardCount;
	}

	public Integer getBoardParentNo() {
		return boardParentNo;
	}

	public void setBoardParentNo(Integer boardParentNo) {
		this.boardParentNo = boardParentNo;
	}

	public Integer getBoardLevel() {
		return boardLevel;
	}

	public void setBoardLevel(Integer boardLevel) {
		this.boardLevel = boardLevel;
	}

	public Integer getBoardOrder() {
		return boardOrder;
	}

	public void setBoardOrder(Integer boardOrder) {
		this.boardOrder = boardOrder;
	}

	public String getBoardimageSrc() {
		return boardimageSrc;
	}

	public void setBoardimageSrc(String boardimageSrc) {
		this.boardimageSrc = boardimageSrc;
	}

	public String getBoardType1() {
		return boardType1;
	}

	public void setBoardType1(String boardType1) {
		this.boardType1 = boardType1;
	}

	public String getBoardType2() {
		return boardType2;
	}

	public void setBoardType2(String boardType2) {
		this.boardType2 = boardType2;
	}




    
 
    
	
    
}