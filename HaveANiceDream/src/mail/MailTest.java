package mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class MailTest {

	public static void main(String[] args) {
		Mail mail = new Mail("jsy901001@gmail.com", "TEST입니다", "tttesstt라고요~!");
		
		try {
			Mailsender.sendMail(mail);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
