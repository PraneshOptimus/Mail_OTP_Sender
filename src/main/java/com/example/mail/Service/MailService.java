package com.example.mail.Service;

import com.example.mail.Exception.OtpExpiredException;
import com.example.mail.Model.MailEntity;
import com.example.mail.Model.OTP;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static java.time.LocalTime.now;

@Service
public class MailService {

    @Autowired
    JavaMailSender mailSender;

    private final String admin = "a.pranesh19712005@gmail.com"; // Mail which is used to send the message from

    public String mailTo(MailEntity mail,String body, String subject){
        SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom(admin);
                message.setTo(mail.getToMail());
                message.setText(body);
                message.setSubject(subject);
        mailSender.send(message);
        return "OTP sent Success";
    }

    public String validate(OTP validOtp, String otp) {

        long minutes = ChronoUnit.MINUTES.between(validOtp.getCreatedAt(), LocalDateTime.now());


        if(!validOtp.getOtp().equals(otp)){
            return "OTP IS WRONG";
        }

        if(minutes > 1) throw new OtpExpiredException("OTP Expired Try Agin ! ");

        return "OTP IS VALID";

    }
}
