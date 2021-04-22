package be.willekens.multi.module.template.domain.models.parking_lot;

import be.willekens.multi.module.template.infrastructure.exceptions.InvalidPhoneNumberException;
import be.willekens.multi.module.template.infrastructure.utils.EmailUtils;

import javax.persistence.*;

import static be.willekens.multi.module.template.infrastructure.utils.EmailUtils.*;

@Entity
@Table(name = "contact_persons")
public class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_person_id")
    private int id;
    @Column(name = "full_name")
    private String fullname;
    @Column(name = "mobile_phone_number")
    private String mobilePhoneNumber;
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "address_id")
    private Address address;

    public ContactPerson(String fullname, String mobilePhoneNumber, String telephoneNumber, String email,
                         Address address) {
        assertIsValidEmailOrThrowException(email);
        assertPhoneNumbersAreValid(mobilePhoneNumber, telephoneNumber);
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

    public ContactPerson setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public ContactPerson setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
        return this;
    }

    public ContactPerson setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public ContactPerson setEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactPerson setAddress(Address address) {
        this.address = address;
        return this;
    }

    private void assertPhoneNumbersAreValid(String mobilePhoneNumber, String telephoneNumber) {
        if ((mobilePhoneNumber == null || mobilePhoneNumber.isBlank()) && (telephoneNumber == null || telephoneNumber.isBlank())) {
            throw new InvalidPhoneNumberException("You must have at least one phone number");
        }
    }

}
