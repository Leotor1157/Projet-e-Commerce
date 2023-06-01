package fr.doranco.jsf.view.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.doranco.jsf.entity.Adresse;
import fr.doranco.jsf.entity.CartePaiement;

@ManagedBean(name = "cartePaiementbean")
@SessionScoped
public class CartePaiementBean {
	
	private String nomProprietaire;
	
	private String prenomProprietaire;
	
	private String numero;
	
	private Date dateFinValidite;
	
	private String cryptogramme;
	
	private static List<CartePaiement> cartePaiements = new ArrayList<CartePaiement>();
	
	public CartePaiementBean() {
		cartePaiements.clear();
	}

	public void addCartePaiement() {
		CartePaiement cartePaiement = new CartePaiement();
		cartePaiement.setNomProprietaire(nomProprietaire);
		cartePaiement.setPrenomProprietaire(prenomProprietaire);
		cartePaiement.setNumero(numero);
		cartePaiement.setDateFinValidite(dateFinValidite);
		cartePaiement.setCryptogramme(cryptogramme);
		cartePaiements.add(cartePaiement);
	}
	
	public void initializeCartePaiement() {
		this.nomProprietaire = "";
		this.prenomProprietaire = "";
		this.numero = "";
		this.dateFinValidite = null;
		this.cryptogramme = "";
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getPrenomProprietaire() {
		return prenomProprietaire;
	}

	public void setPrenomProprietaire(String prenomProprietaire) {
		this.prenomProprietaire = prenomProprietaire;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public List<CartePaiement> getCartePaiements() {
		return cartePaiements;
	}
}
