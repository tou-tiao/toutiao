package com.fzu.service;

import com.fzu.pojo.Article;
import com.fzu.pojo.Exclusive;
import com.fzu.repository.ArticleRepository;
import com.fzu.repository.ExclusiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ExclusiveRepository exclusiveRepository;

    /**
     * 通过参数查询所有分享的文章.
     * @param queryParam 查询参数
     * @return 文章列表
     */
    public List<Article> getArticleLists(String queryParam){
        return articleRepository.findByParam(queryParam);
    }

    /**
     * 通过参数查询独家号.
     * @param queryParam 参数为独家号名称
     * @return 独家号列表
     */
    public List<Exclusive> getExclusivesByParam(String queryParam){
        return exclusiveRepository.findByParam(queryParam);
    }

    /**
     * 通过ID 查询独家号.
     * @param exclusiveId 参数为独家号ID
     * @return 独家号
     */
    public Exclusive getExclusiveById(Long exclusiveId){
        return exclusiveRepository.findOne(exclusiveId);
    }
}
