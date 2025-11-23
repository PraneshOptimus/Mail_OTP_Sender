package com.example.mail.Model;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class OTP {

    private String otp ;
    private LocalDateTime createdAt;

    public OTP(String otp, LocalDateTime createdAt) {
        this.otp = otp;
        this.createdAt = createdAt;
    }

    public OTP() {
    }


    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
