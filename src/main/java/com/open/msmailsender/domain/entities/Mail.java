package com.open.msmailsender.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@Setter
public class Mail {

    private String to;

    private List<String> cc;

    private String subject;

    private String content;

    private boolean isHtml;

    private boolean isAsync;
}
