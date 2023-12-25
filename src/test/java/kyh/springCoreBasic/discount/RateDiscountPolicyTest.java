package kyh.springCoreBasic.discount;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import kyh.springCoreBasic.member.Grade;
import kyh.springCoreBasic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10프로 할인이 적용됨")
    void vip_o(){
        //given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(memberVIP,10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용되지 않아야 한다")
    void vip_x(){
        //given
        Member memberVIP = new Member(1L, "memberVIP", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(memberVIP,10000);
        //then
        assertThat(discount).isEqualTo(0);
    }

}