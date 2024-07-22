/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Review;
import util.DBConnection;

public class ReviewDao {

    public void save(Review review) {
        String query = "INSERT INTO reviews (comment, rating) VALUES (?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, review.getComment());
            preparedStatement.setInt(2, review.getRating());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Review> findAll() {
        List<Review> reviews = new ArrayList<>();
        String query = "SELECT * FROM reviews";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Review review = new Review();
                review.setId(resultSet.getInt("id"));
                review.setComment(resultSet.getString("comment"));
                review.setRating(resultSet.getInt("rating"));
                reviews.add(review);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviews;
    }
}
