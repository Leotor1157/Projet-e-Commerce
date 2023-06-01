package fr.doranco.jsf.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.doranco.jsf.entity.Categorie;
import fr.doranco.jsf.model.connection.DataBaseConnection;
import fr.doranco.jsf.model.dao.interfaces.ICategorieDao;

public class CategorieDao implements ICategorieDao {

    @Override
    public void createCategorie(Categorie categorie) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "INSERT INTO categorie(nom, remise, is_remise_cumulable, photo) VALUES(?, ?, ?, ?)";
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, categorie.getNom());
            ps.setInt(2, categorie.getRemise());
            ps.setBoolean(3, categorie.getIsRemiseCumulable());
            ps.setString(4, categorie.getPhoto());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                int id = rs.getInt(1);
                categorie.setId(id);
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
    public Categorie getCategorie(Integer id) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Categorie categorie = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "SELECT * FROM categorie WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nom");
                int remise = rs.getInt("remise");
                boolean isRemiseCumulable = rs.getBoolean("is_remise_cumulable");
                String photo = rs.getString("photo");

                categorie = new Categorie(nom, remise, isRemiseCumulable, photo);
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
        return categorie;
    }

    @Override
    public void updateCategorie(Categorie categorie) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "UPDATE categorie SET nom=?, remise=?, is_remise_cumulable=?, photo=? WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, categorie.getNom());
            ps.setInt(2, categorie.getRemise());
            ps.setBoolean(3, categorie.getIsRemiseCumulable());
            ps.setString(4, categorie.getPhoto());
            ps.setInt(5, categorie.getId());

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
    public void deleteCategorie(Categorie categorie) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DataBaseConnection.getConnection();
            String query = "DELETE FROM categorie WHERE id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, categorie.getId());

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