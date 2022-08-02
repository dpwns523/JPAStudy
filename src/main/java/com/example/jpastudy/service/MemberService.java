package com.example.jpastudy.service;

import com.example.jpastudy.entity.Member;

public interface MemberService {
    Long join(Member member);
    Member findById(Long id);
}
