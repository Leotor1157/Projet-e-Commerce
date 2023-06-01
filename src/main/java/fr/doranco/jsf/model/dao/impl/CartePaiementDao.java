package fr.doranco.jsf.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.doranco.jsf.entity.CartePaiement;
import fr.doranco.jsf.model.connection.DataBaseConnection;
import fr.doranco.jsf.model.dao.interfaces.ICartepaiementDao;
import fr.doranco.jsf.utils.Dates;

public class CartePaiementDao implements ICartepaiementDao {

    @Override
    public void createCartepaiement(CartePaiement cartepaiement) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "INSERT INTO carte_paiement(nom_proprietaire, prenom_proprietaire, numero, date_fin_validite, cryptogramme, utilisateur_id) VALUES(?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cartepaiement.getNomProprietaire());
            ps.setString(2, cartepaiement.getPrenomProprietaire());
            ps.setString(3, cartepaiement.getNumero());
            ps.setDate(4, Dates.convertDateUtilToSql(cartepaiement.getDateFinValidite()));
            ps.setString(5, cartepaiement.getCryptogramme());
            ps.setInt(6, cartepaiement.getUserId());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                int id = rs.getInt(1);
                cartepaiement.setId(id);
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
    }

    @Override
    public CartePaiement getCartepaiement(Integer id) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CartePaiement cartepaiement = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "SELECT * FROM carte_paiement WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                String nomProprietaire = rs.getString("nom_proprietaire");
                String prenomProprietaire = rs.getString("prenom_proprietaire");
                String numero = rs.getString("numero");
                java.util.Date dateFinValidite = rs.getDate("date_fin_validite");
                String cryptogramme = rs.getString("cryptogramme");
                int userId = rs.getInt("user_id");

                cartepaiement = new CartePaiement();
                cartepaiement.setId(id);
                cartepaiement.setNomProprietaire(nomProprietaire);
                cartepaiement.setPrenomProprietaire(prenomProprietaire);
                cartepaiement.setNumero(numero);
                cartepaiement.setDateFinValidite(dateFinValidite);
                cartepaiement.setCryptogramme(cryptogramme);
                cartepaiement.setUserId(userId);
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
        return cartepaiement;
    }

    @Override
    public void updateCartepaiement(CartePaiement cartepaiement) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "UPDATE carte_paiement SET nom_proprietaire=?, prenom_proprietaire=?, numero=?, date_fin_validite=?, cryptogramme=?, user_id=? WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, cartepaiement.getNomProprietaire());
            ps.setString(2, cartepaiement.getPrenomProprietaire());
            ps.setString(3, cartepaiement.getNumero());
            
            ps.setDate(4, new java.sql.Date(cartepaiement.getDateFinValidite().getTime()));
            ps.setString(5, cartepaiement.getCryptogramme());
            ps.setInt(6, cartepaiement.getUserId());
            ps.setInt(7, cartepaiement.getId());

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
    public void deleteCartepaiement(CartePaiement cartepaiement) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "DELETE FROM carte_paiement WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, cartepaiement.getId());

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