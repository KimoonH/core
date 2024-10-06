package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 여기서 구현 객체를 만든다.
// 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자 객체로 주입(연결) 해준다.
// 객체 생성과 연결은 AppConfig가 담당.
@Configuration
public class AppConfig {

    // @Bean memberService()을 호출하면 -> new MemoryMemberRepository()을 호출한다.
    // @Bean orderService()을 호출하면 -> new MemoryMemberRepository()을 호출한다.
    // 이러면 싱글톤이 깨지는 것이 아닌가?

    // 생성하고 생성자 주입!
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
        //return new RateDiscountPolicy();
    }
}

/*
    AppConfig를 통해서 관심사를 확실하게 분리했다.
    배역, 배우를 생각해보자
    AppConfig는 공역 기획자다.
    AppConfig는 구현 클래스를 선택한다. 배역에 맞는 담당 배우를 선택한다.
    애플리케이션이 어떻게 독작해야 할지 전체 구성을 책임진다.
    이제 각 배우들은 담당 기능을 실행하는 책임만 지면 된다.
    OrderServiceImpl은 기능을 실행하는 책임만 지면 된다.
 */
