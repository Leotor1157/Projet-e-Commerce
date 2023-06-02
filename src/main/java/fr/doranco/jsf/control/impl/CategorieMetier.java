package fr.doranco.jsf.control.impl;

import java.util.List;

import fr.doranco.jsf.control.interfaces.ICategorieMetier;
import fr.doranco.jsf.entity.Categorie;
import fr.doranco.jsf.model.dao.impl.CategorieDao;
import fr.doranco.jsf.model.dao.interfaces.ICategorieDao;

public class CategorieMetier implements ICategorieMetier{

	private static ICategorieDao categorieDao = new CategorieDao();
	@Override
	public void createCategorie(Categorie categorie) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categorie getCategorie(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> getAllCategories() throws Exception {
		return categorieDao.getAllCategories();
	}

	@Override
	public void updateCategorie(Categorie categorie) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategorie(Categorie categorie) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
