package be.willekens.multi.module.template.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReceiveParkingLotDto {

    private int parkingLotId;
    private String name;
    private String category;
    private int maxCapacity;
    private ReceiveContactPersonDto contactPerson;
    private ReceiveAddressDto parkingAddress;
    private double pricePerHour;

    public ReceiveParkingLotDto setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
        return this;
    }

    public ReceiveParkingLotDto setName(String name) {
        this.name = name;
        return this;
    }

    public ReceiveParkingLotDto setCategory(String category) {
        this.category = category;
        return this;
    }

    public ReceiveParkingLotDto setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public ReceiveParkingLotDto setContactPerson(ReceiveContactPersonDto contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public ReceiveParkingLotDto setParkingAddress(ReceiveAddressDto parkingAddress) {
        this.parkingAddress = parkingAddress;
        return this;
    }

    public ReceiveParkingLotDto setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
        return this;
    }
}
