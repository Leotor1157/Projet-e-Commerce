package fr.doranco.jsf.entity;


import java.util.List;

public class ArticlePanier {

	private Integer id;
	private List<Article> article;
	private String quantite;
	private Integer userId;
	
	public ArticlePanier(Integer id, String quantite, Integer userId) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Article> getArticle() {
		return article;
	}
	
	
}
