package infra;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import config.EmailConfig;

public class EmailSender {

    public void send(String recipient, String subject, String content) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(EmailConfig.MY_EMAIL, EmailConfig.MY_PASSWORD));
        email.setSSLOnConnect(true);

        email.setFrom("phuocpham044@gmail.com");
        email.setSubject(subject);
        email.setMsg(content);
        email.addTo(recipient);
        email.send();
    }
}
