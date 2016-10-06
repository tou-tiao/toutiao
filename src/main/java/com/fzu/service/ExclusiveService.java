package com.fzu.service;

import com.fzu.pojo.Exclusive;
import com.fzu.repository.ArticleRepository;
import com.fzu.repository.ExclusiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 独家号.
 */
@Service
public class ExclusiveService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ExclusiveRepository exclusiveRepository;

    /**
     * 获取独家号信息
     * @return Exclusive
     */
    Exclusive getExclusiveInfo(Long publicId){
        Exclusive exclusive = exclusiveRepository.findOne(publicId);
        return exclusive;
    }

    /**
     * 申请独家号.
     * @return Exclusive
     */
    Exclusive applyExclusive(){
        return null;
    }


    /**
     * 删除分享到独家号的文章.
     */
    void deleteArticle(Long articleId){
        articleRepository.delete(articleId);
    }
}
