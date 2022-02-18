package com.hello.springcore;

import com.hello.springcore.discount.DiscountPolicy;
import com.hello.springcore.discount.FixDiscountPolicy;
import com.hello.springcore.discount.RateDiscountPolicy;
import com.hello.springcore.member.MemberRepository;
import com.hello.springcore.member.MemberService;
import com.hello.springcore.member.MemberServiceImpl;
import com.hello.springcore.member.MemoryMemberRepository;
import com.hello.springcore.order.OrderService;
import com.hello.springcore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링 설정 정보
public class AppConfig {
    //구성 영역
    //관심사의 분리 구현체들은 AppConfig 에서 주입해준다.
    //이제 구현체를 변경하고 싶다면 AppConfig 에서 변경해주면 된다.

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
