package be.willekens.multi.module.template.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReceiveContactPersonDto {

    private int contactPersonId;
    private String fullname;
    private String mobilePhoneNumber;
    private String telephoneNumber;
    private String email;
    private ReceiveAddressDto contactPersonsAddress;

    public ReceiveContactPersonDto setContactPersonId(int contactPersonId) {
        this.contactPersonId = contactPersonId;
        return this;
    }

    public ReceiveContactPersonDto setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public ReceiveContactPersonDto setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
        return this;
    }

    public ReceiveContactPersonDto setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public ReceiveContactPersonDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public ReceiveContactPersonDto setContactPersonsAddress(ReceiveAddressDto contactPersonsAddress) {
        this.contactPersonsAddress = contactPersonsAddress;
        return this;
    }
}
