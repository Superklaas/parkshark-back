package be.willekens.multi.module.template.api.dtos;

import be.willekens.multi.module.template.domain.models.parking_lot.Address;
import be.willekens.multi.module.template.domain.models.parking_lot.Category;
import be.willekens.multi.module.template.domain.models.parking_lot.ContactPerson;
import be.willekens.multi.module.template.domain.models.parking_lot.Price;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
public class CreateParkingLotDto {
    private String name;
    private Category category;
    private int maxCapacity;
    private CreateContactPersonDto contactPerson;
    private CreateAddressDto parkingAddress;
    private double pricePerHour;




}
