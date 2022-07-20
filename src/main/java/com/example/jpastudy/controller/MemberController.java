package com.example.jpastudy.controller;

import com.example.jpastudy.dto.Member;
import com.example.jpastudy.entity.Address;
import com.example.jpastudy.entity.MemberEntity;
import com.example.jpastudy.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/members")
    public Member.JoinMemberResponse saveMemberV1(@RequestBody @Valid Member.JoinMemberRequest joinMemberRequest) {

        Address address = new Address(joinMemberRequest.getCity(), joinMemberRequest.getStreet(), joinMemberRequest.getZipcode());

        MemberEntity memberEntity = MemberEntity.builder()
                                    .name(joinMemberRequest.getName())
                                    .address(address)
                                    .build();

        Long id = memberService.join(memberEntity);
        return new Member.JoinMemberResponse(id);
    }


}
