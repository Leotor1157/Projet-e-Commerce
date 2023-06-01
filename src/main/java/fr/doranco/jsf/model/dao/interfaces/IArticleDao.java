package fr.doranco.jsf.model.dao.interfaces;

import fr.doranco.jsf.entity.Article;
import java.util.List;

public interface IArticleDao {
    void createArticle(Article article);
    Article getArticle(Integer id);
    void updateArticle(Article article);
    void deleteArticle(Article article);
    List<Article> getAllArticles();
}
