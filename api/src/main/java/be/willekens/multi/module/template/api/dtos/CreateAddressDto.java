package be.willekens.multi.module.template.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateAddressDto {

    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;
}
