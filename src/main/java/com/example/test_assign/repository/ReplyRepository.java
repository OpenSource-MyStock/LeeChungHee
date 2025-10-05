package com.example.test_assign.repository;

import com.example.test_assign.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {
    @Query(value = "select b from ReplyEntity b where b.id =:id")
    List<ReplyEntity> findReplysTo(@Param("id") int id);
}
