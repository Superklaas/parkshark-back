package be.willekens.multi.module.template.api.controllers;

import be.willekens.multi.module.template.api.dtos.CreateAddressDto;
import be.willekens.multi.module.template.api.dtos.CreateContactPersonDto;
import be.willekens.multi.module.template.api.dtos.CreateParkingLotDto;
import be.willekens.multi.module.template.api.dtos.ReceiveParkingLotDto;
import be.willekens.multi.module.template.domain.models.account.Account;
import be.willekens.multi.module.template.domain.models.account.Role;
import be.willekens.multi.module.template.domain.repository.AccountRepository;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("EtoE")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@EnableAutoConfiguration
public class ParkingLotControllerEndToEnd {

    @LocalServerPort
    private int port;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void testingParkingLotControllerCreateParkingLot_restAssured() {
        accountRepository.save(new Account("rafael@parkshark.be","admin", Role.MANAGER));

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

        assertThat(receivedParkingLot.getName()).isEqualTo(createParkingLotDto.getName());
    }

    @Test
    void testingParkingLotControllerGetAllParkingLots_restAssured() {
        accountRepository.save(new Account("rafael@parkshark.be","admin", Role.MANAGER));

        var token = given()
                .baseUri("http://localhost")
                .port(port)
                .when().post("/authenticate?username=rafael@parkshark.be&password=admin")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .response().headers().get("Authorization");

        ReceiveParkingLotDto[] receivedParkingLot = given()
                .baseUri("http://localhost")
                .port(port)
                .header("Authorization", token.getValue())
                .when().get("/parking-lots")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(ReceiveParkingLotDto[].class);
    }
}
