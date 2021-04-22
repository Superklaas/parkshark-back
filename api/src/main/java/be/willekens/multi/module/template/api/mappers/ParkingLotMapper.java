package be.willekens.multi.module.template.api.mappers;

import be.willekens.multi.module.template.api.dtos.CreateParkingLotDto;
import be.willekens.multi.module.template.api.dtos.ReceiveContactPersonDto;
import be.willekens.multi.module.template.api.dtos.ReceiveParkingLotDto;
import be.willekens.multi.module.template.domain.models.parking_lot.Category;
import be.willekens.multi.module.template.domain.models.parking_lot.ParkingLot;
import be.willekens.multi.module.template.domain.models.parking_lot.Price;
import be.willekens.multi.module.template.infrastructure.exceptions.InvalidCategoryException;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {

    private ContactPersonMapper contactPersonMapper;
    private AddressMapper addressMapper;

    public ParkingLotMapper(ContactPersonMapper contactPersonMapper, AddressMapper addressMapper) {
        this.contactPersonMapper = contactPersonMapper;
        this.addressMapper = addressMapper;
    }

    public ParkingLot createParkingLotDto_to_parkingLot(CreateParkingLotDto createParkingLotDto) {
        return new ParkingLot()
                .setName(createParkingLotDto.getName())
                .setCategory(getValidCategory(createParkingLotDto.getCategory()))
                .setMaxCapacity(createParkingLotDto.getMaxCapacity())
                .setContactPerson(contactPersonMapper.createContactPersonDto_to_contactPerson(createParkingLotDto.getContactPerson()))
                .setAddress(addressMapper.createAddressDto_to_address(createParkingLotDto.getParkingAddress()))
                .setPricePerHour(Price.createPriceInEuros(createParkingLotDto.getPricePerHour()));
    }

    public ReceiveParkingLotDto parkingLot_to_receiveParkingLotDto(ParkingLot parkingLot) {
        return new ReceiveParkingLotDto()
                .setParkingLotId(parkingLot.getId())
                .setName(parkingLot.getName())
                .setCategory(parkingLot.getCategory().name())
                .setMaxCapacity(parkingLot.getMaxCapacity())
                .setContactPerson(contactPersonMapper.contactPerson_to_receiveContactPerson(parkingLot.getContactPerson()))
                .setParkingAddress(addressMapper.address_to_receiveAddress(parkingLot.getAddress()))
                .setPricePerHour(parkingLot.getPricePerHour().getValue());
    }

    private Category getValidCategory(String category) {
        try {
            return Enum.valueOf(Category.class, category.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new InvalidCategoryException("The category " + category + " does not exist");
        }
    }

}
