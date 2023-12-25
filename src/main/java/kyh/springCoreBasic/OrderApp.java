package kyh.springCoreBasic;

import kyh.springCoreBasic.member.Grade;
import kyh.springCoreBasic.member.Member;
import kyh.springCoreBasic.member.MemberService;
import kyh.springCoreBasic.member.MemberServiceImpl;
import kyh.springCoreBasic.order.Order;
import kyh.springCoreBasic.order.OrderService;
import kyh.springCoreBasic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberService memberService = appConfig.memberService();

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "item A", 10000);
        System.out.println("order =" + order);
    }
}
