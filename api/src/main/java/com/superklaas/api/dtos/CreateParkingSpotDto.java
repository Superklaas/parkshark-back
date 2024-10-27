package com.superklaas.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateParkingSpotDto {

    private int memberId;
    private int parkingLotId;
    private String licencePlateNumber;
    private String licencePlateCountry;

    public CreateParkingSpotDto(int memberId, int parkingLotId, String licencePlateNumber, String licencePlateCountry) {
        this.memberId = memberId;
        this.parkingLotId = parkingLotId;
        this.licencePlateNumber = licencePlateNumber;
        this.licencePlateCountry = licencePlateCountry;
    }
}
