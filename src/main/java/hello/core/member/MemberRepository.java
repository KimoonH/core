package hello.core.member;

import org.springframework.context.annotation.Primary;

public interface MemberRepository {
    // 저장하는 기능
    void save(Member member);
    // 조회하는 기능
    Member findById(Long memberId);
}
