package fr.doranco.jsf.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.doranco.jsf.entity.LigneDeCommande;
import fr.doranco.jsf.model.dao.interfaces.ILigneDeCommande;
import fr.doranco.jsf.model.connection.DataBaseConnection;

public class LigneDeCommandeDao implements ILigneDeCommande {

    @Override
    public void createLigneDeCommande(LigneDeCommande ligneDeCommande) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "INSERT INTO lignedecommande (quantite, prix_unitaire, remise_article) VALUES (?, ?, ?)";
            ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ligneDeCommande.getQuantite());
            ps.setString(2, ligneDeCommande.getPrixUnitaire());
            ps.setString(3, ligneDeCommande.getRemiseArticle());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                ligneDeCommande.setId(generatedId);
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
    public LigneDeCommande getLigneDeCommande(Integer id) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LigneDeCommande ligneDeCommande = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "SELECT * FROM lignedecommande WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Integer quantite = rs.getInt("quantite");
                String prixUnitaire = rs.getString("prix_unitaire");
                String remiseArticle = rs.getString("remise_article");

                ligneDeCommande = new LigneDeCommande(id, quantite, prixUnitaire, remiseArticle);
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
        return ligneDeCommande;
    }

    @Override
    public void updateLigneDeCommande(LigneDeCommande ligneDeCommande) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "UPDATE lignedecommande SET quantite=?, prix_unitaire=?, remise_article=? WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, ligneDeCommande.getQuantite());
            ps.setString(2, ligneDeCommande.getPrixUnitaire());
            ps.setString(3, ligneDeCommande.getRemiseArticle());
            ps.setInt(4, ligneDeCommande.getId());

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
    public void deleteLigneDeCommande(LigneDeCommande ligneDeCommande) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "DELETE FROM lignedecommande WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, ligneDeCommande.getId());

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