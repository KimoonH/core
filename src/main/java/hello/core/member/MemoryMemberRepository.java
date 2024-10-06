package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// memoryMemberRepository 로 등록된다. 앞글자가 소문자로 변함.
@Component
public class MemoryMemberRepository implements MemberRepository {

    // 저장소를 만든다. 근데 왜 Map으로 사용했을까? Key값을 조회하기 위해서?
    // 동시성 이슈: ConcurrentRequest.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
