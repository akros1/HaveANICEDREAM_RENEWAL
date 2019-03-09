package point.dto;

import java.sql.Date;

public class PointDTO {

    private Integer pointNo;

    private String userId;

    private Date pointDate;

    private String pointType;

    private Integer point;
    
    public PointDTO() {
    	
	}
    
    

	public PointDTO(String userId, String pointType, Integer point) {
		super();
		this.userId = userId;
		this.pointType = pointType;
		this.point = point;
	}



	public PointDTO(Integer pointNo, String userId, Date pointDate, String pointType, Integer point) {
		super();
		this.pointNo = pointNo;
		this.userId = userId;
		this.pointDate = pointDate;
		this.pointType = pointType;
		this.point = point;
	}

	public Integer getPointNo() {
		return pointNo;
	}

	public void setPointNo(Integer pointNo) {
		this.pointNo = pointNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getPointDate() {
		return pointDate;
	}

	public void setPointDate(Date pointDate) {
		this.pointDate = pointDate;
	}

	public String getPointType() {
		return pointType;
	}

	public void setPointType(String pointType) {
		this.pointType = pointType;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "PointDTO [pointNo=" + pointNo + ", userId=" + userId + ", pointDate=" + pointDate + ", pointType="
				+ pointType + ", point=" + point + "]";
	}
    
}