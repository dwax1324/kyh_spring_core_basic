package kyh.springCoreBasic;

import kyh.springCoreBasic.member.Grade;
import kyh.springCoreBasic.member.Member;
import kyh.springCoreBasic.member.MemberService;
import kyh.springCoreBasic.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member1 = new Member(1L, "woojong", Grade.BASIC);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);
        System.out.println("newMember = " + member1.getName());
        System.out.println("findMember = " + findMember.getName());
        System.out.println("isSame = " + (member1 == findMember));
    }
}
