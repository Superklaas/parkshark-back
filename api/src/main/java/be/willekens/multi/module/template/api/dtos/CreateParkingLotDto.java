package be.willekens.multi.module.template.api.dtos;

import be.willekens.multi.module.template.domain.models.parking_lot.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateParkingLotDto {

    private String name;
    private String category;
    private int maxCapacity;
    private CreateContactPersonDto contactPerson;
    private CreateAddressDto parkingAddress;
    private double pricePerHour;

}
