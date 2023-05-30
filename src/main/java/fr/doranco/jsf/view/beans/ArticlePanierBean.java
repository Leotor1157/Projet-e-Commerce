package fr.doranco.jsf.view.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "articlePanierbean")
@SessionScoped
public class ArticlePanierBean {

	private String quantite;
	
	private ArticlePanierBean() {
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
}
