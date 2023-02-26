package com.sparta.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();
}
    /*
    쿼리문을 날릴 때, JpaRepository에 있는 메서드 외에, 내가 원하는 식으로 (커스터마이징해서) 쿼리문을 생성하고자 한다.
    해당 페이지 참고해서 원하는 쿼리문 생성할 수 있음. (https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)
    ex) findAll()을 하는데 최신순으로 정렬해줘.
        findAll By OrderBy ModifiedAt Desc();
        -> 순서대로(By OrderBy) 정렬해서 찾아줘. 어떤 순서로? ModifiedAt 칼럼 기준 최신순. 즉 내림차순(Desc)
    */