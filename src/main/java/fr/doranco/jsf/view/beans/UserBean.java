package fr.doranco.jsf.view.beans;

import java.io.Serializable;
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

	private String nom;

	private String prenom;

	private Date dateNaissance;

	private ProfilEnum profil;

	private String email;

	private String password;
	private String passwordConfirmation;

	private String telephone;

	@ManagedProperty(name = "isActif", value = "false")
	private Boolean isActif;

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
			messageError = "Erreur lors de la récupération de la liste des utilisateurs !\n" + e.getMessage();
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

			userMetier.addUser(user);

			messageSuccess = "Compte créé avec succès.";
			messageError = "";

			adresseBean.getAdresses().clear();
			adresseBean.initializeAdresse();
			cartePaiementBean.getCartePaiements().clear();
			cartePaiementBean.initializeCartePaiement();
			initializeUser();

			// return "";
			if (profil.equals(ProfilEnum.ADMIN)) {
				return "";

			} else {
				return "login.xhtml";
			}
		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Erreur lors de la création de l'utilisateur !\n" + e.getMessage();
			e.printStackTrace();
			return "";
		}
	}
	
	public String addAdminUser() {

		try {

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

			userMetier.addUser(user);

			messageSuccess = "Compte créé avec succès.";
			messageError = "";

			adresseBean.getAdresses().clear();
			adresseBean.initializeAdresse();
			cartePaiementBean.getCartePaiements().clear();
			cartePaiementBean.initializeCartePaiement();
			initializeUser();		

				return "";
			
		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Erreur lors de la création de l'utilisateur !\n" + e.getMessage();
			e.printStackTrace();
			return "";
		}
	}
	

	public String connexionUser() {
		try {

			User user = userMetier.getUserByEmail(email);
			nom = user.getNom();
			if (password.equals(user.getPassword())) {
				messageSuccess = "Mot de passe valide !";
				messageError = "";
				user.setIsActif(true);
				isActif = true;
				userMetier.updateUser(user);
				adresseBean.getAdresses().clear();
				adresseBean.initializeAdresse();
				cartePaiementBean.getCartePaiements().clear();
				cartePaiementBean.initializeCartePaiement();
				switch (user.getProfil()) {
				case CLIENT:
					initializeUser();
					messageSuccess = "";
					messageError = "";
					return "gestion_achats.xhtml";

				case MAGASINIER:
					initializeUser();
					messageSuccess = "";
					messageError = "";
					return "gestion_articles.xhtml";

				case ADMIN:
					initializeUser();
					messageSuccess = "";
					messageError = "";
					return "gestion_admin.xhtml";

				default:
					initializeUser();
					messageSuccess = "";
					messageError = "";
					return "gestion_achats.xhtml";

				}

			} else {
				messageSuccess = "";
				messageError = "Erreur mot de passe incorrect !\n";
				return "";
			}

		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Connexion impossible, essayer avec une autre email ou un autre mot de passe !\n"
					+ e.getMessage();
			e.printStackTrace();
			return "";
		}
	}

	public String DeconnexionUser() {
		try {
			User userActif = userMetier.getUserActif();
			User user = userMetier.getUserByEmail(userActif.getEmail());

			messageSuccess = "Utilisateur Deconnecter !";
			messageError = "";
			user.setIsActif(false);
			isActif = false;
			userMetier.updateUser(user);
			return "accueil.xhtml";

		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Connexion impossible, essayer avec une autre email ou un autre mot de passe !\n"
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
			messageError = "Erreur lors de la suppression de l'utilisateur !\n" + e.getMessage();
			e.printStackTrace();
		}
	}

	private void initializeUser() {
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
		UserBean.adresseBean = adresseBean;
	}

	public CartePaiementBean getCartePaiementBean() {
		return cartePaiementBean;
	}

	public void setCartePaiementBean(CartePaiementBean cartePaiementBean) {
		UserBean.cartePaiementBean = cartePaiementBean;
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

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
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
