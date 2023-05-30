package fr.doranco.jsf.entity;

import java.util.List;

public class Categorie {

	private Integer id;
	private String nom;
	private Integer remise;
	private Boolean isRemiseCumulable;
	private String photo;
	private List<Article> articles;
	
	public Categorie(String nom, Integer remise, Boolean isRemiseCumulable, String photo) {
		this.nom = nom;
		this.remise = remise;
		this.isRemiseCumulable = isRemiseCumulable;
		this.photo = photo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getRemise() {
		return remise;
	}

	public void setRemise(Integer remise) {
		this.remise = remise;
	}

	public Boolean getIsRemiseCumulable() {
		return isRemiseCumulable;
	}

	public void setIsRemiseCumulable(Boolean isRemiseCumulable) {
		this.isRemiseCumulable = isRemiseCumulable;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Article> getArticles() {
		return articles;
	}
	
	
}
