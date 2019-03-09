package user.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import user.dto.MemberDTO;
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "user/update1", urlPatterns = { "/user/update1.do" })
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String saveFolder = "/uploadresources/user";
		String encType = "utf-8";
		int size = 5 * 1024 * 1024;// (5mb)
		String realPath = "";

		ServletContext context = getServletContext();
		realPath = context.getRealPath(saveFolder);

		MultipartRequest multipartRequest = new MultipartRequest(request, realPath, size, encType,
				new DefaultFileRenamePolicy());

		String userPw = multipartRequest.getParameter("userPw");
		String userEmail = multipartRequest.getParameter("userEmail1") + multipartRequest.getParameter("userEmail2");
		String userName = multipartRequest.getParameter("userName");
		String userZipcode = multipartRequest.getParameter("userZipcode");
		String userAddr = multipartRequest.getParameter("userAddr1");
		String userAddrDetail = multipartRequest.getParameter("userAddr2");
		String userTel = multipartRequest.getParameter("userTel1") + "-" + multipartRequest.getParameter("userTel2")
				+ "-" + multipartRequest.getParameter("userTel3");

		HttpSession session = request.getSession(false);
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		String userId = dto.getUserId();
		String fileNeme = null;

		@SuppressWarnings("unchecked")
		Enumeration<String> files = multipartRequest.getFileNames();
		
		if (files.hasMoreElements()) {
			String file = files.nextElement();
			fileNeme = multipartRequest.getFilesystemName(file);
			if (fileNeme == null){
				fileNeme = dto.getUserImage();
			}
		}
		
		System.out.println(fileNeme);

		MemberDTO user = new MemberDTO(userId, userPw, userEmail, userName, userZipcode, userAddr, userAddrDetail,
				userTel, fileNeme);
		
		UserService service = new UserServiceImpl();
		int res = service.userUpdate(user);

		if (res > 0) {
			dto = service.userSelect(userId);
			session.setAttribute("user", dto);
		}

		String viewpath = "../user/user_detail.jsp";

		request.setAttribute("viewpath", viewpath);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/main_layout.jsp");
		requestDispatcher.forward(request, response);

	}

}
