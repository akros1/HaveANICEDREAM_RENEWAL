package category.dto;
public class CategoryDTO {

    private Integer categoryNo;

    private String categoryName;
    
    public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(Integer categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}

	public Integer getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Integer categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}
    
    
}