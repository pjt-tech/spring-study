package com.hello.springcore.order;

import com.hello.springcore.member.Grade;
import com.hello.springcore.member.Member;
import com.hello.springcore.member.MemberService;
import com.hello.springcore.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    OrderService orderService = new OrderServiceImpl();
    MemberService memberService = new MemberServiceImpl();

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
        Assertions.assertThat(price).isEqualTo(9000);

    }
}
