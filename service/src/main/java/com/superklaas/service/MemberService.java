package com.superklaas.service;


import com.superklaas.domain.models.address.Address;
import com.superklaas.domain.models.address.PostalCode;
import com.superklaas.domain.models.member.Member;
import com.superklaas.domain.repository.MemberRepository;
import com.superklaas.infrastructure.exceptions.InvalidEmailException;
import com.superklaas.infrastructure.exceptions.MemberDoesNotExistException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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

    public Member findById(int memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isEmpty()) {
            throw new MemberDoesNotExistException("This member does not exist");
        }
        return member.get();
    }
}
