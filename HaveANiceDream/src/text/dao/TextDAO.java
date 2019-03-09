package text.dao;

import java.sql.Connection;
import java.sql.SQLException;

import text.TextDTO;

public interface TextDAO {
	int insertText(TextDTO text, Connection connection ) throws SQLException;
	int stateText(TextDTO text, Connection connection ) throws SQLException;
}
