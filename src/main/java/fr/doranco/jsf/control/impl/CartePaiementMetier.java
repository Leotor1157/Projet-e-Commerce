package fr.doranco.jsf.control.impl;

import java.util.List;

import fr.doranco.jsf.control.interfaces.ICartePaiementMetier;
import fr.doranco.jsf.entity.CartePaiement;
import fr.doranco.jsf.model.dao.impl.CartePaiementDao;
import fr.doranco.jsf.model.dao.interfaces.ICartepaiementDao;

public class CartePaiementMetier implements ICartePaiementMetier{
	
	public static ICartepaiementDao cartePaiementDao = new CartePaiementDao();

	@Override
	public void createCartepaiement(CartePaiement cartepaiement) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartePaiement getCartepaiement(Integer id) throws Exception {
		return null ;
	}

	@Override
	public List<CartePaiement> getCartesPaiements(Integer userId) throws Exception {
		return cartePaiementDao.getCartesPaiements(userId);
	}

	@Override
	public void updateCartepaiement(CartePaiement cartepaiement) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCartepaiement(CartePaiement cartepaiement) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
