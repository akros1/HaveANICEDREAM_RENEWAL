package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import fw.LoggableStatement;
import user.dto.MemberDTO;
import user.query.UserQuery;

/*Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
USER_ID                                   NOT NULL VARCHAR2(20)
USER_PW                                            VARCHAR2(20)
USER_EMAIL                                         VARCHAR2(200)
USER_NAME                                          VARCHAR2(20)
USER_ZIPCODE                                       VARCHAR2(5)
USER_ADDR                                          VARCHAR2(200)
USER_ADDR_DETAIL                                   VARCHAR2(20)
USER_TEL                                           VARCHAR2(20)
USER_SIGDATE                                       DATE
USER_LOG_TYPE                                      VARCHAR2(20)
USER_LAST_LOGIN_TIME                               DATE
USER_IMAGE                                         VARCHAR2(20)
POINT_TOTAL                                        NUMBER
USER_TYPE                                          VARCHAR2(20)
*/

public class UserDAOImpl implements UserDAO {

	@Override
	public int userInsert(MemberDTO user, Connection connection) throws SQLException {
		int rowNum = 0;
		PreparedStatement preparedStatement = null;

		preparedStatement = connection.prepareStatement(UserQuery.USER_INSERT);
		// "insert into member values(?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?)";

		preparedStatement.setString(1, user.getUserId());
		preparedStatement.setString(2, user.getUserPw());
		preparedStatement.setString(3, user.getUserEmail());
		preparedStatement.setString(4, user.getUserName());
		preparedStatement.setString(5, user.getUserZipcode());
		preparedStatement.setString(6, user.getUserAddr());
		preparedStatement.setString(7, user.getUserAddrDetail());
		preparedStatement.setString(8, user.getUserTel());
		preparedStatement.setString(9, user.getUserLogType());
		preparedStatement.setString(10, user.getUserImage());
		preparedStatement.setInt(11, user.getPointTotal());
		preparedStatement.setString(12, user.getUserType());

		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public ArrayList<MemberDTO> userList(int type, String condition, Connection connection) throws SQLException {
		ArrayList<MemberDTO> list = null;
		MemberDTO dto = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		if (type == 1) {
			preparedStatement = connection.prepareStatement(UserQuery.USER_SERCH_ID);
			preparedStatement.setString(1, "%" + condition + "%");
		} else if (type == 2) {
			preparedStatement = connection.prepareStatement(UserQuery.USER_SERCH_NAME);
			preparedStatement.setString(1, "%" + condition + "%");
		} else {
			preparedStatement = connection.prepareStatement(UserQuery.USER_LIST);
			// "select * from member";
		}

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			if (list == null) {
				list = new ArrayList<MemberDTO>();
			}

			dto = new MemberDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
					resultSet.getString(8), resultSet.getDate(9), resultSet.getString(10), resultSet.getDate(11),
					resultSet.getString(12), resultSet.getInt(13), resultSet.getString(14));

			list.add(dto);
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);

		return list;
	}

	@Override
	public MemberDTO userSelect(String userId, Connection connection) throws SQLException {
		MemberDTO dto = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		preparedStatement = connection.prepareStatement(UserQuery.USER_SELECT);
		// "select * from member where USER_ID = ?";

		preparedStatement.setString(1, userId);

		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			dto = new MemberDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
					resultSet.getString(8), resultSet.getDate(9), resultSet.getString(10), resultSet.getDate(11),
					resultSet.getString(12), resultSet.getInt(13), resultSet.getString(14));
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);

		return dto;
	}

	@Override
	public MemberDTO userLogin(String userId, String userPw, Connection connection) throws SQLException {
		MemberDTO dto = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		preparedStatement = connection.prepareStatement(UserQuery.USER_LOGIN);
		// "select * from member where USER_ID = ? and USER_PW = ?";

		preparedStatement.setString(1, userId);
		preparedStatement.setString(2, userPw);

		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			dto = new MemberDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
					resultSet.getString(8), resultSet.getDate(9), resultSet.getString(10), resultSet.getDate(11),
					resultSet.getString(12), resultSet.getInt(13), resultSet.getString(14));
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);

		return dto;
	}

	@Override
	public int userDelete(String userId, Connection connection) throws SQLException {
		int rowNum = 0;

		PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.USER_DELETE);
		// "delete from member where USER_ID = ?";

		preparedStatement.setString(1, userId);

		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public int userUpdateType(String userId, String userType, Connection connection) throws SQLException {
		int rowNum = 0;

		PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.USER_TYPE_UPDATE);
		// "update member set USER_TYPE = ? where USER_ID = ?";

		preparedStatement.setString(1, userType);
		preparedStatement.setString(2, userId);

		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public int userUpdatePoint(int pointTotal, String userId, Connection connection) throws SQLException {
		int rowNum = 0;

		PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.USER_POINT_UPDATE);
		// "update member set POINT_TOTAL = ? where USER_ID = ?";

		preparedStatement.setInt(1, pointTotal);
		preparedStatement.setString(2, userId);

		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public int userGetPoint(String userId, Connection connection) throws SQLException {
		int pointTotal = 0;

		PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.USER_GET_POINT);
		// "select POINT_TOTAL from member where USER_ID = ?";

		preparedStatement.setString(1, userId);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			pointTotal = resultSet.getInt(1);
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);

		return pointTotal;
	}

	@Override
	public int userUpdateLoginTime(String userId, Connection connection) throws SQLException {
		int rowNum = 0;

		PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.USER_LOGINTIME_UPDATE);
		// "update member set USER_LAST_LOGIN_TIME = sysdate where USER_ID = ?";

		preparedStatement.setString(1, userId);

		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public boolean idCheck(String userId, Connection connection) throws SQLException {
		boolean check = false;

		PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.USER_SELECT);

		preparedStatement.setString(1, userId);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			check = true;
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);

		return check;
	}

	@Override
	public int userUpdate(MemberDTO user, Connection connection) throws SQLException {
		int rowNum = 0;
		PreparedStatement preparedStatement = null;

		preparedStatement = connection.prepareStatement(UserQuery.USER_UPDATE);
		// "UPDATE member "
		// + "SET "
		// + "USER_PW = ?, "
		// + "USER_NAME = ?, "
		// + "USER_EMAIL = ?, "
		// + "USER_ZIPCODE = ?, "
		// + "USER_ADDR = ?, "
		// + "USER_ADDR_DETAIL = ?, "
		// + "USER_TEL = ? "
		// + "USER_IMAGE = ? "
		// + "WHERE USER_ID = ?";

		preparedStatement.setString(1, user.getUserPw());
		preparedStatement.setString(2, user.getUserName());
		preparedStatement.setString(3, user.getUserEmail());
		preparedStatement.setString(4, user.getUserZipcode());
		preparedStatement.setString(5, user.getUserAddr());
		preparedStatement.setString(6, user.getUserAddrDetail());
		preparedStatement.setString(7, user.getUserTel());
		preparedStatement.setString(8, user.getUserImage());
		preparedStatement.setString(9, user.getUserId());

		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public int userUpdatePass(String userId, String oldPass, String newPass, Connection connection)
			throws SQLException {
		int rowNum = 0;

		PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.USER_PASS_UPDATE);
		// "update member set USER_PW = ? where USER_ID = ? and USER_PW = ?";

		preparedStatement.setString(1, newPass);
		preparedStatement.setString(2, userId);
		preparedStatement.setString(3, oldPass);

		rowNum = preparedStatement.executeUpdate();

		DBUtil.close(preparedStatement);

		return rowNum;
	}

	@Override
	public ArrayList<String> userFindID(String userEmail, Connection connection) throws SQLException {
		ArrayList<String> list = null;

		PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.USER_FIND_ID);
		// "select substr(user_id,1,length(user_id)-3)||lpad('*',3,'*') from
		// member where USER_EMAIL = ?";
		preparedStatement.setString(1, userEmail);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			if (list == null) {
				list = new ArrayList<String>();
			}

			list.add(resultSet.getString(1));
		}

		DBUtil.close(resultSet);
		DBUtil.close(preparedStatement);
		
		return list;
	}

	@Override
	public int userFindPass(String userId, String userEmail, String userPass, Connection connection)
			throws SQLException {
		int res = 0;
		PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.USER_FIND_PASS);
		//"update member set USER_PW = ? where USER_ID = ? and USER_EMAIL = ?";
	
		preparedStatement.setString(1, userPass);
		preparedStatement.setString(2, userId);
		preparedStatement.setString(3, userEmail);
		
		res  = preparedStatement.executeUpdate();
		
		DBUtil.close(preparedStatement);
		
		return res;
	}

}
