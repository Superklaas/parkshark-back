package be.willekens.multi.module.template.service;

import be.willekens.multi.module.template.domain.models.parking_lot.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParkingLotServiceSpringTest {

    @Autowired
    private ParkingLotService parkingLotService;

    @Test
    void createParkingLot_whenOnePostalCodeAlreadyExists() {
        ParkingLot parkingLot = new ParkingLot()
                .setName("test")
                .setCategory(Category.UNDERGROUND_BUILDING)
                .setMaxCapacaity(100)
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