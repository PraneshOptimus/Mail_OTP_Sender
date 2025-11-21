package com.example.mail.Model;

public class MailEntity {


    String toMail;

    public MailEntity(String toMail, String subject, String body) {
        this.toMail = toMail;
    }

    public MailEntity() {
    }

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

}
