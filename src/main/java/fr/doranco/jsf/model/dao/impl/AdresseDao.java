package fr.doranco.jsf.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.jsf.entity.Adresse;
import fr.doranco.jsf.model.connection.DataBaseConnection;
import fr.doranco.jsf.model.dao.interfaces.IAdresseDao;

public class AdresseDao implements IAdresseDao {

	@Override
	public int addAdresse(Adresse adresse, int userId) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = -1;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "INSERT INTO adresse(numero, rue, ville, code_postal, user_id) " + "VALUES(?,?,?,?,?)";
			ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, adresse.getNumero());
			ps.setString(2, adresse.getRue());
			ps.setString(3, adresse.getVille());
			ps.setString(4, adresse.getCodePostal());
			ps.setInt(5, userId);

			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
				adresse.setId(id);
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
		return id;
	}

	@Override
	public Adresse getAdresse(int id) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Adresse adresse = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM adresse WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, id);

			ps.execute();

			rs = ps.getResultSet();

			if (rs != null && rs.next()) {
				adresse = new Adresse();
				adresse.setId(rs.getInt("id"));
				adresse.setNumero(rs.getString("numero"));
				adresse.setRue(rs.getString("rue"));
				adresse.setVille(rs.getString("ville"));
				adresse.setCodePostal(rs.getString("code_postal"));
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
		return adresse;
	}

	@Override
	public List<Adresse> getAdresses(int userId) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Adresse> adresses = new ArrayList<Adresse>();
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM adresse WHERE user_id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, userId);

			ps.execute();

			rs = ps.getResultSet();

			if (rs != null) {
				while (rs.next()) {
					Adresse adresse = new Adresse();
					adresse.setId(rs.getInt("id"));
					adresse.setNumero(rs.getString("numero"));
					adresse.setRue(rs.getString("rue"));
					adresse.setVille(rs.getString("ville"));
					adresse.setCodePostal(rs.getString("code_postal"));
					adresses.add(adresse);
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
		return adresses;
	}

	@Override
	public void updateAdresse(Adresse adresse) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "UPDATE adresse SET numero = ?, rue = ?, ville = ?, code_postal = ? "
					+ "WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setString(1, adresse.getNumero());
			ps.setString(2, adresse.getRue());
			ps.setString(3, adresse.getVille());
			ps.setString(4, adresse.getCodePostal());
			ps.setInt(5, adresse.getId());

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
	public void deleteAdresse(int id) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "DELETE FROM adresse WHERE id = ?";
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
	public void deleteAdresses(int userId) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "DELETE FROM adresse WHERE user_id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, userId);

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

}
