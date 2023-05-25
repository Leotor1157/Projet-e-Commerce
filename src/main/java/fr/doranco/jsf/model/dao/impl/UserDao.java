package fr.doranco.jsf.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import fr.doranco.jsf.entity.Adresse;
import fr.doranco.jsf.entity.User;
import fr.doranco.jsf.model.connection.DataBaseConnection;
import fr.doranco.jsf.model.dao.interfaces.IAdresseDao;
import fr.doranco.jsf.model.dao.interfaces.IUserDao;
import fr.doranco.jsf.utils.Dates;

public class UserDao implements IUserDao {

	private final IAdresseDao adresseDao = new AdresseDao();
	
	@Override
	public User addUser(User user) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = DataBaseConnection.getConnection();
			
			String requete = "INSERT INTO user(genre, prenom, nom, date_naissance, email, password, niveau_service, langages)"
					+ " VALUES(?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getGenre());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getNom());
			ps.setDate(4, Dates.convertDateUtilToSql(user.getDateNaissance()));
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getNiveauService());
			
			String langagesSouhaites = "";  // JAVA:PHP:C++
			for (String langage : user.getLangagesSouhaites()) {
				langagesSouhaites = langagesSouhaites.concat(langage).concat(":");
			}
			langagesSouhaites = langagesSouhaites.substring(0, langagesSouhaites.length() - 1);
			ps.setString(8, langagesSouhaites);
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
				user.setId(rs.getInt(1));
			}
			if (user.getAdresses() != null && !user.getAdresses().isEmpty()) {
				for (Adresse a : user.getAdresses()) {
					adresseDao.addAdresse(a, user.getId());
				}
			}
			
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		return user;
	}

	@Override
	public void deleteUser(int id) throws Exception {

		adresseDao.deleteAdresses(id);
		
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "DELETE FROM user WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, id);

			ps.executeUpdate();

		} finally {

			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public List<User> getUsers() throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM user";
			ps = connection.prepareStatement(requete);

			ps.execute();
			rs = ps.getResultSet();

			if (rs != null) {
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setGenre(rs.getString("genre"));
					user.setPrenom(rs.getString("prenom"));
					user.setNom(rs.getString("nom"));
					user.setDateNaissance(Dates.convertDateSqlToUtil(rs.getDate("date_naissance")));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setNiveauService(rs.getString("niveau_service"));
					
					StringTokenizer tokenizer = new StringTokenizer(rs.getString("langages"), ":");
					while (tokenizer.hasMoreTokens()) {
						String value = tokenizer.nextToken();
						user.getLangagesSouhaites().add(value);
					}
					
					List<Adresse> adresses = adresseDao.getAdresses(rs.getInt("id"));
					for (Adresse a : adresses) {
						user.getAdresses().add(a);
					}
					users.add(user);
				}
			}
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		return users;
	}

}
