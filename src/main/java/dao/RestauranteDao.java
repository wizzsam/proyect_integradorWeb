/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Restaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class RestauranteDao {

    public void save(Restaurante restaurante) {
        String query = "INSERT INTO restaurante (nombre_restaurante1, nombre_restaurante2, tipo_comida1, comida_dia, tipo_establecimiento, direccion_restaurante, telefono, pagina_web, precio, imagen1, imagen2, imagen3, pais, ciudad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, restaurante.getNombreRestaurante1());
            preparedStatement.setString(2, restaurante.getNombreRestaurante2());
            preparedStatement.setString(3, restaurante.getTipoComida1());
            preparedStatement.setString(4, restaurante.getComidaDia());
            preparedStatement.setString(5, restaurante.getTipoEstablecimiento());
            preparedStatement.setString(6, restaurante.getDireccionRestaurante());
            preparedStatement.setString(7, restaurante.getTelefono());
            preparedStatement.setString(8, restaurante.getPaginaWeb());
            preparedStatement.setString(9, restaurante.getPrecio());
            preparedStatement.setString(10, restaurante.getImagen1());
            preparedStatement.setString(11, restaurante.getImagen2());
            preparedStatement.setString(12, restaurante.getImagen3());
            preparedStatement.setString(13, restaurante.getPais());
            preparedStatement.setString(14, restaurante.getCiudad());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Restaurante> findAll() {
        List<Restaurante> restaurantes = new ArrayList<>();
        String query = "SELECT * FROM restaurante";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Restaurante restaurante = new Restaurante();
                restaurante.setId(resultSet.getInt("id"));
                restaurante.setNombreRestaurante1(resultSet.getString("nombre_restaurante1"));
                restaurante.setNombreRestaurante2(resultSet.getString("nombre_restaurante2"));
                restaurante.setTipoComida1(resultSet.getString("tipo_comida1"));
                restaurante.setComidaDia(resultSet.getString("comida_dia"));
                restaurante.setTipoEstablecimiento(resultSet.getString("tipo_establecimiento"));
                restaurante.setDireccionRestaurante(resultSet.getString("direccion_restaurante"));
                restaurante.setTelefono(resultSet.getString("telefono"));
                restaurante.setPaginaWeb(resultSet.getString("pagina_web"));
                restaurante.setPrecio(resultSet.getString("precio"));
                restaurante.setImagen1(resultSet.getString("imagen1"));
                restaurante.setImagen2(resultSet.getString("imagen2"));
                restaurante.setImagen3(resultSet.getString("imagen3"));
                restaurante.setPais(resultSet.getString("pais"));
                restaurante.setCiudad(resultSet.getString("ciudad"));
                restaurantes.add(restaurante);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurantes;
    }
}