package fr.doranco.jsf.model.dao.interfaces;

import fr.doranco.jsf.entity.Article;
import java.util.List;

public interface IArticleDao {
    void createArticle(Article article) throws Exception;
    Article getArticle(Integer id) throws Exception;
    void updateArticle(Article article) throws Exception;
    void deleteArticle(Article article) throws Exception;
    List<Article> getAllArticles() throws Exception;
}
