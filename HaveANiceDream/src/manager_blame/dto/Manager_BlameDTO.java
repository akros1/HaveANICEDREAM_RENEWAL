package manager_blame.dto;

import java.sql.Date;

public class Manager_BlameDTO {

	private Integer answerNo;
	
	private Integer blameNo;
	
	private String userId;

    private String answerTitle;

    private String answerContent;

    private Date answerDate;

	public Integer getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(Integer answerNo) {
		this.answerNo = answerNo;
	}

	public Integer getBlameNo() {
		return blameNo;
	}

	public void setBlameNo(Integer blameNo) {
		this.blameNo = blameNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAnswerTitle() {
		return answerTitle;
	}

	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	@Override
	public String toString() {
		return "Manager_BlameDTO [answerNo=" + answerNo + ", blameNo=" + blameNo + ", userId=" + userId
				+ ", answerTitle=" + answerTitle + ", answerContent=" + answerContent + ", answerDate=" + answerDate
				+ "]";
	}

	public Manager_BlameDTO(Integer answerNo, Integer blameNo, String userId, String answerTitle, String answerContent,
			Date answerDate) {
		super();
		this.answerNo = answerNo;
		this.blameNo = blameNo;
		this.userId = userId;
		this.answerTitle = answerTitle;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
	}
	public Manager_BlameDTO(int blameNo,String userId,String answerTitle, String answerContent
		) {
		super();
		this.blameNo = blameNo;
		this.userId = userId;
		this.answerTitle = answerTitle;
		this.answerContent = answerContent;
		
	}
	


	
}