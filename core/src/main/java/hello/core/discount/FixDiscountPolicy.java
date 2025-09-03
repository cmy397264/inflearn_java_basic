package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        //enum은 ==
        if (member.getGrade() == Grade.VIP)
            return discountFixAmount;
        return 0;
    }
}
