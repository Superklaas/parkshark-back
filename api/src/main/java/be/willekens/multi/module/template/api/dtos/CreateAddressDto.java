package be.willekens.multi.module.template.api.dtos;

import be.willekens.multi.module.template.domain.models.parking_lot.PostalCode;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
public class CreateAddressDto {
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;




}
