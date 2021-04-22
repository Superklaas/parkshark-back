package be.willekens.multi.module.template.service;

import be.willekens.multi.module.template.domain.models.users.Member;
import be.willekens.multi.module.template.domain.repository.MemberRepository;
import be.willekens.multi.module.template.infrastructure.exceptions.MemberDoesNotExistException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@NoArgsConstructor
public class MemberService {
    @Autowired
   private MemberRepository memberRepository;

    public Member createMember(Member member) {
       return memberRepository.save(member);
    }


    public Member findById(int memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isEmpty()) {
            throw new MemberDoesNotExistException("This member does not exist");
        }
        return member.get();
    }
}
