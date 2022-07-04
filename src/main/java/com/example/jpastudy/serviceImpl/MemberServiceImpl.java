package com.example.jpastudy.serviceImpl;

import com.example.jpastudy.domain.Member;
import com.example.jpastudy.entity.MemberEntity;
import com.example.jpastudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Long join(MemberEntity memberEntity) {
        em.persist(memberEntity);
        return memberEntity.getId();
    }

    @Override
    public MemberEntity findById(Long id) {
        return em.find(MemberEntity.class, id);
    }
}
