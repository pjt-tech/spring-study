package com.hello.springcore.order;

import com.hello.springcore.discount.DiscountPolicy;
import com.hello.springcore.member.Member;
import com.hello.springcore.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    //추상화에만 의존하고 구성영역에서 구현체를 생성자를 통해 주입받는다.
    //이제 각자 기능만 실행시키면된다. AppConfig의 등장으로 OCP,DIP 를 만족시키는 코드로 변경되었다.
    //클라이언트 객체의 책임이 명확해진다. 단일 책임의 원칙 SRP
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired //기존 AppConfig로 수동등록이 아닌 컴포넌트 스캔을 사용하면 Autowired를 사용하여 의존관계 자동 등록을 해줘야 한다.
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

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
