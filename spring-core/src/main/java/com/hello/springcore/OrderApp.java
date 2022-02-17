package com.hello.springcore;

import com.hello.springcore.discount.DiscountPolicy;
import com.hello.springcore.member.Grade;
import com.hello.springcore.member.Member;
import com.hello.springcore.member.MemberService;
import com.hello.springcore.order.Order;
import com.hello.springcore.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "itemA", 10000);
        System.out.println(order.getDiscount());
        System.out.println(order.calcPrice());
    }
}
