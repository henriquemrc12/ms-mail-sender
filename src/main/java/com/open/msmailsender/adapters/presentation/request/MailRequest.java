package com.open.msmailsender.adapters.presentation.request;

import com.open.msmailsender.domain.exception.CustomException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
public class MailRequest {

    private String to;

    private List<String> cc;

    @Size(min = 1, max = 20)
    private String subject;

    private String content;

    private Boolean isHtml = Boolean.FALSE;

    private Boolean isAsync = Boolean.FALSE;

    public MailRequest(String to, List<String> cc, String subject, String content, Boolean isHtml, Boolean isAsync) throws CustomException {
        if (to == null || to.isBlank()) throw new CustomException("'to' is required");
        if (content == null || content.isBlank()) throw new CustomException("'content' is required");
        if (subject == null || subject.isBlank()) throw new CustomException("'subject' is required");

        this.to = to;
        this.cc = cc;
        this.subject = subject;
        this.content = content;
        this.isHtml = isHtml;
        this.isAsync = isAsync;
    }

    public MailRequest() {}
}
