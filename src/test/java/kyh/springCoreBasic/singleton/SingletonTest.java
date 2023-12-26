package kyh.springCoreBasic.singleton;

import kyh.springCoreBasic.AppConfig;
import kyh.springCoreBasic.member.MemberService;
import kyh.springCoreBasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조갑싱 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2
        // AppConfigs 는 요청할 때마다 객체를 새로 생성한다.
        Assertions.assertThat(memberService1).isNotEqualTo(memberService2);
    }


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);
        // isSameAs : ==
        // isEqualTo : .equals()
        Assertions.assertThat(instance1).isSameAs(instance2);
    }

    @Test
    @DisplayName("스프링 컨테이너") // 스프링 컨테이너는 기본적으로 싱글톤
    void springContainer() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // 1 조회 : 호출할 때 마다 객체를 생성
        MemberServiceImpl memberService1 = ac.getBean("memberService", MemberServiceImpl.class);

        // 2 조회 : 호출할 때 마다 객체를 생성
        MemberServiceImpl memberService2 = ac.getBean("memberService", MemberServiceImpl.class);

        // 참조갑싱 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 == memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
