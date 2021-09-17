package com.hegzo.LoginRegisterEmailVer.mail;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
@AllArgsConstructor
public class EmailService implements EmailSender{

    private final JavaMailSender mailSender;
    private final static Logger LOGGER =
            LoggerFactory.getLogger(EmailService.class);

    @Override
    @Async
    public void send(String to, String email) {

        try {

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMessageHelper.setText(email, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Confirm your email");
            mimeMessageHelper.setFrom("engahmedhegazy2025@gmail.com");
            mailSender.send(mimeMessage);

        }catch (MessagingException messagingException){
            LOGGER.error("failed to send message", messagingException);
            throw new IllegalStateException("failed to send message");
        }
    }
}
