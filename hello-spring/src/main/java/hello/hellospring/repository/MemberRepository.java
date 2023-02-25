package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member meber); // 저장소에 저장
    Optional<Member> findById(Long id); // null 반환에 optional을 붙여 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
