package com.example.mail.Service;

import com.example.mail.Model.MailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    JavaMailSender mailSender;

    private final String admin = "#YOUR EMAIL"; // Mail which is used to send the message from

    public String mailTo(MailEntity mail,String body, String subject, int otp){
        SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom(admin);
                message.setTo(mail.getToMail());
                message.setText(body+" "+otp);
                message.setSubject(subject);
        mailSender.send(message);
        return "OTP sent Success";
    }

}
