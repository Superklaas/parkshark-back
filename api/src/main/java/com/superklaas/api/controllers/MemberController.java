package com.superklaas.api.controllers;

import com.superklaas.api.dtos.CreateMemberDto;
import com.superklaas.api.dtos.ReceiveMemberDto;
import com.superklaas.api.mappers.MemberMapper;
import com.superklaas.domain.models.member.Member;
import com.superklaas.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = MemberController.MEMBER_RESOURCE_PATH)
public class MemberController {
    public static final String MEMBER_RESOURCE_PATH = "/members";
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @Autowired
    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ReceiveMemberDto createMember(@RequestBody CreateMemberDto createMemberDto) {
        logger.info("Attempt to create a member");
         Member member = memberService.createMember(memberMapper.createMemberDto_to_Member(createMemberDto));
         return memberMapper.member_to_receiveMemberDto(member);
    }

}
