package com.hello.springcore.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class MemberServiceTest {

    private final MemberService memberService = new MemberServiceImpl();

    @Test
    public void join() throws Exception {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        //when
        Member findMember = memberService.findById(member.getId());
        //then
        Assertions.assertThat(findMember).isEqualTo(member);
    }
}
