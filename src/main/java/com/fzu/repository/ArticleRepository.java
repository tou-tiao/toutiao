package com.fzu.repository;

import com.fzu.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findById(Long articleId);
    Article findByTitleAndUrl(String title, String url);
    /**
     * 通过参数搜索匹配的文章(模糊查询)
     * @param queryParam 查询参数
     * @return 符合的文章
     */
    @Query("select p from Article p where p.title like CONCAT('%',:queryParam,'%')")
    List<Article> findByParam(@Param("queryParam") String queryParam);

    /**
     * @param exclusiveIds 独家号IDs
     * @return 独家号在该日期之后分享的文章
     */
    @Query("select p from Article p where p.exclusive.id in(?1) order by p.createTime desc")
    List<Article> findByExclusiveIds(List<Long> exclusiveIds);
}
