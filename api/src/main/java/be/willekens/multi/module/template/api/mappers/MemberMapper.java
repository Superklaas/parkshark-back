package be.willekens.multi.module.template.api.mappers;

import be.willekens.multi.module.template.api.dtos.CreateMemberDto;
import be.willekens.multi.module.template.api.dtos.ReceiveMemberDto;
import be.willekens.multi.module.template.domain.models.LicencePlate;
import be.willekens.multi.module.template.domain.models.users.Account;
import be.willekens.multi.module.template.domain.models.users.Member;
import be.willekens.multi.module.template.domain.models.users.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MemberMapper {
    private AddressMapper addressMapper;

    @Autowired
    public MemberMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Member createMemberDto_to_Member(CreateMemberDto createMemberDto) {
        return new Member()
                .setFirstName(createMemberDto.getFirstName())
                .setLastName(createMemberDto.getLastName())
                .setAddress(addressMapper.createAddressDto_to_address(createMemberDto.getAddress()))
                .setPhoneNumber(createMemberDto.getPhoneNumber())
                .setRegistrationDate(LocalDate.now())
                .setLicencePlate(new LicencePlate(createMemberDto.getLicencePlateNumber(), createMemberDto.getLicencePlateCountry()))
                .setAccount(new Account(createMemberDto.getEmail(), createMemberDto.getPassword(), Role.MEMBER));
    }

    public ReceiveMemberDto member_to_ReceiveMemberDto(Member member) {
        return new ReceiveMemberDto()
                .setId(member.getId())
                .setFirstName(member.getFirstName())
                .setLastName(member.getLastName())
                .setAddress(addressMapper.address_to_receiveAddress(member.getAddress()))
                .setPhoneNumber(member.getPhoneNumber())
                .setEmail(member.getAccount().getEmail())
                .setLicencePlateNumber(member.getLicencePlate().getPlateNumber())
                .setLicencePlateCountry(member.getLicencePlate().getIssuingCountry())
                .setRegistrationDate(member.getRegistrationDate());
    }





}
