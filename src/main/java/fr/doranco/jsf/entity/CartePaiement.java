package fr.doranco.jsf.entity;

import java.util.Date;

public class CartePaiement {

	private Integer id;
	private String nomProprietaire;
	private String prenomProprietaire;
	private String numero;
	private Date dateFinValidite;
	private String cryptogramme;
	private Integer userId;
	
	
	
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
