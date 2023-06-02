package fr.doranco.jsf.control.interfaces;

import java.util.List;

import fr.doranco.jsf.entity.Article;

public interface IArticleMetier {

    void createArticle(Article article) throws Exception;
    Article getArticle(Integer id) throws Exception;
    void updateArticle(Article article) throws Exception;
    void deleteArticle(Article article) throws Exception;
    List<Article> getAllArticles() throws Exception;
}

