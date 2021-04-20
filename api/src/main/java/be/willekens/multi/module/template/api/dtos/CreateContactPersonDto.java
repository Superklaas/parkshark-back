package be.willekens.multi.module.template.api.dtos;

import be.willekens.multi.module.template.domain.models.parking_lot.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;

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
