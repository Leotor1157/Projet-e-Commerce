package fr.doranco.jsf.entity;

import java.util.Date;
import java.util.List;

public class Commande {

	private Integer id;
	private Integer numero;
	private Date dateCreation;
	private Date dateLivraison;
	private String totalRemise;
	private String fraisExpedition;
	private String totalGeneral;
	private String adresseFacturation;
	private String adresseLivraison;
	private List<CartePaiement> cartePaiementDefaut;
	private Integer userId;
	private List<LigneDeCommande> lignesCommande;
	
	public Commande(Integer numero, Date dateCreation, Date dateLivraison, String totalRemise,
			String fraisExpedition, String totalGeneral, String adresseFacturation, String adresseLivraison) {
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.totalRemise = totalRemise;
		this.fraisExpedition = fraisExpedition;
		this.totalGeneral = totalGeneral;
		this.adresseFacturation = adresseFacturation;
		this.adresseLivraison = adresseLivraison;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getTotalRemise() {
		return totalRemise;
	}

	public void setTotalRemise(String totalRemise) {
		this.totalRemise = totalRemise;
	}

	public String getFraisExpedition() {
		return fraisExpedition;
	}

	public void setFraisExpedition(String fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}

	public String getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(String totalGeneral) {
		this.totalGeneral = totalGeneral;
	}

	public String getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(String adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public Integer getUserId() {
		return userId;
	}

	public void getUserId(Integer userId) {
		this.userId = userId;
	}

	public List<CartePaiement> getCartePaiementDefaut() {
		return cartePaiementDefaut;
	}

	public List<LigneDeCommande> getLignesCommande() {
		return lignesCommande;
	}
	
	
	
}
