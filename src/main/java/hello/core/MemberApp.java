package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        // 환경설정 정보를 가져온다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 메서드 이름, 메서드 타입을 MemberService객체에 담아준다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + findMember.getName());
        System.out.println("find member = " + member.getName());
    }
}

/*
    회원 도메인 설계의 문제점
    다른 저장소를 변경할 때 OCP 원칙을 잘 준수하는걸까?
    DIP를 잘 지키고 있을까?
    추상화에도 구현체에도 의존한다는 문제를 안고 있다.
    의존관계가 인터페이스뿐만 아니라 구현까지 모두 의존하는 문제를 갖고 있다.
 */