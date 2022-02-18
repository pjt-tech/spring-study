package com.hello.springcore.singleton;

import com.hello.springcore.AppConfig;
import com.hello.springcore.member.MemberRepository;
import com.hello.springcore.member.MemberServiceImpl;
import com.hello.springcore.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        //스프링 컨테이너는 CGLIB 이라는 바이트 조작 기술을 사용하여 AppConfig를 상속받아 bean 들의 싱글톤을 보장해준다.

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("memberService->memberRepository1 = " + memberRepository1);
        System.out.println("orderService->memberRepository2 = " + memberRepository2);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
}
