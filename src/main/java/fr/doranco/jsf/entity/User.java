package fr.doranco.jsf.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String genre;
	private String prenom;
	private String nom;
	private Date dateNaissance;
	private String email;
	private String password;
	private String niveauService;
	private List<String> langagesSouhaites;
	private List<Adresse> adresses;

	public String niveaudeservice;

	public User() {
		this.langagesSouhaites = new ArrayList<String>();
		this.adresses = new ArrayList<Adresse>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public String getNiveauService() {
		return niveauService;
	}

	public void setNiveauService(String niveauService) {
		this.niveauService = niveauService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getLangagesSouhaites() {
		return langagesSouhaites;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	@Override
	public String toString() {
		return "User [genre=" + genre + ", prenom=" + prenom + ", nom=" + nom + ", dateNaissance=" + dateNaissance
				+ ", email=" + email + ", password=" + password + ", niveauService=" + niveauService
				+ ", niveaudeservice=" + niveaudeservice + "]";
	}

}//test2
