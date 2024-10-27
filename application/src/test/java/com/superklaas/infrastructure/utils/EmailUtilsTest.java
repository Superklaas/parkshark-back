package com.superklaas.infrastructure.utils;

import com.superklaas.infrastructure.exceptions.InvalidEmailException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EmailUtilsTest {
    EmailUtils emailUtils = new EmailUtils();


    @ParameterizedTest
    @ValueSource(strings = {"user@domain.com", "user@domain.co.in", "user.name@domain.com", "user_name@domain.com",
            "username@yahoo.corporate.in"})
    void isValidEmail_givenValidEmails_ThenReturnsTrue(String input) throws Exception {
        //Given

        //When & Then
        EmailUtils.assertIsValidEmailOrThrowException(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {".username@yahoo.com", "username@yahoo.com.", "username@yahoo..com", "username@yahoo.c",
            "username@yahoo.corporate"})
    void isValidEmail_givenInvalidEmails_ThenThrowsException(String input) throws Exception {
        //Given

        //When & Then

        assertThrows(InvalidEmailException.class, () -> EmailUtils.assertIsValidEmailOrThrowException(input));
    }

    @Test
    void ValidEmail() {
        assertTrue(EmailUtils.isValidEmail("test1._%+-@test123.-.test"));
    }
    @Test
    void ValidEmailInAllUppercase() {
        assertTrue(EmailUtils.isValidEmail("TEST@TEST.TEST"));
    }
    @Test
    void EmailWithNothingBeforeTheAt() {
        assertFalse(EmailUtils.isValidEmail("@test.test"));
    }
    @Test
    void EmailWithNothingAfterTheDot() {
        assertFalse(EmailUtils.isValidEmail("test@test."));
    }
    @Test
    void EmailWithNothingBetweenAtAndDot() {
        assertFalse(EmailUtils.isValidEmail("test@.test"));
    }
    @Test
    void EmailWithAToLongValueAfterTheDot() {
        assertFalse(EmailUtils.isValidEmail("test@test.testtest"));
    }
    @Test
    void EmailWithAToShortValueAfterTheDot() {
        assertFalse(EmailUtils.isValidEmail("test@test.t"));
    }
    @Test
    void EmailWithNumbersAfterTheDot() {
        assertFalse(EmailUtils.isValidEmail("test@test.123"));
    }
    @Test
    void EmailWithNoAtSign() {
        assertFalse(EmailUtils.isValidEmail("testtest.test"));
    }
    @Test
    void EmailWithNoDotAfterTheAtSign() {
        assertFalse(EmailUtils.isValidEmail("test@testtest"));
    }

}
