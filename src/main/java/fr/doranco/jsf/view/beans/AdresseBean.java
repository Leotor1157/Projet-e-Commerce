package fr.doranco.jsf.view.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.jsf.entity.Adresse;

@ManagedBean(name = "adressebean")
@SessionScoped
public class AdresseBean {

	@ManagedProperty(name = "numero", value = "12")
	private String numero;
	
	@ManagedProperty(name = "rue", value = "Rue Victor Hugo")
	private String rue;
	
	@ManagedProperty(name = "ville", value = "Paris")
	private String ville;
	
	@ManagedProperty(name = "codePostal", value = "75000")
	private String codePostal;
	
	private static List<Adresse> adresses = new ArrayList<Adresse>();
	
	public AdresseBean() {
		adresses.clear();
	}

	public void addAdresse() {
		Adresse adresse = new Adresse();
		adresse.setNumero(numero);
		adresse.setRue(rue);
		adresse.setVille(ville);
		adresse.setCodePostal(codePostal);
		adresses.add(adresse);
	}
	
	public void initializeAdresse() {
		this.numero = "";
		this.rue = "";
		this.ville = "";
		this.codePostal = "";
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}
}
