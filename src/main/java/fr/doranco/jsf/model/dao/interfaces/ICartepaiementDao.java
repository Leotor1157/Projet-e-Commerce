package fr.doranco.jsf.model.dao.interfaces;

import java.util.List;

import fr.doranco.jsf.entity.CartePaiement;

public interface ICartepaiementDao {

	void createCartepaiement(CartePaiement cartepaiement) throws Exception;
	CartePaiement getCartepaiement(Integer id) throws Exception;
	List<CartePaiement> getCartesPaiements(Integer userId) throws Exception;
    void updateCartepaiement(CartePaiement cartepaiement) throws Exception;
    void deleteCartepaiement(CartePaiement cartepaiement) throws Exception;
}
