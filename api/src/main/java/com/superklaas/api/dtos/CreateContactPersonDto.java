package com.superklaas.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateContactPersonDto {

    private String fullname;
    private String mobilePhoneNumber;
    private String telephoneNumber;
    private String email;
    private CreateAddressDto contactPersonsAddress;

    public CreateContactPersonDto(String fullname, String mobilePhoneNumber, String telephoneNumber, String email, CreateAddressDto contactPersonsAddress) {
        this.fullname = fullname;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.contactPersonsAddress = contactPersonsAddress;
    }
}
