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

public class AppConfig {
    //구성 영역
    //관심사의 분리 구현체들은 AppConfig 에서 주입해준다.
    //이제 구현체를 변경하고 싶다면 AppConfig 에서 변경해주면 된다.

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
