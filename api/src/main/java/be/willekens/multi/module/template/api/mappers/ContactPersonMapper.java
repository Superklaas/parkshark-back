package be.willekens.multi.module.template.api.mappers;

import be.willekens.multi.module.template.api.dtos.CreateContactPersonDto;
import be.willekens.multi.module.template.api.dtos.ReceiveContactPersonDto;
import be.willekens.multi.module.template.domain.models.parking_lot.ContactPerson;
import org.springframework.stereotype.Component;

@Component
public class ContactPersonMapper {

    private AddressMapper addressMapper;

    public ContactPersonMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public ContactPerson createContactPersonDto_to_contactPerson(CreateContactPersonDto createContactPersonDto) {
        return new ContactPerson()
                .setFullname(createContactPersonDto.getFullname())
                .setMobilePhoneNumber(createContactPersonDto.getMobilePhoneNumber())
                .setTelephoneNumber(createContactPersonDto.getTelephoneNumber())
                .setEmail(createContactPersonDto.getEmail())
                .setAddress(addressMapper.createAddressDto_to_address(createContactPersonDto.getContactPersonsAddress()));
    }

    public ReceiveContactPersonDto contactPerson_to_receiveContactPerson (ContactPerson contactPerson){
        return new ReceiveContactPersonDto()
                .setContactPersonId(contactPerson.getId())
                .setFullname(contactPerson.getFullname())
                .setMobilePhoneNumber(contactPerson.getMobilePhoneNumber())
                .setTelephoneNumber(contactPerson.getTelephoneNumber())
                .setEmail(contactPerson.getEmail())
                .setContactPersonsAddress(addressMapper.address_to_receiveAddress(contactPerson.getAddress()));
    }
}
