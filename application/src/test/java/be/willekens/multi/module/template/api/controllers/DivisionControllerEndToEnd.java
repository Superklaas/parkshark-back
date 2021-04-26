package be.willekens.multi.module.template.api.controllers;

import be.willekens.multi.module.template.api.dtos.CreateDivisionDto;
import be.willekens.multi.module.template.api.dtos.ReceiveDivisionDto;
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

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("EtoE")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@EnableAutoConfiguration
public class DivisionControllerEndToEnd {

    @LocalServerPort
    private int port;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void testingParkingLotControllerCreateDivision_restAssured(){
        accountRepository.save(new Account("rafael@parkshark.be","admin", Role.MANAGER));
        CreateDivisionDto createDivisionDto = new CreateDivisionDto("Qpark", "Q-park inc", "Director John",
                null);
        var token = given()
                .baseUri("http://localhost")
                .port(port)
                .when().post("/authenticate?username=rafael@parkshark.be&password=admin")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .response().headers().get("Authorization");

        ReceiveDivisionDto receivedDivisionDto = given()
                .baseUri("http://localhost")
                .port(port)
                .header("Authorization", token.getValue())
                .contentType(ContentType.JSON)
                .body(createDivisionDto)
                .when().post("/divisions")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(ReceiveDivisionDto.class);

        assertThat(receivedDivisionDto.getName()).isEqualTo(createDivisionDto.getName());
    }

    @Test
    void testingDivisionControllerGetAllDivisions_restAssured(){
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

        ReceiveDivisionDto[] receivedParkingLot = given()
                .baseUri("http://localhost")
                .port(port)
                .header("Authorization", token.getValue())
                .contentType(ContentType.JSON)
                .body(ReceiveDivisionDto[].class)
                .when().get("/divisions")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(ReceiveDivisionDto[].class);
    }



}
