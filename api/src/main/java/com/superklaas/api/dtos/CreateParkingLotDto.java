package com.superklaas.api.dtos;

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

    public CreateParkingLotDto(String name, String category, int maxCapacity, CreateContactPersonDto contactPerson, CreateAddressDto parkingAddress, double pricePerHour) {
        this.name = name;
        this.category = category;
        this.maxCapacity = maxCapacity;
        this.contactPerson = contactPerson;
        this.parkingAddress = parkingAddress;
        this.pricePerHour = pricePerHour;
    }
}
