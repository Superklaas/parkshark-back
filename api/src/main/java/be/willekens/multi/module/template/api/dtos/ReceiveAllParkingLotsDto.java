package be.willekens.multi.module.template.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReceiveAllParkingLotsDto {

    private int parkingLotId;
    private String name;
    private int maxCapacity;
    private String telephoneNumberContactPerson;
    private String emailContactPerson;

    public ReceiveAllParkingLotsDto setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
        return this;
    }

    public ReceiveAllParkingLotsDto setName(String name) {
        this.name = name;
        return this;
    }

    public ReceiveAllParkingLotsDto setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public ReceiveAllParkingLotsDto setTelephoneNumberContactPerson(String telephoneNumberContactPerson) {
        this.telephoneNumberContactPerson = telephoneNumberContactPerson;
        return this;
    }

    public ReceiveAllParkingLotsDto setEmailContactPerson(String emailContactPerson) {
        this.emailContactPerson = emailContactPerson;
        return this;
    }
}
