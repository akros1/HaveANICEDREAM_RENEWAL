package user.service;

import java.util.ArrayList;

import user.dto.MemberDTO;

public interface UserService {
	int userInsert(MemberDTO user);

	ArrayList<MemberDTO> userList(int type, String condition);

	MemberDTO userSelect(String userId);

	MemberDTO userLogin(String userId, String userPw);

	int userDelete(String userId);

	int userUpdateType(String userId, String userType);

	int userUpdateLoginTime(String userId);

	boolean idCheck(String userId);

	int userUpdate(MemberDTO user);
	
	int userUpdatePass(String userId, String oldPass, String newPass);

	ArrayList<String> userFindID(String userEmail);

	int userFindPass(String userId, String userEmail, String userPass);
}
