package be.willekens.multi.module.template.api.dtos;

import be.willekens.multi.module.template.domain.models.LicencePlate;
import be.willekens.multi.module.template.domain.models.parking_lot.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToOne;

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
