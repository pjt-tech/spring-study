package hello.core.order;

import hello.core.discount.Order;
import hello.core.discount.OrderService;
import hello.core.discount.OrderServiceImpl;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() throws Exception {
        //given
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);
        //when
        Order order = orderService.createOrder(member.getId(), "itemA", 10000);
        //then
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
        assertThat(order.calculatePrice()).isEqualTo(9000);
    }
}
