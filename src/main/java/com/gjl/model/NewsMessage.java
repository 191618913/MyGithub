package com.gjl.model;

import java.util.List;

/**
 * Created by Administrator on 2018/4/16.
 */
public class NewsMessage extends  BaseMessage{
    private Integer ArticleCount;

    private List<News> Articles;

    public List<News> getArticles() {
        return Articles;
    }

    public void setArticles(List<News> articles) {
        Articles = articles;
    }

    public Integer getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(Integer articleCount) {
        ArticleCount = articleCount;
    }
}
