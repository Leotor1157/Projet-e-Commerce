package fr.doranco.jsf.control.interfaces;

import java.util.List;

import fr.doranco.jsf.entity.Adresse;

public interface IAdresseMetier {

	int addAdresse(Adresse adresse, int userId) throws Exception;
	Adresse getAdresse(int id) throws Exception;
	List<Adresse> getAdresses(int userId) throws Exception;
	void updateAdresse(Adresse adresse) throws Exception;
	void deleteAdresse(int id) throws Exception;
	void deleteAdresses(int userId) throws Exception;
}
