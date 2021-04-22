package be.willekens.multi.module.template.api.mappers;

import be.willekens.multi.module.template.api.dtos.CreateAddressDto;
import be.willekens.multi.module.template.api.dtos.ReceiveAddressDto;
import be.willekens.multi.module.template.domain.models.address.Address;
import be.willekens.multi.module.template.domain.models.address.PostalCode;
import be.willekens.multi.module.template.service.PostalCodeService;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    private final PostalCodeService postalCodeService;

    public AddressMapper(PostalCodeService postalCodeService) {
        this.postalCodeService = postalCodeService;
    }

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
