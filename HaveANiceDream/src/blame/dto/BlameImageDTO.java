package blame.dto;

public class BlameImageDTO {
	private Integer imgNo;

	private Integer blameNo;

	private String imgSrc;

	public Integer getImgNo() {
		return imgNo;
	}

	public void setImgNo(Integer imgNo) {
		this.imgNo = imgNo;
	}

	public Integer getBlameNo() {
		return blameNo;
	}

	public void setBlameNo(Integer blameNo) {
		this.blameNo = blameNo;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	@Override
	public String toString() {
		return "BlameImageDTO [imgNo=" + imgNo + ", blameNo=" + blameNo + ", imgSrc=" + imgSrc + "]";
	}

	public BlameImageDTO(Integer imgNo, Integer blameNo, String imgSrc) {
		super();
		this.imgNo = imgNo;
		this.blameNo = blameNo;
		this.imgSrc = imgSrc;
	}
	public BlameImageDTO(){
		
	}
	

}
