package com.example.jpastudy.service.serviceImpl;

import com.example.jpastudy.entity.MemberEntity;
import com.example.jpastudy.repository.MemberRepository;
import com.example.jpastudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long join(MemberEntity memberEntity) {
        memberRepository.save(memberEntity);
        return memberEntity.getId();
    }

    @Override
    public MemberEntity findById(Long id) {
        return memberRepository.findOne(id);
    }
}
