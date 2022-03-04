package com.open.msmailsender.adapters.service;

import com.open.msmailsender.adapters.presentation.response.MailResponse;
import com.open.msmailsender.domain.entities.Mail;
import com.open.msmailsender.domain.service.MailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    public MailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public MailResponse sendMail(Mail request) throws MessagingException {
        try {


            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail);

            helper.setTo(request.getTo());
            if(request.getCc() != null && request.getCc().size() > 0) {
                String[] ccList = request.getCc().toArray(new String[0]);
                helper.setCc(ccList);
            }
            helper.setSubject(request.getSubject());
            helper.setText(request.getContent(), request.isHtml());
            mailSender.send(mail);
            return MailResponse.builder().sent(true).build();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Async
    @Override
    public void sendMailAsync(Mail request) {
        try {

            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail);

            helper.setTo(request.getTo());
            if(request.getCc() != null && request.getCc().size() > 0) {
                String[] ccList = request.getCc().toArray(new String[0]);
                helper.setCc(ccList);
            }
            helper.setSubject(request.getSubject());
            helper.setText(request.getContent(), request.isHtml());
            mailSender.send(mail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
