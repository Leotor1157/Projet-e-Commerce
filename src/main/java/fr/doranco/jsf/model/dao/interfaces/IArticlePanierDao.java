package fr.doranco.jsf.model.dao.interfaces;

import fr.doranco.jsf.entity.ArticlePanier;

public interface IArticlePanierDao {

	void createArticlePanier(ArticlePanier articlePanier) throws Exception;
	ArticlePanier getArticlePanier(Integer id) throws Exception;
    void updateArticlePanier(ArticlePanier articlePanier) throws Exception;
    void deleteArticlePanier(ArticlePanier articlePanier) throws Exception;
}
