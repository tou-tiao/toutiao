package com.fzu.repository;

import com.fzu.pojo.Exclusive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExclusiveRepository extends JpaRepository<Exclusive, Long> {

    @Query("select p from Exclusive p where p.ownUser.id = ?1")
    Exclusive findByOwnUserId(Long userId);// 根据用户id 查找其拥有的独家号
}
