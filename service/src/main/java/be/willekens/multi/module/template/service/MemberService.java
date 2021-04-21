package be.willekens.multi.module.template.service;

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

    public Member createMember(Member member) {
       return memberRepository.save(member);
    }


}
