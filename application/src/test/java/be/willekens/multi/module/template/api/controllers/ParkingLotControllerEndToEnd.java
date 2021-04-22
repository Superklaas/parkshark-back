package be.willekens.multi.module.template.api.controllers;

import be.willekens.multi.module.template.api.dtos.CreateAddressDto;
import be.willekens.multi.module.template.api.dtos.CreateContactPersonDto;
import be.willekens.multi.module.template.api.dtos.CreateParkingLotDto;
import be.willekens.multi.module.template.api.dtos.ReceiveParkingLotDto;
import be.willekens.multi.module.template.api.mappers.ParkingLotMapper;
import be.willekens.multi.module.template.domain.models.address.Address;
import be.willekens.multi.module.template.domain.models.address.PostalCode;
import be.willekens.multi.module.template.domain.models.parking_lot.*;
import be.willekens.multi.module.template.domain.models.price.Price;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ParkingLotControllerEndToEnd {

    @LocalServerPort
    private int port;

    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @Test
    void testingParkingLotControllerCreateParkingLot_restAssured() {
        Address address = new Address("Sussame Street", "32", new PostalCode("3300", "Tienen"));
        Address address2 = new Address("Baker Street","39", new PostalCode("3800","Sint-Truiden"));
        ContactPerson contactPerson = new ContactPerson("Ihsan", "04555555", "", "rafael@excalibur.com", address);
        ParkingLot parkingLot = new ParkingLot("Andre", Category.ABOVE_GROUND_BUILDING, 10, contactPerson, address2, Price.createPriceInEuros(3));

        CreateAddressDto createAddressDto = new CreateAddressDto("Sussame Street","32","3300","Tienen");
        CreateAddressDto createAddressDto2 = new CreateAddressDto("Baker Street","39","3800","Sint-Truiden");
        CreateContactPersonDto createContactPersonDto = new CreateContactPersonDto("Ihsan","04555555","","rafael@excalibur",createAddressDto);
        CreateParkingLotDto createParkingLotDto = new CreateParkingLotDto("Andre","ABOVE_GROUND_BUILDING",10,createContactPersonDto,createAddressDto2,3);

        var token = given()
                .baseUri("http://localhost")
                .port(port)
                .when().post("/authenticate?username=rafael@parkshark.be&password=admin")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .response().headers().get("Authorization");

        ReceiveParkingLotDto receivedParkingLot = given()
                .baseUri("http://localhost")
                .port(port)
                .header("Authorization", token.getValue())
                .contentType(ContentType.JSON)
                .body(createParkingLotDto)
                .when().post("/parking-lots")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(ReceiveParkingLotDto.class);

        assertThat(receivedParkingLot).isNotNull();
//        assertThat(receivedParkingLot).isEqualTo(parkingLotMapper.parkingLot_to_receiveParkingLotDto(parkingLot));
    }
}
