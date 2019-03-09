package user.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.dto.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceimpl;
import user.dto.MemberDTO;
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet(name = "user/login", urlPatterns = { "/user/login.do" })
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String logtype = request.getParameter("logtype");
		String id = null;
		String url = null;

		UserService service = new UserServiceImpl();
		MemberDTO user = null;

		if (logtype.equals("기본")) {
			id = request.getParameter("id");
			String pass = request.getParameter("pass");
			user = service.userLogin(id, pass);

		} else if (logtype.equals("Kakao") || logtype.equals("Naver") || logtype.equals("Facebook")) {
			id = request.getParameter("SNSid");
			user = service.userSelect(id);
		}

		if (user != null) {
			if (user.getUserType().equals("차단회원")) {
				request.setAttribute("managerMSG", "차단된 회원입니다. 관리자에게 문의주세요.");
				url = "/user/login.html";
			} else if (user.getUserType().equals("탈퇴회원")) {
				url = "/user/login.html";
			} else {
				HttpSession session = request.getSession();
				SimpleDateFormat format = new SimpleDateFormat("MM:dd");

				if (!format.format(user.getUserLastLoginTime()).equals(format.format(new Date()))) {
					session.setAttribute("attFlag", false);
				} else {
					Cookie[] cookies = request.getCookies();

					if (cookies != null) {
						String flag = "";

						for (int i = 0; i < cookies.length; i++) {
							if (cookies[i].getName().equals("attFlag")) {
								flag = cookies[i].getValue();
							}
						}

						if (flag.equals("T")) {
							session.setAttribute("attFlag", true);
						} else {
							session.setAttribute("attFlag", false);
						}
					} else {
						session.setAttribute("attFlag", false);
					}
				}

				session.setAttribute("user", user);
				String viewpath = "temp_main_con.jsp";
				ArrayList<ProductDTO>  productlist = null;
				ProductService productservice = new ProductServiceimpl();
				productlist = productservice.product_List(null,0,0,null,1,6);
				request.setAttribute("productlist", productlist);
				new UserServiceImpl().userUpdateLoginTime(user.getUserId());

				request.setAttribute("viewpath", viewpath);
				url = "/main/main_layout.jsp";
			}
		} else if (logtype.equals("Kakao") || logtype.equals("Naver") || logtype.equals("Facebook")) {
			user = new MemberDTO();

			String SNSemail = request.getParameter("SNSemail");
			String SNSimg = request.getParameter("SNSimg");
			String SNSname = request.getParameter("SNSname");

			user.setUserId(id);
			user.setUserEmail(SNSemail);
			user.setUserName(SNSname);
			user.setUserLogType(logtype);

			if (!SNSimg.equals("")) {
				URL imgurl = new URL(SNSimg);
				BufferedImage bufferedImage = ImageIO.read(imgurl);
				// http://graph.facebook.com/100006497919491/picture?type=large
				// 업로드 경로 구해오기
				String uploadpath = request.getSession().getServletContext().getRealPath("/uploadresources/user/");
				File file = new File(uploadpath + id + ".jpg");
				ImageIO.write(bufferedImage, "jpg", file);

				user.setUserImage(id + ".jpg");
			} else {
				user.setUserImage("ui-sam.jpg");
			}
			String viewpath = "../user/sign_in_page.jsp";

			request.setAttribute("SNSsignup", user);
			request.setAttribute("viewpath", viewpath);

			url = "/main/main_layout.jsp";
		} else {
			url = "/user/login.html";
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);

	}

}
