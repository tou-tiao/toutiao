package com.fzu.service;

import com.fzu.pojo.Article;
import com.fzu.pojo.Collect;
import com.fzu.pojo.Comment;
import com.fzu.pojo.User;
import com.fzu.repository.ArticleRepository;
import com.fzu.repository.CollectRepository;
import com.fzu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CollectRepository collectRepository;

    /**
     * 获取文章内容.
     * @return Article
     */
    Article getArticleContent(Long articleId){
        return articleRepository.findOne(articleId);
    }

    /**
     * 获取文章评论.
     * @param articleId 文章ID
     * @return Set<Comment>
     */
    Set<Comment> getCommentList(Long articleId){
        Article article = articleRepository.findOne(articleId);
        return article.getComments();
    }

    /**
     * 评论文章.
     * @return Comment
     */
    Comment commentArticle(){
        return null;
    }

    /**方法不可用
     * 收藏文章.
     * @author w
     * @param articleId 文章ID
     * @param userId 用户ID
     * @return true: 代表收藏成功
     */
    boolean collectArticle(Long articleId, Long userId){

        Article article = articleRepository.findOne(articleId);
        User user = userRepository.findOne(userId);

        Collect collect = new Collect();
        collect.setUser(user);
        collect.setArticle(article);
        article.getCollects().add(collect);

        articleRepository.save(article);
        return false;
    }
}
