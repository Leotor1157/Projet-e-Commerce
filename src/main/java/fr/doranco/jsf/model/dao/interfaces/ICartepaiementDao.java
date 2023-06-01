package fr.doranco.jsf.model.dao.interfaces;

import fr.doranco.jsf.entity.CartePaiement;

public interface ICartepaiementDao {

	void createCartepaiement(CartePaiement cartepaiement);
	CartePaiement getCartepaiement(Integer id);
    void updateCartepaiement(CartePaiement cartepaiement);
    void deleteCartepaiement(CartePaiement cartepaiement);
}
