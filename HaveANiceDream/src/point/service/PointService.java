package point.service;

import java.util.ArrayList;

import point.dto.PointDTO;

public interface PointService {
	int pointInsert(PointDTO point);
	ArrayList<PointDTO> pointList(String userId);
	int pointTradeInc(String userid, int point);
	int pointTradeDec(String userid, int point);

}
