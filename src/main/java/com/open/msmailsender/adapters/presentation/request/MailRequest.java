package com.open.msmailsender.adapters.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MailRequest {

    private String to;

    private List<String> cc;

    @Size(min = 1, max = 20)
    private String subject;

    private String content;

    private Boolean isHtml = Boolean.FALSE;

    private Boolean isAsync = Boolean.FALSE;
}
