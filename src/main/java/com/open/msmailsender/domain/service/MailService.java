package com.open.msmailsender.domain.service;

import com.open.msmailsender.adapters.presentation.response.MailResponse;
import com.open.msmailsender.domain.entities.Mail;

import javax.mail.MessagingException;

public interface MailService {
    MailResponse sendMail(Mail mail) throws MessagingException;
    void sendMailAsync(Mail mail);
}
