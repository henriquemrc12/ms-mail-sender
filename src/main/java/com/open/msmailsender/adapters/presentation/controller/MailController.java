package com.open.msmailsender.adapters.presentation.controller;

import com.open.msmailsender.adapters.presentation.mapper.MailMapper;
import com.open.msmailsender.adapters.presentation.request.MailRequest;
import com.open.msmailsender.adapters.presentation.validation.MailValidation;
import com.open.msmailsender.domain.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService service;

    @PostMapping
    public ResponseEntity<?> sendMail(@RequestBody MailRequest request) throws Exception {
        MailValidation.validate(request);

        if(request.getIsAsync()) {
            service.sendMailAsync(MailMapper.map(request));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return ResponseEntity.ok().body(service.sendMail(MailMapper.map(request)));
    }
}
