package fr.doranco.jsf.entity;


import java.util.List;

public class LigneDeCommande {

	private Integer id;
	private Integer quantite;
	private String prixUnitaire;
	private String remiseArticle;
	private List<Commande> commande;
	private List<Article> article;
	
	public LigneDeCommande(Integer id, Integer quantite, String prixUnitaire, String remiseArticle) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public String getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(String prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public String getRemiseArticle() {
		return remiseArticle;
	}

	public void setRemiseArticle(String remiseArticle) {
		this.remiseArticle = remiseArticle;
	}

	public List<Commande> getCommande() {
		return commande;
	}

	public List<Article> getArticle() {
		return article;
	}
	
	
	
}
