package hello.core.discount;

import hello.core.member.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //자동 빈 등록
public class OrderServiceImpl implements OrderService {

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;


    @Autowired //의존관계 자동 주입
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //단일책임원칙을 잘 지키고 있음 .. 멤버나 할인정책은 나는 모르겠고 값만 전달해줘..
        Member findMember = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(findMember, itemPrice);

        return new Order(memberId, itemName, itemPrice, discount);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
