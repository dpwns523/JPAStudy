package com.example.jpastudy.service.serviceImpl;

import com.example.jpastudy.entity.Member;
import com.example.jpastudy.repository.MemberRepository;
import com.example.jpastudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findOne(id);
    }
}
