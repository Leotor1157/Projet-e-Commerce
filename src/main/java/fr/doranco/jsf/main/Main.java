package fr.doranco.jsf.main;

import fr.doranco.jsf.entity.User;
import fr.doranco.jsf.enums.ProfilEnum;
import fr.doranco.jsf.model.dao.impl.UserDao;
import fr.doranco.jsf.model.dao.interfaces.IUserDao;
import fr.doranco.jsf.utils.Dates;

public class Main {

	public static void main(String[] args) {
		
		IUserDao userImpl = new UserDao();
		
		try {
			User userDto = new User("CAMUS", "Albert", Dates.convertStringToDate("02/02/2020"), true, ProfilEnum.CLIENT, "camus@gmail.com", "camus", "0606060606");
			User user1 = userImpl.addUser(userDto);
			System.out.println(user1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
