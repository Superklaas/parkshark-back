package com.superklaas.domain.repository;

import com.superklaas.domain.models.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {

}
