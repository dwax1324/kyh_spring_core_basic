package kyh.springCoreBasic;

import kyh.springCoreBasic.member.Grade;
import kyh.springCoreBasic.member.Member;
import kyh.springCoreBasic.member.MemberService;
import kyh.springCoreBasic.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member1 = new Member(1L, "woojong", Grade.BASIC);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);
        System.out.println("newMember = " + member1.getName());
        System.out.println("findMember = " + findMember.getName());
        System.out.println("isSame = " + (member1 == findMember));
    }
}
