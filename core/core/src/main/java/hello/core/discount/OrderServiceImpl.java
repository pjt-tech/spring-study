package hello.core.discount;

import hello.core.member.*;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //단일책임원칙을 잘 지키고 있음 .. 멤버나 할인정책은 나는 모르겠고 값만 전달해줘..
        Member findMember = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(findMember, itemPrice);

        return new Order(memberId, itemName, itemPrice, discount);
    }
}
