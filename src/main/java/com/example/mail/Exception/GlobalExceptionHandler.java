package com.example.mail.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserException> Specific_1(OtpExpiredException otpExpiredException,
                                                             WebRequest webRequest){
        UserException errorHandler = new UserException(
                LocalDateTime.now(),
                otpExpiredException.getMessage(),
                webRequest.getDescription(false),
                "OTP_EXPIRED"
        );
        return new ResponseEntity<>(errorHandler, HttpStatus.OK);
    }
    @ExceptionHandler
    public ResponseEntity<UserException> Global_Exception(Exception globalException,
                                                    WebRequest webRequest){
        UserException errorHandler = new UserException(
                LocalDateTime.now(),
                globalException.getMessage(),
                webRequest.getDescription(false),
                "OTP_EXPIRED"
        );
        return new ResponseEntity<>(errorHandler, HttpStatus.OK);
    }
}
