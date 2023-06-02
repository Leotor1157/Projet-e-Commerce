package fr.doranco.jsf.control.interfaces;

import java.util.List;

import fr.doranco.jsf.entity.CartePaiement;

public interface ICartePaiementMetier {

	void createCartepaiement(CartePaiement cartepaiement) throws Exception;
	CartePaiement getCartepaiement(Integer id) throws Exception;
	List<CartePaiement> getCartesPaiements(Integer userId) throws Exception;
    void updateCartepaiement(CartePaiement cartepaiement) throws Exception;
    void deleteCartepaiement(CartePaiement cartepaiement) throws Exception;
}
