package fr.doranco.jsf.model.dao.interfaces;

import fr.doranco.jsf.entity.Categorie;

public interface ICategorieDao {

	void createCategorie(Categorie categorie) throws Exception;
	Categorie getCategorie(Integer id) throws Exception;
    void updateCategorie(Categorie categorie) throws Exception;
    void deleteCategorie(Categorie categorie) throws Exception;
}
