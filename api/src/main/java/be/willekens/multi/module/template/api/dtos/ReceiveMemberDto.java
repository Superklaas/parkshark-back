package be.willekens.multi.module.template.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class ReceiveMemberDto {
    private int id;
    private String firstName;
    private String lastName;
    private ReceiveAddressDto address;
    private String phoneNumber;
    private String email;
    private LocalDate registrationDate;
    private String licencePlateNumber;
    private String licencePlateCountry;


    public ReceiveMemberDto setId(int id) {
        this.id = id;
        return this;
    }

    public ReceiveMemberDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ReceiveMemberDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ReceiveMemberDto setAddress(ReceiveAddressDto address) {
        this.address = address;
        return this;
    }

    public ReceiveMemberDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ReceiveMemberDto setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public ReceiveMemberDto setLicencePlateNumber(String licencePlateNumber) {
        this.licencePlateNumber = licencePlateNumber;
        return this;
    }

    public ReceiveMemberDto setLicencePlateCountry(String licencePlateCountry) {
        this.licencePlateCountry = licencePlateCountry;
        return this;
    }

    public ReceiveMemberDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
