package com.superklaas.api.mappers;

import com.superklaas.api.dtos.ReceiveMemberDto;
import com.superklaas.domain.models.account.Account;
import com.superklaas.domain.models.account.Role;
import com.superklaas.domain.models.address.Address;
import com.superklaas.domain.models.address.PostalCode;
import com.superklaas.domain.models.member.LicencePlate;
import com.superklaas.domain.models.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class MemberMapperTest {

    @Mock
    private AddressMapper addressMapper;
    @InjectMocks
    private MemberMapper memberMapper;

    @Test
    void name() {
        Member member = createMemberFactory();

        ReceiveMemberDto receiveMemberDto = memberMapper.member_to_receiveMemberDto(member);

        Assertions.assertThat(receiveMemberDto.getFirstName()).isEqualTo(member.getFirstName());
    }

    private Member createMemberFactory() {
        Member member = new Member();
        member.setFirstName("Dumb");
        member.setLastName("Dummy");
        member.setPhoneNumber("0002");
        member.setAddress(createAddressFactory());
        member.setLicencePlate(createLicencePlate());
        member.setRegistrationDate(LocalDate.now());
        member.setAccount(new Account("test@test.be","", Role.MEMBER));
        return member;
    }

    private LicencePlate createLicencePlate() {
         return new LicencePlate("1-GHK-800","BE");
    }

    private Address createAddressFactory(){
        Address address = new Address();
        address.setStreetName("Baker Street");
        address.setStreetNumber("221B");
        address.setPostalCode(new PostalCode("1000","London"));
        return address;
    }
}
