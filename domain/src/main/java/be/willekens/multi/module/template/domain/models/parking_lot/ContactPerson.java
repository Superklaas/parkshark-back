package be.willekens.multi.module.template.domain.models.parking_lot;

import be.willekens.multi.module.template.infrastructure.utils.EmailUtils;

import static be.willekens.multi.module.template.infrastructure.utils.EmailUtils.*;

public class ContactPerson {

    private int id;
    private String fullname;
    private String mobilePhoneNumber;
    private String telephoneNumber;
    private String email;
    private Address address;

    public ContactPerson(String fullname, String mobilePhoneNumber, String telephoneNumber, String email, Address address) {
        assertIsValidEmailOrThrowException(email);
        this.fullname = fullname;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.address = address;
    }

    public ContactPerson() {
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
