package be.willekens.multi.module.template.api.controllers;

import be.willekens.multi.module.template.api.dtos.*;
import be.willekens.multi.module.template.domain.models.account.Account;
import be.willekens.multi.module.template.domain.models.account.Role;
import be.willekens.multi.module.template.domain.models.address.Address;
import be.willekens.multi.module.template.domain.models.address.PostalCode;
import be.willekens.multi.module.template.domain.models.member.LicencePlate;
import be.willekens.multi.module.template.domain.models.member.Member;
import be.willekens.multi.module.template.domain.models.parking_lot.Category;
import be.willekens.multi.module.template.domain.models.parking_lot.ContactPerson;
import be.willekens.multi.module.template.domain.models.parking_lot.ParkingLot;
import be.willekens.multi.module.template.domain.models.price.Price;
import be.willekens.multi.module.template.service.AccountService;
import be.willekens.multi.module.template.service.MemberService;
import be.willekens.multi.module.template.service.ParkingLotService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("EtoE")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@EnableAutoConfiguration
public class ParkingSpotControllerEndToEnd {

    @LocalServerPort
    private int port;

    @Autowired
    private AccountService accountService;
    @Autowired
    private ParkingLotService parkingLotService;
    @Autowired
    private MemberService memberService;

    @Test
    void testingParkingSpotControllerAllocateParkingSpot_restAssured() {
        Member member =  memberFactory();
        memberService.createMember(member);

        Account accountToAdd = member.getAccount();
        accountService.createAccount(accountToAdd);

        ParkingLot parkingLot = parkingLotFactory();
        parkingLotService.createParkingLot(parkingLot);

        CreateParkingSpotDto createParkingSpotDto = new CreateParkingSpotDto();
             createParkingSpotDto.setMemberId(member.getId());
             createParkingSpotDto.setLicencePlateCountry(member.getLicencePlate().getIssuingCountry());
             createParkingSpotDto.setLicencePlateNumber(member.getLicencePlate().getPlateNumber());
             createParkingSpotDto.setParkingLotId(parkingLot.getId());

        var token = given()
                .baseUri("http://localhost")
                .port(port)
                .when().post("/authenticate?username=test@test.test&password=testtest")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .response().headers().get("Authorization");

        ReceiveParkingSpotDto receivedParkingSpot = given()
                .baseUri("http://localhost")
                .port(port)
                .header("Authorization", token.getValue())
                .contentType(ContentType.JSON)
                .body(createParkingSpotDto)
                .when().post("/parking-spots")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(ReceiveParkingSpotDto.class);

        assertThat(receivedParkingSpot.getMemberId()).isEqualTo(createParkingSpotDto.getMemberId());
    }

    private Member memberFactory() {
        return new Member()
                .setAccount(new Account("test@test.test", "testtest", Role.MEMBER))
                .setFirstName("John")
                .setLastName("Doe")
                .setLicencePlate(new LicencePlate("xxx555", "BE"))
                .setPhoneNumber("011223344")
                .setRegistrationDate(LocalDate.now())
                .setAddress(new Address()
                        .setStreetName("testystreet")
                        .setStreetNumber("test")
                        .setPostalCode(new PostalCode().setLabel("a").setPostalCode("1000")));
    }

    private ParkingLot parkingLotFactory() {
        return new ParkingLot()
                .setName("Andre")
                .setCategory(Category.ABOVE_GROUND_BUILDING)
                .setMaxCapacity(10)
                .setAvailableSpotsLeft(10)
                .setAddress(new Address("Sussame Street", "32", new PostalCode("3300", "Tienen")))
                .setContactPerson(new ContactPerson("Ihsan", "04555555", "", "rafael@excalibur.com",
                        new Address("Baker Street","19",new PostalCode("3000","Aarschot"))))
                .setPricePerHour(Price.createPriceInEuros(3));
    }

}
