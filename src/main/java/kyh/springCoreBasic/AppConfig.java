package kyh.springCoreBasic;

import kyh.springCoreBasic.discount.FixDiscountPolicy;
import kyh.springCoreBasic.member.Member;
import kyh.springCoreBasic.member.MemberService;
import kyh.springCoreBasic.member.MemberServiceImpl;
import kyh.springCoreBasic.member.MemoryMemberRepository;
import kyh.springCoreBasic.order.OrderService;
import kyh.springCoreBasic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}