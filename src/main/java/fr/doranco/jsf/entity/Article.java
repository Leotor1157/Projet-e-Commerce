package fr.doranco.jsf.entity;

import java.util.List;


public class Article {

	private Integer id;
	private String nom;
	private String description;
	private String prix;
	private String remise;
	private String stock;
	private Boolean isVendable;
	private String photos;
	private String videos;
	private List<Commentaire> commentaires;
	
	public Article(Integer id, String nom, String description, String prix, String remise, String stock,
			Boolean isVendable, String photos, String videos) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		this.isVendable = isVendable;
		this.photos = photos;
		this.videos = videos;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getRemise() {
		return remise;
	}

	public void setRemise(String remise) {
		this.remise = remise;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Boolean getIsVendable() {
		return isVendable;
	}

	public void setIsVendable(Boolean isVendable) {
		this.isVendable = isVendable;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getVideos() {
		return videos;
	}

	public void setVideos(String videos) {
		this.videos = videos;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	
	
	
}
