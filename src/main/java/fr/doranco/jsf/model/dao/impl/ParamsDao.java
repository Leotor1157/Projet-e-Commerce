package fr.doranco.jsf.model.dao.impl;

import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.crypto.spec.SecretKeySpec;

import fr.doranco.jsf.entity.Params;
import fr.doranco.jsf.model.connection.DataBaseConnection;
import fr.doranco.jsf.model.dao.interfaces.IParamsDao;

public class ParamsDao implements IParamsDao {

	@Override
	public Integer addParams(Params params) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = -1;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "INSERT INTO params(cle_cryptage_pwd, cle_cryptage_cp) " + "VALUES(?,?)";
			ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setBytes(1, params.getCle_cryptage_pwd().getEncoded());
			ps.setBytes(2, params.getCle_cryptage_cp().getEncoded());

			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
				params.setId(id);
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
	public Key getKeyPwd() throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Key key = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT cle_cryptage_pwd FROM params";
			ps = connection.prepareStatement(requete);

			ps.execute();

			rs = ps.getResultSet();

			if (rs != null && rs.next()) {
			}

			key = new SecretKeySpec(rs.getBytes("cle_cryptage_pwd"), 0, 56, "DES");
			;

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
		return key;
	}

	@Override
	public Key getKeyCb() throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Key key = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT cle_cryptage_pwd FROM params";
			ps = connection.prepareStatement(requete);

			ps.execute();

			rs = ps.getResultSet();

			if (rs != null && rs.next()) {
			}

			key = new SecretKeySpec(rs.getBytes("cle_cryptage_pwd"), 0, 56, "DES");
			

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
		return key;
	}

	@Override
	public Integer getKeyId() throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer id = -1;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT id FROM params";
			ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

			ps.execute();
			rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
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
}
