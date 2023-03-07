package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em; //jpa는 EntityManager로 모든 동작을 함. build.gradle에 data-jpa 추가했으면 스프링 부트가 자동으로 EntityManager 생성해줌.

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //persist() 영구 저장하다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);// pk 조회
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) { // pk 조회가 아닐 땐 jpa ql 작성해줘야함.
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList(); //테이블이 아니라 객체(엔티티)를 대상으로 쿼리를 날림, select m : 객체 자체를 선택
    }
}
