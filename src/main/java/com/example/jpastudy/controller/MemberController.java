package com.example.jpastudy.controller;

import com.example.jpastudy.entity.Address;
import com.example.jpastudy.entity.Member;
import com.example.jpastudy.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/ping")
    public ResponseEntity healtyCheck(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/api/members")
    public com.example.jpastudy.dto.Member.JoinMemberResponse saveMemberV1(@RequestBody @Valid com.example.jpastudy.dto.Member.JoinMemberRequest joinMemberRequest) {

        Address address = new Address(joinMemberRequest.getCity(), joinMemberRequest.getStreet(), joinMemberRequest.getZipcode());

        Member member = Member.builder()
                                    .name(joinMemberRequest.getName())
                                    .address(address)
                                    .build();

        Long id = memberService.join(member);
        return new com.example.jpastudy.dto.Member.JoinMemberResponse(id);
    }


}
