package com.fzu.repository;

import com.fzu.pojo.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {

    @Query("select p from Subscribe p where p.exclusive.id = ?1 and p.user.id = ?2")
    Subscribe findByExclusiveIdAndUserId(Long exclusiveId, Long userId);

    @Query("select p from Subscribe p where p.user.id = ?1")
    List<Subscribe> findByUserId(Long userId);
}
