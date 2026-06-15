package com.lab5.util;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mailer {

    private static final String GMAIL_USERNAME = "anhptty00148@gmail.com";
    private static final String GMAIL_PASSWORD = "tghvwaqyolqdnscr";

    public static void send(String from, String to, String subject, String body) {
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(GMAIL_USERNAME, GMAIL_PASSWORD);
            }
        });

        try {
            MimeMessage mail = new MimeMessage(session);
            mail.setFrom(new InternetAddress(from));
            mail.setRecipients(RecipientType.TO, to);
            mail.setSubject(subject, "utf-8");
            mail.setText(body, "utf-8", "html");
            mail.setReplyTo(mail.getFrom());

            Transport.send(mail);
            System.out.println("Send mail success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
