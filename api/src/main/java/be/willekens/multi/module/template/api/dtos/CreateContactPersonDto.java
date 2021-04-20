package be.willekens.multi.module.template.api.dtos;

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
}
