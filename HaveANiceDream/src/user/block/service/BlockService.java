package user.block.service;

import java.util.ArrayList;

import user.block.dto.BlockDTO;

public interface BlockService {
	int blockInsert(BlockDTO block);
	int blockDelete(String userId);
	ArrayList<BlockDTO> blockList();

}
