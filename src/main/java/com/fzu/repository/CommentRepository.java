package com.fzu.repository;

import com.fzu.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select p from Comment p where p.article.id = ?1")
    Comment findByArticleId(Long articleId);
}
