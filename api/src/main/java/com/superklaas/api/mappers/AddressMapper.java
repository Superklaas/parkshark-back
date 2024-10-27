package com.superklaas.api.mappers;

import com.superklaas.api.dtos.CreateAddressDto;
import com.superklaas.api.dtos.ReceiveAddressDto;
import com.superklaas.domain.models.address.Address;
import com.superklaas.domain.models.address.PostalCode;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address createAddressDto_to_address(CreateAddressDto createAddressDto) {
        return new Address()
                .setStreetName(createAddressDto.getStreetName())
                .setStreetNumber(createAddressDto.getStreetNumber())
                .setPostalCode(new PostalCode(createAddressDto.getPostalCode(),
                        createAddressDto.getCity()));
    }

    public ReceiveAddressDto address_to_receiveAddress(Address address) {
        return new ReceiveAddressDto()
                .setAddressId(address.getId())
                .setStreetName(address.getStreetName())
                .setStreetNumber(address.getStreetNumber())
                .setPostalCode(address.getPostalCode().getPostalCode())
                .setCity(address.getPostalCode().getLabel());
    }

}
