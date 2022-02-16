package com.hello.springcore.member;

import com.hello.springcore.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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
