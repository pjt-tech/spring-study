package com.hello.springcore.discount;

import com.hello.springcore.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
