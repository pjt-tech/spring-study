package com.hello.springcore.order;

import com.hello.springcore.AppConfig;
import com.hello.springcore.member.Grade;
import com.hello.springcore.member.Member;
import com.hello.springcore.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {

    OrderService orderService;
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    public void createOrder() throws Exception {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        int price = order.calcPrice();
        //then
        assertThat(price).isEqualTo(9000);
        assertThat(order.getDiscount()).isEqualTo(1000);

    }
}
