package user.block.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import user.block.dto.BlockDTO;

public interface BlockDAO {
	int blockInsert(BlockDTO block, Connection connection) throws SQLException;

	int blockDelete(String userId, Connection connection) throws SQLException;

	ArrayList<BlockDTO> blockList(Connection connection) throws SQLException;

}
