package com.hello.springcore.order;

import com.hello.springcore.discount.DiscountPolicy;
import com.hello.springcore.discount.FixDiscountPolicy;
import com.hello.springcore.member.Member;
import com.hello.springcore.member.MemberRepository;
import com.hello.springcore.member.MemoryMemberRepository;


public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long id, String itemName, int price) {

        Member member = memberRepository.findById(id);
        int discount = discountPolicy.discount(member, price);

        return new Order(id,itemName,price,discount);
    }
}
