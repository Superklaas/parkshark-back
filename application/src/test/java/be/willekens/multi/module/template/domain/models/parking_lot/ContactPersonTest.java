package be.willekens.multi.module.template.domain.models.parking_lot;

import be.willekens.multi.module.template.domain.models.address.Address;
import be.willekens.multi.module.template.infrastructure.exceptions.InvalidPhoneNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactPersonTest {

    private final static String NAME = "Test";
    private final static String VALID_PHONE_NUMBER = "011223344";
    private final static String VALID_EMAIL = "test@test.be";
    private final static Address ADDRESS = new Address();


    @Test
    void ifBothPhoneNumbersAreNull_thenThrowInvalidPhoneException() {
        assertThrows(InvalidPhoneNumberException.class,
                ()-> new ContactPerson(NAME, null,null, VALID_EMAIL, ADDRESS)) ;
    }

    @Test
    void ifOnePhoneNumberIsNullAndOneIsEmpty_thenThrowInvalidPhoneException() {
        assertThrows(InvalidPhoneNumberException.class,
                ()-> new ContactPerson(NAME, null,"", VALID_EMAIL, ADDRESS)) ;
    }

    @Test
    void ifOnePhoneNumberisNullAndOneIsBlank_thenThrowInvalidPhoneException() {
        assertThrows(InvalidPhoneNumberException.class,
                ()-> new ContactPerson(NAME, null," ", VALID_EMAIL, ADDRESS)) ;
    }

    @Test
    void ifOnePhoneNumberIsEmptyAndOneIsBlank_thenThrowInvalidPhoneException() {
        assertThrows(InvalidPhoneNumberException.class,
                ()-> new ContactPerson(NAME, " ","", VALID_EMAIL, ADDRESS)) ;
    }

    @Test
    void ifBothPhoneNumbersAreBlank_thenThrowInvalidPhoneException() {
        assertThrows(InvalidPhoneNumberException.class,
                ()-> new ContactPerson(NAME, " "," ", VALID_EMAIL, ADDRESS)) ;
    }

    @Test
    void ifBothPhoneNumbersAreEmpty_thenThrowInvalidPhoneException() {
        assertThrows(InvalidPhoneNumberException.class,
                ()-> new ContactPerson(NAME, "","", VALID_EMAIL, ADDRESS)) ;
    }

    @Test
    void ifOnePhoneNumberIsValidAndOneIsNull_thenCreatesContactPerson() {
        new ContactPerson(NAME, null,VALID_PHONE_NUMBER, VALID_EMAIL, ADDRESS) ;
    }

    @Test
    void ifOnePhoneNumberIsValidAndOneIsEmpty_thenCreatesContactPerson() {
        new ContactPerson(NAME, "",VALID_PHONE_NUMBER, VALID_EMAIL, ADDRESS) ;
    }

    @Test
    void ifOnePhoneNumberIsValidAndOneIsBlank_thenCreatesContactPerson() {
        new ContactPerson(NAME, " ",VALID_PHONE_NUMBER, VALID_EMAIL, ADDRESS) ;
    }

    @Test
    void ifBothPhoneNumbersAreValid_thenCreatesContactPerson() {
        new ContactPerson(NAME, VALID_PHONE_NUMBER,VALID_PHONE_NUMBER, VALID_EMAIL, ADDRESS) ;
    }
}
