package fr.doranco.jsf.view.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.doranco.jsf.entity.Commentaire;

@ManagedBean(name = "commentairebean")
@SessionScoped
public class CommentaireBean {
	
	private String texte;
	private String note;
	
	private static List<Commentaire> commentaires = new ArrayList<Commentaire>();
	
	public CommentaireBean() {
		commentaires.clear();
	}

	public void addCommentaire() {
		//Commentaire commentaire = new Commentaire(texte, note);
		//commentaires.add(commentaire);
	}
	
	public void initializeCommentaire() {
		this.texte = "";
		this.note = "";
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

	public static List<Commentaire> getCommentaires() {
		return commentaires;
	}
	
	
}
