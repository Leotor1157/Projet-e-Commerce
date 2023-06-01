package fr.doranco.jsf.view.beans;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.doranco.jsf.control.impl.CategorieMetier;
import fr.doranco.jsf.control.interfaces.ICategorieMetier;
import fr.doranco.jsf.entity.Categorie;

@ManagedBean(name = "categoriebean")
@SessionScoped
public class CategorieBean {
	
	private ICategorieMetier categorieMetier = new CategorieMetier();
	private String nom;
	private String remise;
	private String photo;
	
	
	public CategorieBean() {
	}
	
	public List<Categorie> getAllCategories() {
		try {
			return categorieMetier.getAllCategories();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRemise() {
		return remise;
	}

	public void setRemise(String remise) {
		this.remise = remise;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
