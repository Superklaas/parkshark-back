package be.willekens.multi.module.template.service;

import be.willekens.multi.module.template.domain.models.address.Address;
import be.willekens.multi.module.template.domain.models.address.PostalCode;
import be.willekens.multi.module.template.domain.models.member.Member;
import be.willekens.multi.module.template.domain.repository.MemberRepository;
import be.willekens.multi.module.template.infrastructure.exceptions.InvalidEmailException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        try {
            return memberRepository.save(member);
        } catch (DataIntegrityViolationException e) {
            throw new InvalidEmailException("this email address already exists");
        }

    }

    public PostalCode getPostalCodeByPostalCodeOrCreateNewOne(PostalCode postalCode) {
        PostalCode resultPostalCode = postalCodeService.getByPostalCode(postalCode.getPostalCode());
        if (resultPostalCode == null) {
            resultPostalCode = postalCodeService.createPostalCode(postalCode);
        }
        return resultPostalCode;
    }

}
