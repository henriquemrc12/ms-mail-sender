package com.open.msmailsender.adapters.presentation.mapper;

import com.open.msmailsender.adapters.presentation.request.MailRequest;
import com.open.msmailsender.domain.entities.Mail;

public final class MailMapper {

    public static Mail map(MailRequest request){
        return Mail.builder()
                .to(request.getTo().trim())
                .cc(request.getCc())
                .content(request.getContent().trim())
                .subject(request.getSubject().trim())
                .isHtml(request.getIsHtml())
                .isAsync(request.getIsAsync())
                .build();
    }
}
