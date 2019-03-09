package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mail.Mail;
import mail.Mailsender;
import user.service.UserServiceImpl;

@WebServlet(name = "user/findpass", urlPatterns = { "/user/findpass.do" })
public class UserFindPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter printWriter = response.getWriter();

		String mailaddr = request.getParameter("mail");
		String userid = request.getParameter("userid");

		String pass = UserFindPassServlet.generateNumber(6) + "";

		int res = new UserServiceImpl().userFindPass(userid, mailaddr, pass);

		if (res != 0) {
			String subject = "[HaveANiceDream] 임시 비밀번호가 발급 되었습니다.";
			String body = " 안녕하세요 [HaveANiceDream] 입니다. \n발급된 임시 비밀번호는 [" + pass + "]입니다.\n감사합니다!";

			Mail mail = new Mail(mailaddr, subject, body);

			try {
				Mailsender.sendMail(mail);
			} catch (MessagingException e) {
				printWriter.println("메일 전송에 실패했습니다 ㅠㅠ");
				e.printStackTrace();
			}
			printWriter.println("전송완료!! 메일함을 확인해주세요!");
		} else {
			printWriter.println("조회된 계정이 없습니다. 가입해주세요 :D");
		}

	}

	public static int generateNumber(int length) {

		String numStr = "1";
		String plusNumStr = "1";

		for (int i = 0; i < length; i++) {
			numStr += "0";

			if (i != length - 1) {
				plusNumStr += "0";
			}
		}

		Random random = new Random();
		int result = random.nextInt(Integer.parseInt(numStr)) + Integer.parseInt(plusNumStr);

		if (result > Integer.parseInt(numStr)) {
			result = result - Integer.parseInt(plusNumStr);
		}

		return result;
	}

}
