package com.hello.springcore.member;

public interface MemberService {

    void join(Member member);

    Member findById(Long id);
}
