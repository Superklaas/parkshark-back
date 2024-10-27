package com.superklaas.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateMemberDto {
    private String firstName;
    private String lastName;
    private CreateAddressDto address;
    private String phoneNumber;
    private String email;
    private String licencePlateNumber;
    private String licencePlateCountry;
    private String password;








}
