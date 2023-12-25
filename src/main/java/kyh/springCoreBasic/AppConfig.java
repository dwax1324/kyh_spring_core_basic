package kyh.springCoreBasic;

import kyh.springCoreBasic.discount.DiscountPolicy;
import kyh.springCoreBasic.discount.FixDiscountPolicy;
import kyh.springCoreBasic.discount.RateDiscountPolicy;
import kyh.springCoreBasic.member.Member;
import kyh.springCoreBasic.member.MemberService;
import kyh.springCoreBasic.member.MemberServiceImpl;
import kyh.springCoreBasic.member.MemoryMemberRepository;
import kyh.springCoreBasic.order.OrderService;
import kyh.springCoreBasic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }


    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}