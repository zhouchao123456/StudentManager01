package com.qfedu.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.Transport;

public class EmailUtil {
    private Properties properties;
    private Session  session;
    private MimeMessage message;

    public EmailUtil(String smtpHost,String port,String username,String password){
        AuthUtil authUtil = new AuthUtil(username, password);

        properties = System.getProperties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");

        session = Session.getInstance(properties, authUtil);

    }

    public boolean sendMail(String src,String target,String theme,String content){
        message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(src));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(target));
            message.setSubject(theme,"utf-8");
            message.setContent(content,"text/html;charset=utf-8");

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;


    }


}
