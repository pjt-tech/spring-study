package com.hello.springcore;

import com.hello.springcore.member.Grade;
import com.hello.springcore.member.Member;
import com.hello.springcore.member.MemberService;
import com.hello.springcore.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberTest {

    public static void main(String[] args) {
        /*AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findById(member.getId());

        System.out.println("Member = " + member);
        System.out.println("findMember = " + findMember);
    }
}
