package fr.doranco.jsf.entity;

import java.util.Date;

public class CartePaiement {

	private Integer id;
	private String nomProprietaire;
	private String prenomProprietaire;
	private Byte[] numero;
	private Date dateFinValidite;
	private Byte[] cryptogramme;
	private Integer utilisateur;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Byte[] getNumero() {
		return numero;
	}
	public void setNumero(Byte[] numero) {
		this.numero = numero;
	}
	public Date getDateFinValidite() {
		return dateFinValidite;
	}
	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}
	public Byte[] getCryptogramme() {
		return cryptogramme;
	}
	public void setCryptogramme(Byte[] cryptogramme) {
		this.cryptogramme = cryptogramme;
	}
	public Integer getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Integer utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
