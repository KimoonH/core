package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 회원이 적용되어야 한다.")
    void vip_o() {
        // given(멤버를 만들고)
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        // when (적용할 무언가)
        int discount = discountPolicy.discount(member, 10000);
        // then (예상 답변)
        assertThat(discount).isEqualTo(1000);
    }

    // 실패 테스트도 만들어야 한다. VIP가 아닌 경우
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        // given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(0);
    }
}