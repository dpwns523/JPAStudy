package com.example.jpastudy.repository;

import com.example.jpastudy.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(MemberEntity memberEntity) {
        em.persist(memberEntity);
    }

    public MemberEntity findOne(Long id) {
        return em.find(MemberEntity.class, id);
    }

}
