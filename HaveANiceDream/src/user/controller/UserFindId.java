package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mail.Mail;
import mail.Mailsender;
import user.service.UserServiceImpl;

@WebServlet(name = "user/findid", urlPatterns = { "/user/findid.do" })
public class UserFindId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter printWriter = response.getWriter();

		String mailaddr = request.getParameter("mail");

		ArrayList<String> list = new UserServiceImpl().userFindID(mailaddr);

		if (list != null) {
			String subject = "[HaveANiceDream] 조회된 계정 입니다.";
			String body = " 안녕하세요 [HaveANiceDream] 입니다. \n다음은 해당 이메일로 조회된 계정입니다.\n\t\n\t";
			StringBuffer buffer = new StringBuffer(body);

			int size = list.size();

			for (int i = 0; i < size; i++) {
				buffer.append(list.get(i));
				buffer.append("\n\t");

			}
			buffer.append("\n감사합니다!");

			Mail mail = new Mail(mailaddr, subject, buffer.toString());

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

}
