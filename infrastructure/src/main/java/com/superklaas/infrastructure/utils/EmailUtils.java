package com.superklaas.infrastructure.utils;

import com.superklaas.infrastructure.exceptions.InvalidEmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class EmailUtils {
    private static final Logger logger = LoggerFactory.getLogger(EmailUtils.class);

    private static final Pattern VALID_EMAIL_REGEX =Pattern.compile(
    "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    public static boolean isValidEmail(String email) {
        return VALID_EMAIL_REGEX.matcher(email).matches();
    }

    public static void assertIsValidEmailOrThrowException(String email) {
        if (!EmailUtils.isValidEmail(email)) {
            logger.warn("The user tried to register an invalid e-mail");
            throw new InvalidEmailException("The e-mail: " + email + " is invalid");
        }
    }

}
