package com.fzu.repository;


import com.fzu.pojo.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollectRepository extends JpaRepository<Collect, Long> {
    Collect findById(Long collectId);

    @Query("select p from Collect p where p.user.id = ?1")
    List<Collect> findByUserId(Long userId);

    @Query("select p from Collect p where p.user.id = ?1 and p.article.id = ?2")
    Collect findByUserIdAndArticleId(Long userId, Long articleId);
}
