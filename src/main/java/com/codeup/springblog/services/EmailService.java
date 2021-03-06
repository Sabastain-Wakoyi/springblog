//package com.codeup.springblog.services;
//
//import com.codeup.springblog.models.Book;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service("mailService")
//public class EmailService {
//
//    @Autowired
//    public JavaMailSender emailSender;
//
//    @Value("${spring.mail.from}")
//    private String from;
//
//    public void prepareAndSend(String subject, String body) {
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom(from);
//        msg.setTo("david@codeup.com");
//        msg.setSubject(subject);
//        msg.setText(body);
//
//        try{
//            this.emailSender.send(msg);
//        }
//        catch (MailException ex) {
//            // simply log it and go on...
//            System.err.println(ex.getMessage());
//        }
//    }
//}

// above is instructor lectures
//below is exercise

package com.codeup.springblog.services;

import com.codeup.springblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {
    @Autowired
    public JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSend(Post post, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(post.getUser().getEmail());
        msg.setSubject(subject);
        msg.setText(body);

       try {
            this.mailSender.send(msg);
        }
       catch (MailException ex){
           // simply log it and go on...
           System.err.println(ex.getMessage());
       }
    }

    public void prepareAndSend(String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo("hope@user.com");
        msg.setSubject(subject);
        msg.setText(body);

        try {
            this.mailSender.send(msg);
        }
        catch (MailException ex){
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }


    }

