package user.block.dto;

import java.sql.Date;

public class BlockDTO {

    private String userId;

    private String blockReason;

    private Date blockDate;
    
    public BlockDTO() {

    }
    
	public BlockDTO(String userId, String blockReason, Date blockDate) {
		super();
		this.userId = userId;
		this.blockReason = blockReason;
		this.blockDate = blockDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBlockReason() {
		return blockReason;
	}

	public void setBlockReason(String blockReason) {
		this.blockReason = blockReason;
	}

	public Date getBlockDate() {
		return blockDate;
	}

	public void setBlockDate(Date blockDate) {
		this.blockDate = blockDate;
	}

	@Override
	public String toString() {
		return "BlockDTO [userId=" + userId + ", blockReason=" + blockReason + ", blockDate=" + blockDate + "]";
	}
    
    
}