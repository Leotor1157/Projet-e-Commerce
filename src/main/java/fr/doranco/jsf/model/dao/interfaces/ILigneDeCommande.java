package fr.doranco.jsf.model.dao.interfaces;

import fr.doranco.jsf.entity.LigneDeCommande;

public interface ILigneDeCommande {

	void createLigneDeCommande(LigneDeCommande ligneDeCommande) throws Exception;
	LigneDeCommande getLigneDeCommande(Integer id) throws Exception;
    void updateLigneDeCommande(LigneDeCommande ligneDeCommande) throws Exception;
    void deleteLigneDeCommande(LigneDeCommande ligneDeCommande) throws Exception;
}
