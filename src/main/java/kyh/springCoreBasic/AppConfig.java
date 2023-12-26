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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*

 */

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}