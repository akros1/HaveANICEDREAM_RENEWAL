package mail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "mail/sendrand", urlPatterns = { "/mail/sendrand.do" })
public class MailSendRandnumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter printWriter = response.getWriter();

		String rand = request.getParameter("rand");
		String mailAddr = request.getParameter("mail");
		
		String subject = "[HaveANiceDream] 이메일을 인증해주세요!";
		String body = " 안녕하세요 [HaveANiceDream] 입니다. \n  이메일 인증을 위해 인증번호 ["+rand+"]을 입력해주세요. \n 감사합니다!";
		
		Mail mail = new Mail(mailAddr, subject, body);
		
		try {
			Mailsender.sendMail(mail);
		} catch (MessagingException e) {
			printWriter.println("인증번호 전송실패! 다시 번호를 받아주세요");
			e.printStackTrace();
		}
		
		printWriter.println("이메일을 통해 받은 인증번호를 입력해주세요");
	}

}
