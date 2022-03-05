package com.open.msmailsender.adapters.presentation.validation;

import com.open.msmailsender.adapters.presentation.request.MailRequest;
import com.open.msmailsender.domain.exception.CException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MailValidation {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static void validate(MailRequest request) {
        try {
            List<String> errorList = new ArrayList<>();

            if(request.getTo() == null || request.getTo().isBlank()) {
                String error = "'to' is required";
                errorList.add(error);
            } else {
                String mail = request.getTo();
                Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mail);
                boolean isValid = matcher.find();
                if(!isValid) {
                    String error = String.format("'%s' is a invalid mail in 'to'", mail);
                    errorList.add(error);
                }
            }

            if(request.getSubject() == null || request.getSubject().isBlank()) {
                String error = "'subject' is required";
                errorList.add(error);
            }

            if(request.getContent() == null || request.getContent().isBlank()) {
                String error = "'content' is required";
                errorList.add(error);
            }

            if(request.getCc() != null && request.getCc().size() > 0) {
                request.getCc().forEach(mail -> {
                    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mail);
                    boolean isValid = matcher.find();
                    if(!isValid) {
                        String error = String.format("'%s' is a invalid mail in 'cc'", mail);
                        errorList.add(error);
                    }
                });
            }

            if(errorList.size() > 0)
                throw new CException(errorList);

            return;
        } catch (CException e) {
            throw e;
        }
    }
}
