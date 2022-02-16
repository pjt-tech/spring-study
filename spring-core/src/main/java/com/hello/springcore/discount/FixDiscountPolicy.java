package com.hello.springcore.discount;

import com.hello.springcore.member.Grade;
import com.hello.springcore.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private final int FixDiscountPrice = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return FixDiscountPrice;
        }
        return 0;
    }
}
