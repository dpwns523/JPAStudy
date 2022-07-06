package com.example.jpastudy.service;

import com.example.jpastudy.entity.MemberEntity;

public interface MemberService {
    Long join(MemberEntity memberEntity);
    MemberEntity findById(Long id);
}
