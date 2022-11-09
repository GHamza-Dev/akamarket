package com.akamarket.akamarket.helper;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Date;
import java.util.Properties;

public class Mail {
    private static String from = "gassai.hamza.dev@gmail.com";
    private static String password = "oymgeldbbgjxdkvm";

    public static void send(String to,String subject, String message){
        Properties properties = prepareProperties();

        Session session = prepareSession(properties);

        try{
            MimeMessage mimeMessage = new MimeMessage(session);

            mimeMessage.addHeader("Content-type", "text/HTML; charset=UTF-8");
            mimeMessage.addHeader("format", "flowed");
            mimeMessage.addHeader("Content-Transfer-Encoding", "8bit");

            mimeMessage.setFrom(new InternetAddress(from, "Marjane Market"));
            mimeMessage.setReplyTo(InternetAddress.parse(to, false));

            mimeMessage.setSubject(subject, "UTF-8");
            mimeMessage.setContent(wrapMessage(message), "text/html");
            mimeMessage.setSentDate(new Date());

            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            System.out.println("Sending email...");
            Transport.send(mimeMessage);
            System.out.println("Email sent successfully!");

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private static Session prepareSession(Properties properties){
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
    }

    private static Properties prepareProperties(){
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        return properties;
    }

    private static String wrapMessage(String message){
        return "<div>" +
                "<h1>Marjane Market</h1>" +
                "<div>"+message+"</div>" +
                "</div>";
    }
}
