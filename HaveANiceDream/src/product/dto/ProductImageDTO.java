package product.dto;
public class ProductImageDTO {

    private Integer imageNo;

    private Integer productNo;

    private String imageSrc;
    
    public ProductImageDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductImageDTO(Integer imageNo, Integer productNo, String imageSrc) {
		super();
		this.imageNo = imageNo;
		this.productNo = productNo;
		this.imageSrc = imageSrc;
	}

	public Integer getImageNo() {
		return imageNo;
	}

	public void setImageNo(Integer imageNo) {
		this.imageNo = imageNo;
	}

	public Integer getProductNo() {
		return productNo;
	}

	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	@Override
	public String toString() {
		return "ProductImageDTO [imageNo=" + imageNo + ", productNo=" + productNo + ", imageSrc=" + imageSrc + "]";
	}
    
    
}