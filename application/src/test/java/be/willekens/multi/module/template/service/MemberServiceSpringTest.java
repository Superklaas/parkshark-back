package be.willekens.multi.module.template.service;

import be.willekens.multi.module.template.domain.models.member.LicencePlate;
import be.willekens.multi.module.template.domain.models.address.Address;
import be.willekens.multi.module.template.domain.models.address.PostalCode;
import be.willekens.multi.module.template.domain.models.account.Account;
import be.willekens.multi.module.template.domain.models.member.Member;
import be.willekens.multi.module.template.domain.models.account.Role;
import be.willekens.multi.module.template.infrastructure.exceptions.InvalidEmailException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MemberServiceSpringTest {

    @Autowired
    private MemberService memberService;


    @Test
    void createMember_whenPostalCodeAlreadyExists() {
        Member member = memberFactory();
        member.getAddress().setPostalCode(new PostalCode("1234", "Buenos Aires"));
        Member dbMember = memberService.createMember(member);

        assertThat(dbMember.getAddress().getPostalCode()).isEqualTo(member.getAddress().getPostalCode());
    }

    @Test
    void createMember_whenPostalCodeDoesNotAlreadyExistInDB() {
        Member member = memberFactory();
        member.getAddress().setPostalCode(new PostalCode("xxxx", "Test town"));
        Member dbMember = memberService.createMember(member);

        assertThat(dbMember.getAddress().getPostalCode()).isEqualTo(member.getAddress().getPostalCode());
    }

    @Test
    void createMember_whenPostalCodeAlreadyExistsInDBButCityNameIsDifferent_thenUsesCityInDatabase() {
        Member member = memberFactory();
        member.getAddress().setPostalCode(new PostalCode("1234", "Test town"));
        Member dbMember = memberService.createMember(member);

        assertThat(dbMember.getAddress().getPostalCode().getPostalCode()).isEqualTo(member.getAddress().getPostalCode().getPostalCode());
        assertThat(dbMember.getAddress().getPostalCode().getLabel()).isEqualTo("Buenos Aires");
    }

    @Test
    void createMember_whenEmailAlreadyExists() {
        Member member = memberFactory();
        member.getAddress().setPostalCode(new PostalCode("1234", "Test town"));
        member.setAccount(new Account("ihsan@parkshark.be", "password", Role.MEMBER));
        assertThatThrownBy(() -> memberService.createMember(member))
                .isInstanceOf(InvalidEmailException.class)
                .hasMessage("this email address already exists");
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
                );
    }

}


