package category.dto;
public class CategoryDetailDTO {

    private Integer categoryDetailNo;

    private String categoryDetailName;

    private Integer categoryNo;
    
    public CategoryDetailDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDetailDTO(Integer categoryDetailNo, String categoryDetailName, Integer categoryNo) {
		super();
		this.categoryDetailNo = categoryDetailNo;
		this.categoryDetailName = categoryDetailName;
		this.categoryNo = categoryNo;
	}

	public Integer getCategoryDetailNo() {
		return categoryDetailNo;
	}

	public void setCategoryDetailNo(Integer categoryDetailNo) {
		this.categoryDetailNo = categoryDetailNo;
	}

	public String getCategoryDetailName() {
		return categoryDetailName;
	}

	public void setCategoryDetailName(String categoryDetailName) {
		this.categoryDetailName = categoryDetailName;
	}

	public Integer getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Integer categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "CategoryDetailDTO [categoryDetailNo=" + categoryDetailNo + ", categoryDetailName=" + categoryDetailName
				+ ", categoryNo=" + categoryNo + "]";
	}
    
    
}