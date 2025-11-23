package com.example.mail.Controller;


import com.example.mail.Model.MailEntity;
import com.example.mail.Model.OTP;
import com.example.mail.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;

@RestController
public class MailController {

    @Autowired
    MailService mailService;

    @Autowired
    OTP otpData;

    @PostMapping("/sendOtp")
    public String sendMail(@RequestBody MailEntity mail){

        SecureRandom random = new SecureRandom();
        String otp = String.valueOf(100000 + random.nextInt(900000));

        otpData.setOtp(otp);
        otpData.setCreatedAt(LocalDateTime.now());

        String body = "Your Generated OTP is : "+otp+"\n\nNote :- \n* This Otp only valid for 5 Minutes *";
        String subject = "Verification for Email Testing ! ";

        return mailService.mailTo(mail, body, subject);
    }

    @PostMapping("/verifyOtp")
    public String validateOtp(@RequestParam("otp") String userOtp){
        return mailService.validate(otpData, userOtp);
    }

}
