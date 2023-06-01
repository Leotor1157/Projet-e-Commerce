package fr.doranco.jsf.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.doranco.jsf.enums.ProfilEnum;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private Boolean isActif;
	private ProfilEnum profil;
	private String email;
	private String password;
	private String telephone;
	private List<Adresse> adresses;
	private List<Commande> commandes;
	private List<CartePaiement> cartesDePaiement;
	private List<Commentaire> commentaires;
	private List<ArticlePanier> panier;

	
	public User(String nom, String prenom, Date dateNaissance, Boolean isActif, ProfilEnum profil, String email,
			String password, String telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.isActif = isActif;
		this.profil = profil;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
	}

	public User() {
		this.adresses = new ArrayList<Adresse>();
		this.commandes = new ArrayList<Commande>();
		this.cartesDePaiement = new ArrayList<CartePaiement>();
		this.commentaires = new ArrayList<Commentaire>();
		this.panier = new ArrayList<ArticlePanier>();
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
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Boolean getIsActif() {
		return isActif;
	}
	
	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public ProfilEnum getProfil() {
		return profil;
	}

	public void setProfil(ProfilEnum profil) {
		this.profil = profil;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}
	
	public List<Commande> getCommandes() {
		return commandes;
	}
	
	public List<CartePaiement> getCartesDePaiement() {
		return cartesDePaiement;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	
	public List<ArticlePanier> getPanier() {
		return panier;
	}
	
	@Override
	public String toString() {
		return "User [prenom=" + prenom + ", nom=" + nom + ", dateNaissance=" + dateNaissance
				+ ", email=" + email + ", password=" + password + "]";
	}

}
