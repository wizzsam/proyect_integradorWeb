/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author tomac
 */
import model.Reseña;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class ReseñaDao {
    private Connection connection;

    public ReseñaDao() {
        connection = DBConnection.getConnection();
    }

    public boolean addReseña(Reseña reseña) {
        String query = "INSERT INTO reseña (id_restaurante, ususario , descripcion, calificacion, imagen) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, reseña.getIdRestaurante());
            preparedStatement.setString(2, reseña.getUsuario());
            preparedStatement.setString(3, reseña.getDescripcion());
            preparedStatement.setInt(4, reseña.getCalificacion());
            preparedStatement.setString(5, reseña.getImagen());
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Reseña> getReseñasByRestaurante(int idRestaurante) {
        String query = "SELECT * FROM reseña WHERE id_restaurante = ?";
        List<Reseña> reseñas = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idRestaurante);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reseña reseña = new Reseña();
                reseña.setId(resultSet.getInt("id"));
                reseña.setIdRestaurante(resultSet.getInt("id_restaurante"));
                reseña.setUsuario(resultSet.getString("usuario"));
                reseña.setDescripcion(resultSet.getString("descripcion"));
                reseña.setCalificacion(resultSet.getInt("calificacion"));
                reseña.setImagen(resultSet.getString("imagen"));
                reseña.setFecha(resultSet.getTimestamp("fecha"));
                reseñas.add(reseña);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reseñas;
    }

    public List<Reseña> findAll() {
        String query = "SELECT * FROM reseña";
        List<Reseña> reseñas = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Reseña reseña = new Reseña();
                reseña.setId(resultSet.getInt("id"));
                reseña.setIdRestaurante(resultSet.getInt("id_restaurante"));
                reseña.setUsuario(resultSet.getString("Usuario"));
                reseña.setDescripcion(resultSet.getString("descripcion"));
                reseña.setCalificacion(resultSet.getInt("calificacion"));
                reseña.setImagen(resultSet.getString("imagen"));
                reseña.setFecha(resultSet.getTimestamp("fecha"));
                reseñas.add(reseña);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reseñas;
    }
}
