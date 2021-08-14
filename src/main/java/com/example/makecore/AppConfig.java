package com.example.makecore;

import com.example.makecore.discount.DiscountPolicy;
import com.example.makecore.discount.RateDiscountPolicy;
import com.example.makecore.member.MemberRepository;
import com.example.makecore.member.MemberService;
import com.example.makecore.member.MemberServiceImpl;
import com.example.makecore.member.MemoryMemberRepository;
import com.example.makecore.order.OrderService;
import com.example.makecore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
