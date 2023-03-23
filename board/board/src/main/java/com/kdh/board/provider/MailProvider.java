package com.kdh.board.provider;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailProvider {

    private JavaMailSender javaMailSender;

    public boolean sendMail() {
        
        try {
            SimpleMailMessage simpleMaiilMessage = new SimpleMailMessage();
            simpleMaiilMessage.setFrom("1122030@donga.ac.kr");
            simpleMaiilMessage.setTo("bold20020@gmail.com");
            simpleMaiilMessage.setSubject("제목");
            simpleMaiilMessage.setText("<p style = 'color: red;'>html 형식의 내용");
            javaMailSender.send(simpleMaiilMessage);
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
