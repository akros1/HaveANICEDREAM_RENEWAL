package point.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import point.dao.PointDAO;
import point.dao.PointDAOImpl;
import point.dto.PointDTO;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;

public class PointServiceImpl implements PointService {

	@Override
	public ArrayList<PointDTO> pointList(String userId) {
		ArrayList<PointDTO> list = null;

		Connection connection = null;
		PointDAO dao = new PointDAOImpl();

		try {
			connection = DBUtil.getConnect();
			list = dao.pointList(userId, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}

		return list;
	}

	@Override
	public int pointInsert(PointDTO point) {
		int rowNum = 0;
		Connection connection = null;
		boolean state = false;

		try {
			connection = DBUtil.getConnect();
			connection.setAutoCommit(false);

			PointDAO pointDAO = new PointDAOImpl();
			rowNum = pointDAO.pointInsert(point, connection);

			UserDAO userDAO = new UserDAOImpl();
			int totalPoint = userDAO.userGetPoint(point.getUserId(), connection);
			rowNum += userDAO.userUpdatePoint((totalPoint + point.getPoint()), point.getUserId(), connection);

			state = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {

				if (state) {
					connection.commit();
				} else {
					connection.rollback();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			DBUtil.close(connection);
		}

		return rowNum;
	}

	@Override
	public int pointTradeInc(String userid, int point) {
		PointDTO pointdto = new PointDTO(userid, "드림", point);
		return pointInsert(pointdto);
	}

	@Override
	public int pointTradeDec(String userid, int point) {
		PointDTO pointdto = new PointDTO(userid, "드림 받음", point * (-1));
		System.out.println(pointdto);
		return pointInsert(pointdto);
	}

}
