package hello.core.member;

public interface MemberRepository {
    // 저장하는 기능
    void save(Member member);
    // 조회하는 기능
    Member findById(Long memberId);
}
