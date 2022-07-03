package com.sparta.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // findAll By OrderBy ModifiedAt Desc
    // 수정된 날짜를 기준으로 내림차순 정렬 해줘
    // List<Memo> findAllByOrderByModifiedAtDesc();
    List<Memo> findAllByOrderByModifiedAtDesc();
}