package fr.doranco.jsf.model.dao.interfaces;

import fr.doranco.jsf.entity.CartePaiement;

public interface ICartepaiementDao {

	void createCartepaiement(CartePaiement cartepaiement) throws Exception;
	CartePaiement getCartepaiement(Integer id) throws Exception;
    void updateCartepaiement(CartePaiement cartepaiement) throws Exception;
    void deleteCartepaiement(CartePaiement cartepaiement) throws Exception;
}
