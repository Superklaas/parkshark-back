package be.willekens.multi.module.template.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReceiveAddressDto {

    private int addressId;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;

    public ReceiveAddressDto setAddressId(int addressId) {
        this.addressId = addressId;
        return this;
    }

    public ReceiveAddressDto setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public ReceiveAddressDto setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public ReceiveAddressDto setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public ReceiveAddressDto setCity(String city) {
        this.city = city;
        return this;
    }
}