package fr.doranco.jsf.control.impl;

import java.util.List;

import fr.doranco.jsf.control.interfaces.IAdresseMetier;
import fr.doranco.jsf.entity.Adresse;
import fr.doranco.jsf.model.dao.impl.AdresseDao;
import fr.doranco.jsf.model.dao.interfaces.IAdresseDao;

public class AdresseMetier implements IAdresseMetier{
	
	private final IAdresseDao adresseDao = new AdresseDao();

	@Override
	public int addAdresse(Adresse adresse, int userId) throws Exception {
		if(adresse == null){
			throw new NullPointerException("Le user à créer ne doit pas être null !");
		}
		
		return adresseDao.addAdresse(adresse, userId);
	}

	@Override
	public Adresse getAdresse(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adresse> getAdresses(int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAdresse(Adresse adresse) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdresse(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdresses(int userId) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
