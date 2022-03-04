package com.open.msmailsender.adapters.presentation.validation;

import com.open.msmailsender.adapters.presentation.request.MailRequest;
import com.open.msmailsender.domain.exception.CustomException;

import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MailValidation {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Consumer<String> MAIL_VALIDATE = emailStr -> {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
            boolean isValid = matcher.find();
            if(!isValid) try {
                throw new CustomException(String.format("'%s' is invalid mail in Cc", emailStr));
            } catch (CustomException e) {
                e.printStackTrace();
            }
    };

    public static void validate(MailRequest request){
        try {
            request.getCc().forEach(MAIL_VALIDATE);
            return;
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
