package be.willekens.multi.module.template.domain.repository;

import be.willekens.multi.module.template.domain.models.users.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {

}
