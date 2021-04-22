package be.willekens.multi.module.template.service;

import be.willekens.multi.module.template.domain.models.users.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberServiceSpringTest {

    @Autowired
    private MemberService memberService;

    @Test
    void createMember_whenPostalCodeAlreadyExists(){

    }

    @Test
    void createMember_whenPostalCodeDoesNotAlreadyExistInDB(){

    }




}