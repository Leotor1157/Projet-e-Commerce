package fr.doranco.jsf.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.jsf.entity.Article;
import fr.doranco.jsf.model.connection.DataBaseConnection;
import fr.doranco.jsf.model.dao.interfaces.IArticleDao;

public class ArticleDao implements IArticleDao {

    @Override
    public void createArticle(Article article) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "INSERT INTO article(nom, description, prix, remise, stock, is_vendable, photos, videos) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, article.getNom());
            ps.setString(2, article.getDescription());
            ps.setString(3, article.getPrix());
            ps.setString(4, article.getRemise());
            ps.setString(5, article.getStock());
            ps.setBoolean(6, article.getIsVendable());
            ps.setString(7, article.getPhotos());
            ps.setString(8, article.getVideos());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                int id = rs.getInt(1);
                article.setId(id);
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
    public Article getArticle(Integer id) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Article article = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "SELECT * FROM article WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                String prix = rs.getString("prix");
                String remise = rs.getString("remise");
                String stock = rs.getString("stock");
                Boolean isVendable = rs.getBoolean("is_vendable");
                String photos = rs.getString("photos");
                String videos = rs.getString("videos");

                article = new Article(id, nom, description, prix, remise, stock, isVendable, photos, videos);
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
        return article;
    }

    @Override
    public void updateArticle(Article article) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "UPDATE article SET nom=?, description=?, prix=?, remise=?, stock=?, is_vendable=?, photos=?, videos=? WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, article.getNom());
            ps.setString(2, article.getDescription());
            ps.setString(3, article.getPrix());
            ps.setString(4, article.getRemise());
            ps.setString(5, article.getStock());
            ps.setBoolean(6, article.getIsVendable());
            ps.setString(7, article.getPhotos());
            ps.setString(8, article.getVideos());
            ps.setInt(9, article.getId());

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
    public void deleteArticle(Article article) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "DELETE FROM article WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, article.getId());

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
    public List<Article> getAllArticles() throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Article> articles = new ArrayList<>();
        try {
            connection = DataBaseConnection.getConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM article";
            rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                String prix = rs.getString("prix");
                String remise = rs.getString("remise");
                String stock = rs.getString("stock");
                Boolean isVendable = rs.getBoolean("is_vendable");
                String photos = rs.getString("photos");
                String videos = rs.getString("videos");

                Article article = new Article(id, nom, description, prix, remise, stock, isVendable, photos, videos);
                articles.add(article);
            }
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return articles;
    }
}