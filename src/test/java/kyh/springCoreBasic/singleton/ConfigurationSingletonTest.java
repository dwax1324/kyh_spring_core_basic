package kyh.springCoreBasic.singleton;

import kyh.springCoreBasic.AppConfig;
import kyh.springCoreBasic.member.MemberRepository;
import kyh.springCoreBasic.member.MemberService;
import kyh.springCoreBasic.member.MemberServiceImpl;
import kyh.springCoreBasic.member.MemoryMemberRepository;
import kyh.springCoreBasic.order.OrderService;
import kyh.springCoreBasic.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSingletonTest {


    /*
        @Configuration과 @Bean의 조합으로 싱글톤을 보장하는 경우는 정적이지 않은 메서드일 때입니다.
        정적 메서드에 @Bean을 사용하게 되면 싱글톤 보장을 위한 지원을 받지 못합니다.
        Appconfig.memberRepository를 static으로 하면은 밑에 세개의 주소가 다 다르게 나온다.
     */
    @Test
    @DisplayName("@Configuration과 싱글톤")
    void test(){
        ApplicationContext ac  = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        MemberRepository memberRepository3 = ac.getBean("memberRepository", MemberRepository.class);

        System.out.println("memberService -> memberRepository " + memberRepository1);
        System.out.println("orderService -> memberRepository " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository3);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
        Assertions.assertThat(memberRepository2).isSameAs(memberRepository3);
        Assertions.assertThat(memberRepository3).isSameAs(memberRepository1);
    }


    @Test
    @DisplayName("AppConfig 바이트코드 SpringCGLIB")
    void configurationDeep(){
        ApplicationContext ac  = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean);
    }
}
