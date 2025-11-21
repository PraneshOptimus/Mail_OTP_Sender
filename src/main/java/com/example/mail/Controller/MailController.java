package com.example.mail.Controller;


import com.example.mail.Model.MailEntity;
import com.example.mail.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/send")
public class MailController {

    @Autowired
    MailService mailService;

    @PostMapping
    public String sendMail(@RequestBody MailEntity mail){
        int otp = new Random().nextInt(10000,100000);
        String body = "Your Generated OTP is : ";
        String subject = "Verification for Email Testing ! ";
        return mailService.mailTo(mail, body, subject, otp);
    }



}
