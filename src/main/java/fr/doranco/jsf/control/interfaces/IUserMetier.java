package fr.doranco.jsf.control.interfaces;

import java.util.List;

import fr.doranco.jsf.entity.User;

public interface IUserMetier {

	User addUser(User user) throws Exception;
	List<User> getUsers() throws Exception;
	void deleteUser(User user) throws Exception;
}
