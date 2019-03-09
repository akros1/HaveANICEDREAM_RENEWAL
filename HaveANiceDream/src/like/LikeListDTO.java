package like;
public class LikeListDTO {

    private String userId;

    private Integer categoryNo;

    private Integer categoryDetailNo;
    
    public LikeListDTO() {
		// TODO Auto-generated constructor stub
	}

	public LikeListDTO(String userId, Integer categoryNo, Integer categoryDetailNo) {
		super();
		this.userId = userId;
		this.categoryNo = categoryNo;
		this.categoryDetailNo = categoryDetailNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Integer categoryNo) {
		this.categoryNo = categoryNo;
	}

	public Integer getCategoryDetailNo() {
		return categoryDetailNo;
	}

	public void setCategoryDetailNo(Integer categoryDetailNo) {
		this.categoryDetailNo = categoryDetailNo;
	}

	@Override
	public String toString() {
		return "LikeListDTO [userId=" + userId + ", categoryNo=" + categoryNo + ", categoryDetailNo=" + categoryDetailNo
				+ "]";
	}
    
    
}