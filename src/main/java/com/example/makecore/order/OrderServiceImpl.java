package com.example.makecore.order;

import com.example.makecore.discount.DiscountPolicy;
import com.example.makecore.discount.RateDiscountPolicy;
import com.example.makecore.member.Member;
import com.example.makecore.member.MemberRepository;
import com.example.makecore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
