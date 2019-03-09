package user.block.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import user.block.dto.BlockDTO;
import user.block.query.BlockQuery;

public class BlockDAOImpl implements BlockDAO {

	@Override
	public int blockInsert(BlockDTO block, Connection connection) throws SQLException {
		int rowNum = 0;

		PreparedStatement preparedStatement = connection.prepareStatement(BlockQuery.BLOCK_INSERT);
		// "insert into member values(?,?,sysdate)";

		preparedStatement.setString(1, block.getUserId());
		preparedStatement.setString(2, block.getBlockReason());

		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public int blockDelete(String userId, Connection connection) throws SQLException {
		int rowNum = 0;

		PreparedStatement preparedStatement = connection.prepareStatement(BlockQuery.BLOCK_DELETE);
		// "delete from block where USER_ID = ?";

		preparedStatement.setString(1, userId);

		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public ArrayList<BlockDTO> blockList(Connection connection) throws SQLException {
		ArrayList<BlockDTO> list = null;
		BlockDTO blockDTO = null;

		PreparedStatement preparedStatement = connection.prepareStatement(BlockQuery.BLOCK_LIST);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			if (list == null) {
				list = new ArrayList<BlockDTO>();
			}

			blockDTO = new BlockDTO(
					resultSet.getString(1), 
					resultSet.getString(2), 
					resultSet.getDate(3)
					);

			list.add(blockDTO);
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);

		return list;
	}

}
