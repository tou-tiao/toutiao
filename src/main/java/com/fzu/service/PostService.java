package com.fzu.service;

import com.fzu.pojo.Article;
import com.fzu.pojo.Exclusive;
import com.fzu.repository.ArticleRepository;
import com.fzu.repository.ExclusiveRepository;
import com.fzu.web.controller.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 发布文章.
 */
@Service
public class PostService {

    @Autowired
    private ExclusiveRepository exclusiveRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ViewUtils viewUtils;
    @Autowired
    private CountingService countingService;

    /**
     * 分享文章到独家号.
     * @param publicName 独家号
     * @param title 文章标题
     * @param url 文章链接
     * @return  true 表示分享成功，false 表示分享失败
     */
    public boolean shareArticle(String publicName, String title, String url){

        Exclusive exclusive = exclusiveRepository.findByPublicName(publicName);
        Article article = new Article();
        article.setExclusive(exclusive);
        article.setTitle(title);
        article.setUrl(url);
        articleRepository.save(article);
        Article article1 = articleRepository.findByTitleAndUrl(title, url);
        if(null != article1){
            countingService.countUserShare(viewUtils.getCurrentUser().getId(), 'U');
            countingService.countExclusiveShare(exclusive.getId(), 'U');
            return true;
        }
        return false;
    }

    /**
     * 检查分享链接是否为http://或https://开头.
     * @param link 链接
     * @return boolean
     */
    public boolean checkLink(String link){
        String expl = "^(http|https|www|)?(://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*)*(\\w*)*)$";
        Pattern pattern = Pattern.compile(expl);
        Matcher matcher = pattern.matcher(link);
        return matcher.matches();
    }
}
