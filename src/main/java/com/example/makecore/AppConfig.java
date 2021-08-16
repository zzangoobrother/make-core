package com.example.makecore;

import com.example.makecore.discount.DiscountPolicy;
import com.example.makecore.discount.RateDiscountPolicy;
import com.example.makecore.member.MemberRepository;
import com.example.makecore.member.MemberService;
import com.example.makecore.member.MemberServiceImpl;
import com.example.makecore.member.MemoryMemberRepository;
import com.example.makecore.order.OrderService;
import com.example.makecore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
