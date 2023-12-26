package kyh.springCoreBasic.beanfind;

import static org.assertj.core.api.Assertions.assertThat;

import kyh.springCoreBasic.AppConfig;
import kyh.springCoreBasic.member.MemberRepository;
import kyh.springCoreBasic.member.MemberService;
import kyh.springCoreBasic.member.MemberServiceImpl;
import kyh.springCoreBasic.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Same;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
    void findBeanByName() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,()->ac.getBean(MemberRepository.class));
    }

    @Configuration
    static class SameBeanConfig { // NoUniqueBeanDefinitionException 발생
        @Bean
        public MemberRepository memberRepository() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }

    }
}