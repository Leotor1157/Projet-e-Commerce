package fr.doranco.jsf.model.dao.interfaces;

import java.util.List;

import fr.doranco.jsf.entity.User;

public interface IUserDao {

	User addUser(User user) throws Exception;
	void deleteUser(int id) throws Exception;
	User getUserByEmail(String email) throws Exception;
	void updateUser(User user) throws Exception;
	List<User> getUsers() throws Exception;
}
