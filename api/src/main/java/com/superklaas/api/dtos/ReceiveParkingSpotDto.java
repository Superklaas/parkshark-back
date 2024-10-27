package com.superklaas.api.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReceiveParkingSpotDto {
    private int id;
    private int memberId;
    private int parkingLotId;
    private String licencePlateNumber;
    private String licencePlateCountry;

    public ReceiveParkingSpotDto(int id, int memberId, int parkingLotId, String licencePlateNumber, String licencePlateCountry) {
        this.id = id;
        this.memberId = memberId;
        this.parkingLotId = parkingLotId;
        this.licencePlateNumber = licencePlateNumber;
        this.licencePlateCountry = licencePlateCountry;
    }

    public ReceiveParkingSpotDto setId(int id) {
        this.id = id;
        return this;
    }

    public ReceiveParkingSpotDto setMemberId(int memberId) {
        this.memberId = memberId;
        return this;
    }

    public ReceiveParkingSpotDto setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
        return this;
    }

    public ReceiveParkingSpotDto setLicencePlateNumber(String licencePlateNumber) {
        this.licencePlateNumber = licencePlateNumber;
        return this;
    }

    public ReceiveParkingSpotDto setLicencePlateCountry(String licencePlateCountry) {
        this.licencePlateCountry = licencePlateCountry;
        return this;
    }
}
