package be.willekens.multi.module.template.service;

import be.willekens.multi.module.template.domain.models.parking_lot.Address;
import be.willekens.multi.module.template.domain.models.parking_lot.PostalCode;
import be.willekens.multi.module.template.domain.models.users.Member;
import be.willekens.multi.module.template.domain.repository.MemberRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@NoArgsConstructor
public class MemberService {
    @Autowired
   private MemberRepository memberRepository;
    @Autowired
    private PostalCodeService postalCodeService;

    public Member createMember(Member member) {
        Address address = member.getAddress();
        address.setPostalCode(getPostalCodeByPostalCodeOrCreateNewOne(address.getPostalCode()));
       return memberRepository.save(member);
    }

    public PostalCode getPostalCodeByPostalCodeOrCreateNewOne(PostalCode postalCode) {
        PostalCode resultPostalCode = postalCodeService.getByPostalCode(postalCode.getPostalCode());
        if (resultPostalCode == null) {
            resultPostalCode = postalCodeService.createPostalCode(postalCode);
        }
        return resultPostalCode;
    }

}
