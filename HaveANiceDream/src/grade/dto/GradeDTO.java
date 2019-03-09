package grade.dto;

import java.util.Date;

public class GradeDTO {

    private Integer gradeNo;

    private String userId;

    private Integer tradeNo;

    private String grade;

    private String gradeType;
    private String gradeContent;
    private Date gradeDate;
    private String gradeUserId;
	public GradeDTO(Integer gradeNo, String userId, Integer tradeNo, String grade, String gradeType,
			String gradeContent, Date gradeDate, String gradeUserId) {
		super();
		this.gradeNo = gradeNo;
		this.userId = userId;
		this.tradeNo = tradeNo;
		this.grade = grade;
		this.gradeType = gradeType;
		this.gradeContent = gradeContent;
		this.gradeDate = gradeDate;
		this.gradeUserId = gradeUserId;
	}
	@Override
	public String toString() {
		return "GradeDTO [gradeNo=" + gradeNo + ", userId=" + userId + ", tradeNo=" + tradeNo + ", grade=" + grade
				+ ", gradeType=" + gradeType + ", gradeContent=" + gradeContent + ", gradeDate=" + gradeDate
				+ ", gradeUserId=" + gradeUserId + "]";
	}
	public Integer getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(Integer gradeNo) {
		this.gradeNo = gradeNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(Integer tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGradeType() {
		return gradeType;
	}
	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}
	public String getGradeContent() {
		return gradeContent;
	}
	public void setGradeContent(String gradeContent) {
		this.gradeContent = gradeContent;
	}
	public Date getGradeDate() {
		return gradeDate;
	}
	public void setGradeDate(Date gradeDate) {
		this.gradeDate = gradeDate;
	}
	public String getGradeUserId() {
		return gradeUserId;
	}
	public void setGradeUserId(String gradeUserId) {
		this.gradeUserId = gradeUserId;
	}
	
}