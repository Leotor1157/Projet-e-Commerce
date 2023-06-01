package fr.doranco.jsf.model.dao.interfaces;

import fr.doranco.jsf.entity.Commande;

public interface ICommandeDao {

	void createCommande(Commande commande) throws Exception;
	Commande getCommande(Integer id) throws Exception;
    void updateCommande(Commande commande) throws Exception;
    void deleteCommande(Commande commande) throws Exception;
}
