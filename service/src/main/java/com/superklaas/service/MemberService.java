package com.superklaas.service;


import com.superklaas.domain.models.address.Address;
import com.superklaas.domain.models.address.PostalCode;
import com.superklaas.domain.models.member.Member;
import com.superklaas.domain.repository.AccountRepository;
import com.superklaas.domain.repository.MemberRepository;
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
    @Autowired
    private AccountRepository accountRepository;

    public Member createMember(Member member) {
        getOrCreatePostalCode(member);
        checkIfEmailAccountExists(member);
        return memberRepository.save(member);
    }

    private void getOrCreatePostalCode(Member member) {
        Address address = member.getAddress();
        PostalCode resultPostalCode = postalCodeService.getByPostalCode(address.getPostalCode().getPostalCode());
        if (resultPostalCode == null) {
            resultPostalCode = postalCodeService.createPostalCode(address.getPostalCode());
        }
        address.setPostalCode(resultPostalCode);
    }

    private void checkIfEmailAccountExists(Member member) {
        if (accountRepository.findAccountByEmail(member.getAccount().getEmail()) != null) {
            throw new DataIntegrityViolationException("this email address already exists");
        }
    }

    public Member findById(int memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isEmpty()) {
            throw new MemberDoesNotExistException("This member does not exist");
        }
        return member.get();
    }
}
