package reply.dto;

import java.sql.Date;

public class ReplyDTO {

    private Integer replyNo;

    private Integer borderNo;

    private String replyContent;

    private String userId;

    private Date replyEditDate;
    
    public ReplyDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReplyDTO(Integer replyNo, Integer borderNo, String replyContent, String userId, Date replyEditDate) {
		super();
		this.replyNo = replyNo;
		this.borderNo = borderNo;
		this.replyContent = replyContent;
		this.userId = userId;
		this.replyEditDate = replyEditDate;
	}

	public Integer getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(Integer replyNo) {
		this.replyNo = replyNo;
	}

	public Integer getBorderNo() {
		return borderNo;
	}

	public void setBorderNo(Integer borderNo) {
		this.borderNo = borderNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getReplyEditDate() {
		return replyEditDate;
	}

	public void setReplyEditDate(Date replyEditDate) {
		this.replyEditDate = replyEditDate;
	}

	@Override
	public String toString() {
		return "ReplyDTO [replyNo=" + replyNo + ", borderNo=" + borderNo + ", replyContent=" + replyContent
				+ ", userId=" + userId + ", replyEditDate=" + replyEditDate + "]";
	}
    
    
}