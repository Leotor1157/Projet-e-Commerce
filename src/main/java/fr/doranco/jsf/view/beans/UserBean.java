package fr.doranco.jsf.view.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.jsf.control.impl.UserMetier;
import fr.doranco.jsf.control.interfaces.IUserMetier;
import fr.doranco.jsf.entity.User;
import fr.doranco.jsf.enums.ProfilEnum;

@ManagedBean(name = "userbean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// injection de dépendance
	@ManagedProperty(value = "#{adressebean}")
	private static AdresseBean adresseBean;
	
	// injection de dépendance
	@ManagedProperty(value = "#{cartePaiementbean}")
	private static CartePaiementBean cartePaiementBean;
	
	@ManagedProperty(name = "nom", value = "DUPOND")
	private String nom;

	@ManagedProperty(name = "prenom", value = "Michel")
	private String prenom;

	private Date dateNaissance;
	
	private ProfilEnum profil;

	@ManagedProperty(name = "email", value = "michel.dupont@doranco.fr")
	private String email;

	private String password;
	private String passwordConfirmation;
	
	private String telephone;

	private String messageSuccess;
	private String messageError;

	private final IUserMetier userMetier = new UserMetier();

	public UserBean() {
		messageSuccess = "";
		messageError = "";
	}

	public List<User> getUsers() {
		try {
			return userMetier.getUsers();
		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Erreur lors de la récupération de la liste des utilisateurs !\n"
					+ e.getMessage();
			e.printStackTrace();
			return null;
		}
	}
	
	public String addUser() {

		try {
			if (!password.equals(passwordConfirmation)) {
				messageError = "Les deux mots de passe ne correspondent pas ! Veuillez réessayer.";
				messageSuccess = "";
				return "";
			}

			User user = new User();
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setDateNaissance(dateNaissance);
			user.setEmail(email);
			user.setProfil(profil);
			user.setPassword(password);
			user.setTelephone(telephone);

			adresseBean.getAdresses().forEach(a -> user.getAdresses().add(a));
			cartePaiementBean.getCartePaiements().forEach(a -> user.getCartesDePaiement().add(a));

			User addedUser = userMetier.addUser(user);

			messageSuccess = "Compte créé avec succès.";
			messageError = "";
			adresseBean.getAdresses().clear();
			adresseBean.initializeAdresse();
			initializeUser();

			//return "";
			return "login.xhtml";

		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Erreur lors de la création de l'utilisateur !\n"
					+ e.getMessage();
			e.printStackTrace();
			return "";
		}
	}

	public void deleteUser(User user) {
		try {
			userMetier.deleteUser(user);
			messageSuccess = "Utilisateur supprimé avec succès.";
			messageError = "";
		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Erreur lors de la suppression de l'utilisateur !\n"
					+ e.getMessage();
			e.printStackTrace();
		}
	}

	private void initializeUser() {
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.profil = ProfilEnum.CLIENT;
		this.telephone = "";
		this.dateNaissance = null;
	}

	public AdresseBean getAdresseBean() {
		return adresseBean;
	}

	public void setAdresseBean(AdresseBean adresseBean) {
		this.adresseBean = adresseBean;
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

	public ProfilEnum getProfil() {
		return profil;
	}

	public void setProfil(ProfilEnum profil) {
		this.profil = profil;
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

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
