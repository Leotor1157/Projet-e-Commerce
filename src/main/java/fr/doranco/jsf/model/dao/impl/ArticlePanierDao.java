package fr.doranco.jsf.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.doranco.jsf.entity.ArticlePanier;
import fr.doranco.jsf.model.connection.DataBaseConnection;
import fr.doranco.jsf.model.dao.interfaces.IArticlePanierDao;

public class ArticlePanierDao implements IArticlePanierDao {

    @Override
    public void createArticlePanier(ArticlePanier articlePanier) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "INSERT INTO article_panier(quantite, user_id) VALUES(?, ?)";
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, articlePanier.getQuantite());
            ps.setInt(2, articlePanier.getUserId());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                int id = rs.getInt(1);
                articlePanier.setId(id);
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
    public ArticlePanier getArticlePanier(Integer id) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArticlePanier articlePanier = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "SELECT * FROM article_panier WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                String quantite = rs.getString("quantite");
                int userId = rs.getInt("user_id");

                articlePanier = new ArticlePanier(id, quantite, userId);         
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
        return articlePanier;
    }

    @Override
    public void updateArticlePanier(ArticlePanier articlePanier) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "UPDATE article_panier SET quantite=?, user_id=? WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, articlePanier.getQuantite());
            ps.setInt(2, articlePanier.getUserId());
            ps.setInt(3, articlePanier.getId());

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
    public void deleteArticlePanier(ArticlePanier articlePanier) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "DELETE FROM article_panier WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, articlePanier.getId());

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