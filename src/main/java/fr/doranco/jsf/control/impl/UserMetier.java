package fr.doranco.jsf.control.impl;

import java.util.List;

import fr.doranco.jsf.control.interfaces.IUserMetier;
import fr.doranco.jsf.entity.User;
import fr.doranco.jsf.enums.ProfilEnum;
import fr.doranco.jsf.model.dao.impl.UserDao;
import fr.doranco.jsf.model.dao.interfaces.IUserDao;

public class UserMetier implements IUserMetier {

	private final IUserDao userDao = new UserDao();
	
	@Override
	public User addUser(User user) throws Exception {
		if (user == null) {
			throw new NullPointerException("Le user à créer ne doit pas être null !");
		}
		user.setNom(user.getNom().toUpperCase());
		user.setPrenom(user.getPrenom().substring(0, 1).toUpperCase()
						.concat(user.getPrenom().substring(1).toLowerCase()));
		if(user.getIsActif() == null) {
		user.setIsActif(false);
		}
		if(user.getProfil() == null) {
			user.setProfil(ProfilEnum.CLIENT);
		}
		return userDao.addUser(user);
	}

	@Override
	public List<User> getUsers() throws Exception {
		return userDao.getUsers();
	}

	@Override
	public void deleteUser(User user) throws Exception {
		userDao.deleteUser(user.getId());
		
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		return userDao.getUserByEmail(email);
	}

	@Override
	public void updateUser(User user) throws Exception {
	userDao.updateUser(user);
		
	}

	@Override
	public User getUserActif() throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUserActif();
	}
}
