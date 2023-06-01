package fr.doranco.jsf.model.dao.impl;

import java.util.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.doranco.jsf.entity.Commande;
import fr.doranco.jsf.model.connection.DataBaseConnection;
import fr.doranco.jsf.model.dao.interfaces.ICommandeDao;

public class CommandeDao implements ICommandeDao {

    @Override
    public void createCommande(Commande commande) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "INSERT INTO commande(numero, date_creation, date_livraison, total_remise, frais_expedition, "
                    + "total_general, adresse_facturation, adresse_livraison, user_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, commande.getNumero());
            ps.setDate(2, new java.sql.Date(commande.getDateCreation().getTime()));
            ps.setDate(3, new java.sql.Date(commande.getDateLivraison().getTime()));
            ps.setString(4, commande.getTotalRemise());
            ps.setString(5, commande.getFraisExpedition());
            ps.setString(6, commande.getTotalGeneral());
            ps.setString(7, commande.getAdresseFacturation());
            ps.setString(8, commande.getAdresseLivraison());
            ps.setInt(9, commande.getUserId());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                int id = rs.getInt(1);
                commande.setId(id);
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
    public Commande getCommande(Integer id) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Commande commande = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "SELECT * FROM commande WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Integer numero = rs.getInt("numero");
                Date dateCreation = rs.getDate("date_creation");
                Date dateLivraison = rs.getDate("date_livraison");
                String totalRemise = rs.getString("total_remise");
                String fraisExpedition = rs.getString("frais_expedition");
                String totalGeneral = rs.getString("total_general");
                String adresseFacturation = rs.getString("adresse_facturation");
                String adresseLivraison = rs.getString("adresse_livraison");
                Integer userId = rs.getInt("user_id");

                commande = new Commande(numero, dateCreation, dateLivraison, totalRemise, fraisExpedition, totalGeneral,
                        adresseFacturation, adresseLivraison, userId);
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
        return commande;
    }

    @Override
    public void updateCommande(Commande commande) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "UPDATE commande SET numero=?, date_creation=?, date_livraison=?, total_remise=?, frais_expedition=?, "
                    + "total_general=?, adresse_facturation=?, adresse_livraison=?, user_id=? WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, commande.getNumero());
            ps.setDate(2, new java.sql.Date(commande.getDateCreation().getTime()));
            ps.setDate(3, new java.sql.Date(commande.getDateLivraison().getTime()));
            ps.setString(4, commande.getTotalRemise());
            ps.setString(5, commande.getFraisExpedition());
            ps.setString(6, commande.getTotalGeneral());
            ps.setString(7, commande.getAdresseFacturation());
            ps.setString(8, commande.getAdresseLivraison());
            ps.setInt(9, commande.getUserId());
            ps.setInt(10, commande.getId());

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
    public void deleteCommande(Commande commande) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "DELETE FROM commande WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, commande.getId());

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