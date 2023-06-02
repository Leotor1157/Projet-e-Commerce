package fr.doranco.jsf.control.interfaces;

import java.util.List;

import fr.doranco.jsf.entity.Categorie;

public interface ICategorieMetier {
	
	void createCategorie(Categorie categorie) throws Exception;
	Categorie getCategorie(Integer id) throws Exception;
	List<Categorie> getAllCategories() throws Exception;
    void updateCategorie(Categorie categorie) throws Exception;
    void deleteCategorie(Categorie categorie) throws Exception;
}
