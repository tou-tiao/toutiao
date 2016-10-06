package com.fzu.repository;

import com.fzu.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    /**
     * 通过参数搜索匹配的文章(模糊查询)
     * @param queryParam 查询参数
     * @return 符合的文章
     */
    @Query("select p from Article p where p.title like CONCAT('%',:queryParam,'%')")
    List<Article> findByParam(@Param("queryParam") String queryParam);
}
