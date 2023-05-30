package fr.doranco.jsf.entity;

import java.util.List;

public class Commentaire {

	private Integer id;
	private String texte;
	private String note;
	private List<Article> article;
	private Integer userId;
	
	public Commentaire(Integer id, String texte, String note, Integer userId) {
		this.id = id;
		this.texte = texte;
		this.note = note;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
