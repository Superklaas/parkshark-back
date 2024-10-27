package com.superklaas.service;

import com.superklaas.domain.models.address.Address;
import com.superklaas.domain.models.address.PostalCode;
import com.superklaas.domain.models.parking_lot.*;
import com.superklaas.domain.models.price.Price;
import com.superklaas.domain.models.parking_lot.Category;
import com.superklaas.domain.models.parking_lot.ContactPerson;
import com.superklaas.domain.models.parking_lot.ParkingLot;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled
@SpringBootTest
class ParkingLotServiceSpringTest {

    @Autowired
    private ParkingLotService parkingLotService;

    @Test
    void createParkingLot_whenOnePostalCodeAlreadyExists() {
        ParkingLot parkingLot = new ParkingLot()
                .setName("test")
                .setCategory(Category.UNDERGROUND_BUILDING)
                .setMaxCapacity(100)
                .setPricePerHour(Price.createPriceInEuros(3))
                .setAddress(new Address()
                        .setStreetName("Test street")
                        .setStreetNumber("221B")
                        .setPostalCode(new PostalCode("1234", "Buenos Aires")))
                .setContactPerson(new ContactPerson()
                        .setFullname("Testy McTestFace")
                        .setEmail("test@test.test")
                        .setMobilePhoneNumber("111111111")
                        .setTelephoneNumber("222222222")
                        .setAddress(new Address()
                                .setStreetName("TestingStreet")
                                .setStreetNumber("test")
                                .setPostalCode(new PostalCode("test", "testville"))));

       ParkingLot dbParkingLot = parkingLotService.createParkingLot(parkingLot);
        Assertions.assertThat(dbParkingLot.getAddress().getPostalCode()).isEqualTo(parkingLot.getAddress().getPostalCode());
        Assertions.assertThat(dbParkingLot.getContactPerson().getAddress().getPostalCode()).isEqualTo(parkingLot.getContactPerson().getAddress().getPostalCode());

    }
}
