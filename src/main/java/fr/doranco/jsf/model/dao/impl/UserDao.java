package fr.doranco.jsf.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.jsf.entity.Adresse;
import fr.doranco.jsf.entity.CartePaiement;
import fr.doranco.jsf.entity.User;
import fr.doranco.jsf.enums.ProfilEnum;
import fr.doranco.jsf.model.connection.DataBaseConnection;
import fr.doranco.jsf.model.dao.interfaces.IAdresseDao;
import fr.doranco.jsf.model.dao.interfaces.ICartepaiementDao;
import fr.doranco.jsf.model.dao.interfaces.IUserDao;
import fr.doranco.jsf.utils.Dates;

public class UserDao implements IUserDao {

	private final IAdresseDao adresseDao = new AdresseDao();
	private final ICartepaiementDao cartePaiementDao = new CartePaiementDao();

	@Override
	public User addUser(User user) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = DataBaseConnection.getConnection();

			String requete = "INSERT INTO utilisateur(prenom, nom, date_naissance, email, password, is_actif, profil, telephone )"
					+ " VALUES(?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getPrenom());
			ps.setString(2, user.getNom());
			ps.setDate(3, Dates.convertDateUtilToSql(user.getDateNaissance()));
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			ps.setBoolean(6, user.getIsActif());
			ps.setString(7, user.getProfil().toString());
			ps.setString(8, user.getTelephone());

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
			
			if (user.getCartesDePaiement() != null && !user.getCartesDePaiement().isEmpty()) {
				for (CartePaiement a : user.getCartesDePaiement()) {
					a.setUserId(user.getId());
					cartePaiementDao.createCartepaiement(a);
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
			String requete = "DELETE FROM utilisateur WHERE id = ?";
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
			String requete = "SELECT * FROM utilisateur";
			ps = connection.prepareStatement(requete);

			ps.execute();
			rs = ps.getResultSet();

			if (rs != null) {
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setPrenom(rs.getString("prenom"));
					user.setNom(rs.getString("nom"));
					user.setDateNaissance(Dates.convertDateSqlToUtil(rs.getDate("date_naissance")));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setTelephone(rs.getString("telephone"));
					user.setProfil(ProfilEnum.valueOf(rs.getString("profil")));
					user.setIsActif(rs.getBoolean("is_actif"));

					List<Adresse> adresses = adresseDao.getAdresses(rs.getInt("id"));
					for (Adresse a : adresses) {
						user.getAdresses().add(a);
					}
					
					List<CartePaiement> CartePaiements = cartePaiementDao.getCartesPaiements(rs.getInt("id"));
					for (CartePaiement a : CartePaiements) {
						user.getCartesDePaiement().add(a);
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

	@Override
	public User getUserByEmail(String email) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM utilisateur where email = ?";
			ps = connection.prepareStatement(requete);
			ps.setString(1, email);

			ps.execute();
			rs = ps.getResultSet();

			if (rs != null) {
				while (rs.next()) {
					user = new User();
					user.setId(rs.getInt("id"));
					user.setPrenom(rs.getString("prenom"));
					user.setNom(rs.getString("nom"));
					user.setDateNaissance(Dates.convertDateSqlToUtil(rs.getDate("date_naissance")));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setTelephone(rs.getString("telephone"));
					user.setProfil(ProfilEnum.valueOf(rs.getString("profil")));
					user.setIsActif(rs.getBoolean("is_actif"));

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
	public void updateUser(User user) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "UPDATE utilisateur SET nom = ?, prenom = ?, date_naissance = ?, is_actif = ?, "
						+ "profil = ?, email = ?, password = ?, telephone = ? " + "WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setDate(3, Dates.convertDateUtilToSql(user.getDateNaissance()));
			ps.setBoolean(4, user.getIsActif());
			ps.setString(5, user.getProfil().toString());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getPassword());
			ps.setString(8, user.getTelephone());
			ps.setInt(9, user.getId());

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
	public User getUserActif() throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM utilisateur where is_actif = 1";
			ps = connection.prepareStatement(requete);

			ps.execute();
			rs = ps.getResultSet();

			if (rs != null) {
				while (rs.next()) {
					user = new User();
					user.setId(rs.getInt("id"));
					user.setPrenom(rs.getString("prenom"));
					user.setNom(rs.getString("nom"));
					user.setDateNaissance(Dates.convertDateSqlToUtil(rs.getDate("date_naissance")));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setTelephone(rs.getString("telephone"));
					user.setProfil(ProfilEnum.valueOf(rs.getString("profil")));
					user.setIsActif(rs.getBoolean("is_actif"));

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
}