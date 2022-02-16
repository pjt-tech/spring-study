package com.hello.springcore.order;

import com.hello.springcore.discount.DiscountPolicy;
import com.hello.springcore.member.Member;
import com.hello.springcore.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    //추상화에만 의존하고 구성영역에서 구현체를 생성자를 통해 주입받는다.
    //이제 각자 기능만 실행시키면된다. AppConfig의 등장으로 OCP,DIP 를 만족시키는 코드로 변경되었다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long id, String itemName, int price) {

        Member member = memberRepository.findById(id);
        int discount = discountPolicy.discount(member, price);

        return new Order(id,itemName,price,discount);
    }
}
